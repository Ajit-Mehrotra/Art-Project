package snippet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class DragonBallSuper {

	JPanel contentPane;
	JFrame dbsFrame;
	JLabel label;


	// KAMEHAMEHAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
	// Can you add a video to a JPanel
	//https://coderanch.com/t/667697/java/Embed-Video-JFrame
	DragonBallSuper(){
       
		
		

		dbsFrame = new JFrame("Literally Unplayable");
		contentPane = new JPanel(new GridLayout(0, 2, 10, 10));

		dbsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dbsFrame.setContentPane(contentPane);

		dbsFrame.pack();
		dbsFrame.setSize(1600,850);
		dbsFrame.setVisible(true);

	}
	private static void runGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new DragonBallSuper();
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				runGUI();
			}
		});
	}

}

// I am the one don't weigh  aton don't need a gun to get respect up on the steet under te s

	class lit extends JPanel {
		/**
		 * 
		 */
		
		
		BufferedImage image; 
		

		lit(){

		
			try {
				image = ImageIO.read(new File("Pictures/goku.jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	            
			
		}
		/*
	@Override
	public Dimension preferredSize() {
		return new Dimension(800, 600);
	}

		 */
		@Override
		public Dimension preferredSize() {
			return new Dimension(800, 600);
		}
		
		protected void paintComponent(Graphics g) {
			System.out.println("I want to kill myself");
			super.paintComponent(g);
			Graphics2D OG = (Graphics2D) g;

			
			OG.drawImage(image, 800, 450, this);




			OG.setColor(Color.BLACK);

	
			OG.setColor(Color.RED);



			OG.setColor(Color.BLACK);

		}  
		private static void runGUI() {
			JFrame.setDefaultLookAndFeelDecorated(true);
			new DragonBallSuper();
		}
		public static void main(String[] args) {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					runGUI();
				}
			});
		}

	}










	class Listener implements KeyListener{

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}


	}
	

