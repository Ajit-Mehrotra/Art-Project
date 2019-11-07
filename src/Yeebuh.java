
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Yeebuh implements ActionListener{
	JFrame frame, a;
	JPanel contentPane, b;
	
	JLabel yeebuh, omegaLol;
	JButton litGamer;
	Yeebuh(){

		frame = new JFrame("Art Project");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		// Come back I will need to change this later
		contentPane.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
		
		litGamer = new JButton("litGamer");
		
		yeebuh  = new JLabel("yeebuh");
		omegaLol = new JLabel("omegaLol");
		

		litGamer.addActionListener(this);
		contentPane.add(litGamer);		
		
		contentPane.add(yeebuh);
		contentPane.add(omegaLol);
		
		frame.setContentPane(contentPane);

		frame.pack();
		frame.setSize(300,300);
		/*int a = (int)Math.random()*800;
		int b = (int)Math.random()*800;
		frame.setLocation(a,b);*/
			
		
		frame.setVisible(true);

	}


	public void actionPerformed(ActionEvent arg0) {
		for(int a = 0; a < 100; a++) {
			JFrame frame100;
			JPanel contentPane100; 
			JLabel image;
			frame100 = new JFrame("New Gamer");
			frame100.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			contentPane100 = new JPanel();
			// Come back I will need to change this later
			contentPane100.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

			contentPane100.setBackground(Color.WHITE);
			contentPane100.setLayout(new BoxLayout(contentPane100, BoxLayout.PAGE_AXIS));
			
			frame100.setContentPane(contentPane100);
			image = new JLabel(new ImageIcon("Pictures/goku.jpg"));
			frame100.add(image);
			frame100.pack();
		//	frame100.setSize(300,300);
			int ranNum1 = (int)(Math.random()*800);
			int ranNum2 = (int)(Math.random()*800);
			frame100.setLocation(ranNum1,ranNum2);
			frame100.setVisible(true);
		}
		
		
		//System.out.println("Ok something is working baby");
		// TODO Auto-generated method stub

	}
	
	private static void runGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);

		Yeebuh BBWPounder= new Yeebuh();


	}

	public static void main (String args[]) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				runGUI();
			}
		});
	}

}
