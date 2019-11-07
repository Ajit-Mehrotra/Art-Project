import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

public class TestFrame extends JFrame {

	protected long startTime = new Date().getTime();
	BufferedImage backgroundImage;
	BufferedImage gokuImage;
	BufferedImage kaiokenImage;
	BufferedImage ssgImage;
	BufferedImage ssjImage;
	BufferedImage ssj2Image;
	BufferedImage ssbImage;
	BufferedImage ssbkImage;
	List<Color> colors = new ArrayList<Color>();

	private int timePassed = 0;
	private int Xpicturelocation = (int) (Math.random() * 1346);
	private int Ypicturelocation = (int) (Math.random() * 444);
	private int red = 0, green = 255, blue = 255;
	private int totalRotations = 0;

	private boolean kaioken;
	private int ssj = 0;
	private int ssj2 = 0;
	private int ssg = 0;
	private int ssb = 0;
	private boolean ssbk = true;

	public class MainPanel extends JPanel {

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			int height = (int) (100 + timePassed);
			int maxDiff = 350;
			Graphics2D OG = (Graphics2D) g;

			initImage();

			OG.drawImage(backgroundImage, 0, 0, this);

			// calculate elapsed time
			// long currentTime = new Date().getTime();
			// long timeDiff = currentTime - TestFrame.this.startTime;

			// System.out.println("XPicLoc: " + Xpicturelocation);
			// System.out.println("YPicLoc: " + Ypicturelocation);

			OG.drawImage(gokuImage, Xpicturelocation, Ypicturelocation, this);

			if (totalRotations > 0) {
				OG.drawImage(kaiokenImage, Xpicturelocation - 150, Ypicturelocation - 10, this);
				maxDiff += 50;
				timePassed += 100;
				kaioken = true;
			}

			Random randomNum = new Random();
			// g.setColor(colors.get( randomNum.nextInt(colors.size()) ));
			// System.out.println("Red: " + red + "Green: " + green + "Blue: " + blue );
			g.setColor(new Color(red, green, blue));
			if (pressed('g')) {
				OG.drawImage(ssgImage, Xpicturelocation - 120, Ypicturelocation - 120, this);
				if (maxDiff < 600) {
					maxDiff = 600;
				}
				timePassed += 100;
				g.setColor(Color.red);
			}
			if (pressed('j')) {
				OG.drawImage(ssjImage, Xpicturelocation - 220, Ypicturelocation - 120, this);
				if (maxDiff < 450) {
					maxDiff = 450;
				}
				timePassed += 40;
				g.setColor(Color.yellow);
			}
			if (pressed('s')) {
				OG.drawImage(ssj2Image, Xpicturelocation - 130, Ypicturelocation - 160, this);
				if (maxDiff < 550) {
					maxDiff = 550;
				}
				timePassed += 60;
				g.setColor(Color.yellow);
			}
			if (pressed('b')) {
				if (kaioken) {
					OG.drawImage(ssbkImage, Xpicturelocation - 110, Ypicturelocation - 280, this);
					OG.drawImage(gokuImage, Xpicturelocation, Ypicturelocation, this);
					if (maxDiff < 1000) {
						maxDiff = 1000;
					}
					timePassed += 180;
					g.setColor(new Color(255, 0, 100));
				} else {
					OG.drawImage(ssbImage, Xpicturelocation - 150, Ypicturelocation - 180, this);
					OG.drawImage(gokuImage, Xpicturelocation, Ypicturelocation, this);
					if (maxDiff < 750) {
						maxDiff = 750;
					}
					timePassed += 150;
					g.setColor(Color.cyan);
				}

			}
			// animation time dependent

			// g.fillOval(x,y, width, height);

			if (height >= maxDiff) {
				g.fillOval((int) ((Xpicturelocation + 165) + timePassed / 10),
						(int) ((Ypicturelocation + (120)) - maxDiff / 2), 1400, maxDiff);
			} else {
				g.fillOval((int) ((Xpicturelocation + 165) + timePassed / 10),
						(int) ((Ypicturelocation + 78) - timePassed / 2), 1400, (int) (100 + timePassed));
			}

			// g.fillRect((int) (timeDiff / 100), 10, 10, 10);
		}
	}

	public static void main(String[] args) {
		new TestFrame();
	}

	public TestFrame() {
		// init window
		initColorList();
		this.setTitle("Test");
		this.setSize(1600, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(new MainPanel());
		this.addKeyListener(new keyListener());
		this.addMouseWheelListener(new mouseWheelListener());
		this.setVisible(true);

		new Thread() {
			public void run() {
				while (true) {
					// trigger repaint
					repaint();
					timePassed++;

					try {
						Thread.sleep(100);

					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
		// start render loop
		// Thread loop = new Thread(new MainLoop());

	}

	public void initImage() {

		// Makes the background image
		try {
			backgroundImage = ImageIO.read(new File("Pictures/goku2.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Makes the Image that will move (png image)
		try {
			gokuImage = ImageIO.read(new File("Pictures/goku transparent.png"));
		} catch (IOException e) {

			e.printStackTrace();
		}

		try {
			kaiokenImage = ImageIO.read(new File("Pictures/kaiokenaura.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ssgImage = ImageIO.read(new File("Pictures/ssg.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ssjImage = ImageIO.read(new File("Pictures/ssj aura.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ssj2Image = ImageIO.read(new File("Pictures/ssj2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ssbImage = ImageIO.read(new File("Pictures/ssb.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ssbkImage = ImageIO.read(new File("Pictures/ssbk.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void initColorList() {
		final int speed = 5;
		new Thread() {
			public void run() {
				for (;;) {
					for (int i = 0; i < 255; i++) {
						green--;
						repaint();
						try {
							Thread.sleep(speed);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					for (int i = 0; i < 255; i++) {
						red++;
						repaint();
						try {
							Thread.sleep(speed);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					for (int i = 0; i < 255; i++) {
						blue--;
						repaint();
						try {
							Thread.sleep(speed);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					for (int i = 0; i < 255; i++) {
						green++;
						repaint();
						try {
							Thread.sleep(speed);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					for (int i = 0; i < 255; i++) {
						red--;
						repaint();
						try {
							Thread.sleep(speed);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					for (int i = 0; i < 255; i++) {
						blue++;
						repaint();
						try {
							Thread.sleep(speed);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}.start();

	}

	class keyListener implements KeyListener {

		@Override

		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();

			if (keyCode == KeyEvent.VK_UP) {

			}

			if (keyCode == KeyEvent.VK_DOWN) {

			}

			if (keyCode == KeyEvent.VK_RIGHT) {
				Xpicturelocation = (int) (Math.random() * 1346);
				Ypicturelocation = (int) (Math.random() * 444);

			}

			if (keyCode == KeyEvent.VK_LEFT) {

			}

			if (keyCode == KeyEvent.VK_J) {
				ssj++;
				ssj2 = 0;
				ssg = 0;
				ssb = 0;
			}
			if (keyCode == KeyEvent.VK_S) {
				ssj2++;
				ssj = 0;
				ssg = 0;
				ssb = 0;
			}
			if (keyCode == KeyEvent.VK_G) {
				ssg++;
				ssj = 0;
				ssb = 0;
				ssj2 = 0;
			}
			if (keyCode == KeyEvent.VK_B) {
				ssb++;
				ssj = 0;
				ssj2 = 0;
				ssg = 0;
			}

			if (keyCode == KeyEvent.VK_DELETE) {
				timePassed = 0;
			}

		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

		// System.out.println("UpCount: " + upCount);

	}

	class mouseWheelListener implements MouseWheelListener {

		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			totalRotations += -e.getWheelRotation();
			if (totalRotations < 0) {
				kaioken = false;
				totalRotations = 0;
			}

		}

	}

	private boolean pressed(char letter) {

		if (letter == 'j') {
			if (ssj != 0 && ssj % 2 == 1) {
				return true;
			} else {
				return false;
			}
		}

		if (letter == 's') {
			if (ssj2 != 0 && ssj2 % 2 == 1) {
				return true;
			} else {
				return false;
			}

		}

		if (letter == 'g') {
			if (ssg != 0 && ssg % 2 == 1) {
				return true;
			} else {
				return false;
			}
		}

		if (letter == 'b') {
			if (ssb != 0 && ssb % 2 == 1) {
				return true;
			} else {
				return false;
			}

		}
		return false;
	}

}


