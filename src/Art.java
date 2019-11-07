import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


import javax.swing.*;

public class Art implements ActionListener {
	JFrame frame;
	JPanel contentPane;
	JButton ArtDie;
	JLabel dieFace1, dieFace2;

	public Art() {
		frame = new JFrame("Art");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	

		contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

		contentPane.setBackground(Color.RED);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));

		dieFace1 =  new JLabel(new ImageIcon ("die3.gif"));
		dieFace1.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		dieFace1.setAlignmentY(JLabel.TOP_ALIGNMENT);

		dieFace1.setBorder(BorderFactory.createEmptyBorder( 10, 10, 10, 10));

		dieFace2 =  new JLabel(new ImageIcon ("die3.gif"));
		dieFace2.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
		dieFace2.setAlignmentY(JLabel.TOP_ALIGNMENT);
	
		dieFace2.setBorder(BorderFactory.createEmptyBorder( 10, 10, 10, 10));

		contentPane.add(dieFace1);
		contentPane.add(dieFace2);

		ArtDie = new JButton("Roll Die");
		ArtDie.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		ArtDie.setBackground(Color.yellow);
		ArtDie.setForeground(Color.red);

		ArtDie.addActionListener(this);
		contentPane.add(ArtDie);

		frame.setContentPane(contentPane);

		frame.pack();
		frame.setSize(300,300);
		frame.setVisible(true);




	}

	@Override
	public void actionPerformed(ActionEvent event) {
		Random rand = new Random();
		int newArt1, newArt2;

		newArt1 = rand.nextInt(6) + 1;
		newArt2 = rand.nextInt(6) + 1;

		if(newArt1 == 1) {
			dieFace1.setIcon(new ImageIcon("Z:\\Advanced Object Oriented Design\\Art Project\\src\\die1.gif"));

		}else if(newArt1 == 2) {
			dieFace1.setIcon(new ImageIcon("Z:\\Advanced Object Oriented Design\\Art Project\\src\\die2.gif"));

		}else if(newArt1 == 3) {
			dieFace1.setIcon(new ImageIcon("Z:\\Advanced Object Oriented Design\\Art Project\\src\\die3.gif"));

		}else if(newArt1 == 4) {
			dieFace1.setIcon(new ImageIcon("Z:\\Advanced Object Oriented Design\\Art Project\\src\\die4.gif"));

		}else if(newArt1 == 5) {
			dieFace1.setIcon(new ImageIcon("Z:\\Advanced Object Oriented Design\\Art Project\\src\\die5.gif"));

		}else if(newArt1 == 6) {
			dieFace1.setIcon(new ImageIcon("Z:\\Advanced Object Oriented Design\\Art Project\\src\\die6.gif"));

		}

		if(newArt2 == 1) {
			dieFace2.setIcon(new ImageIcon("Z:\\Advanced Object Oriented Design\\Art Project\\src\\die1.gif"));

		}else if(newArt2 == 2) {
			dieFace2.setIcon(new ImageIcon("Z:\\Advanced Object Oriented Design\\Art Project\\src\\die2.gif"));

		}else if(newArt2 == 3) {
			dieFace2.setIcon(new ImageIcon("Z:\\Advanced Object Oriented Design\\Art Project\\src\\die3.gif"));

		}else if(newArt2 == 4) {
			dieFace2.setIcon(new ImageIcon("Z:\\Advanced Object Oriented Design\\Art Project\\src\\die4.gif"));

		}else if(newArt2 == 5) {
			dieFace2.setIcon(new ImageIcon("Z:\\Advanced Object Oriented Design\\Art Project\\src\\die5.gif"));

		}else if(newArt2 == 6) {
			dieFace2.setIcon(new ImageIcon("Z:\\Advanced Object Oriented Design\\Art Project\\src\\die6.gif"));

		}

	}
	private static void runGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);

		Art myGrades = new Art();


	}

	public static void main (String args[]) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				runGUI();
			}
		});
	}
}

	








	

