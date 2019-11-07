package snippet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class test {
	JFrame graphFrame;

	JFrame inputFrame;
	JPanel inputPanel;

	JLabel  entranceLabel ;
	int count;
	int upCount;
	int rightButtonCounter;

	JTextField entranceField ;
	
	private int timerCounter = 0;
	private int Xpicturelocation = 0;
	private int Ypicturelocation = 0;

	// have the user mash the arrow key to make goku go into kaio ken 
	// Might have to use a timer in order to do the animation in regards to the kamehameha

	public test() {
		inputFrame = new JFrame("Input Data");
		inputPanel = new JPanel(new GridLayout(0, 2, 10, 10));
		inputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inputFrame.setContentPane(inputPanel);

		entranceLabel = new JLabel("Press Enter");
		entranceField = new JTextField();  
		entranceField.addKeyListener(new keyListener());



		inputPanel.add(entranceLabel);
		inputPanel.add(entranceField);

		inputFrame.setVisible(true);
		inputFrame.pack();
	}

	private static void runGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new test();
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				runGUI();
			}
		});
	}

	class Graph extends JPanel {

		BufferedImage image; 
		BufferedImage image1; 
		//		double[] points;
		public Graph() {
			//System.out.println("Got to Graph");

		}




		public void initImage() {
			try {
				//System.out.println("image almost cool");
				image = ImageIO.read(new File("Pictures/goku.jpg"));
				//System.out.println("image cool");
			} catch (IOException e) {
				//System.out.println("image not cool");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				//System.out.println("image almost cool");
				image1 = ImageIO.read(new File("Pictures/goku transparent.png"));
				
				//System.out.println("image cool");
			} catch (IOException e) {
				//System.out.println("image not cool");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// One is a StackOverFlow and the other is a PowerPoint Presentations similar to what Ms. Gerb gives
		// https://stackoverflow.com/questions/28706000/animation-using-java-swing-is-jumpy-although-using-paintcomponent-and-animation
		//https://www2.cs.arizona.edu/~mercer/Presentations/335/22-Java%20Drawing%20in%202D.pdf
		// Use TimerTask and Timer StackOverflwo and Timer and boom
		//https://stackoverflow.com/questions/19344995/java-timer-and-timer-task-accessing-variables-outside-timer
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			initImage();

			Graphics2D OG = (Graphics2D) g;
			setBackground(Color.BLACK);

			OG.drawImage(image, 0, 0, this);

			if(upCount > 0) {
				Timer  timer = new Timer();
				timer.scheduleAtFixedRate(new TimerTask() {
					@Override
					public void run() {
						timerCounter++;
						//254 x 356
		
					}
				}, 0, 17);
				if(timerCounter>= 2) {
					do{
						Xpicturelocation = (int)(Math.random()*1346);
						Ypicturelocation = (int)(Math.random()*496);
						System.out.println(Xpicturelocation);
						System.out.println();
					}	while(Xpicturelocation > 1346 && Ypicturelocation > 496 ) ;
					
						
					
					
					OG.drawImage(image1, 400, 200, this);
					System.out.println("cool");
					if(rightButtonCounter > 10) {
						g.setColor(Color.CYAN);
						//essentially, the distance between him kamehameha ball and the start of picture is about 75-80 pixels
						g.fillOval(565, 278, 1400, 100);
					//1600,850
						
						/*	timer = new Timer(100, new ActionListener() {
						    @Override
						    public void actionPerformed(ActionEvent ae) {
						        // change polygon data
						        // ...

						        repaint();
						    }
						});*/
					}
					// All I need to do now is animate it so as time increases, so does the size of his kamehamehaaaaaaa
				}else {
					OG.drawImage(image1, 0, 0, this);
				}
				//800, 475
				
				
			}
			



		}  
	}
	class mouseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			 int x=e.getX();
			    int y=e.getY();
			    System.out.println(x+","+y);//these co-ords are relative to the component
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

	class keyListener implements KeyListener {


		@Override

		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			switch(keyCode) {
			case KeyEvent.VK_UP:
				upCount++;
				graphFrame.repaint();

				// handle up 
				break;
			case KeyEvent.VK_DOWN:
				System.out.println("Down");
				graphFrame.repaint();
				// handle down 
				break;
			case KeyEvent.VK_LEFT:
				System.out.println("Left");
				graphFrame.repaint();
				// handle left
				break;
			case KeyEvent.VK_RIGHT :
				rightButtonCounter++;

				System.out.println("Right Button Count:"  + rightButtonCounter);
				graphFrame.repaint();
				
				
				// handle right
				break;

			}


			System.out.println("Count: " + upCount);

			if (count != 1 && e.getKeyCode() == KeyEvent.VK_ENTER ) {

			
				inputFrame.dispose();
				// This is the important Part
				graphFrame = new JFrame("Graph");

				graphFrame.add(new Graph());
				graphFrame.addKeyListener(new keyListener());
				graphFrame.addMouseListener(new mouseListener());
				graphFrame.pack();
				graphFrame.setSize(1600,850);
				graphFrame.setVisible(true);
				count = 1;

			}

		}

		@Override
		public void keyReleased(KeyEvent e) {

		}

		@Override
		public void keyTyped(KeyEvent e) {

		}

	}
}