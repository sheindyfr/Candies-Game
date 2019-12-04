//sheindy frenkel 207191131***ruth siman tov 208179168
import java.awt.*;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class LevelPanel extends JPanel{

	private ImageIcon i1, i2, i3;
	private Color c;
	private JPanel p1, p2, p3;
	private JButton b1, b2 ,b3;
	private Image img;
	private Border emptyBorder, redBorder;


	public LevelPanel(){
		
		setLayout(new GridLayout(4, 1, 10, 10));
		img = Toolkit.getDefaultToolkit().createImage("src/back1.png");  //the background
		
		MyListener myl=new MyListener();
		MyMouseListener myml=new MyMouseListener();

		c=new Color(255, 51, 51);
		
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p1.setOpaque(false);
		p2.setOpaque(false);
		p3.setOpaque(false);

		i1=new ImageIcon("src/lev1.png");
		i2=new ImageIcon("src/lev2.png");
		i3=new ImageIcon("src/lev3.png");

		emptyBorder = BorderFactory.createEmptyBorder();
		redBorder=BorderFactory.createMatteBorder(2, 2, 2, 2, c);

		b1=new JButton(i1);
		b2=new JButton(i2);
		b3=new JButton(i3);
		b1.setContentAreaFilled(false);
		b2.setContentAreaFilled(false);
		b3.setContentAreaFilled(false);
		b1.setBorder(emptyBorder);
		b2.setBorder(emptyBorder);
		b3.setBorder(emptyBorder);
		b1.addActionListener(myl);
		b1.addMouseListener(myml);
		b2.addActionListener(myl);
		b2.addMouseListener(myml);
		b3.addActionListener(myl);
		b3.addMouseListener(myml);
		

		p1.add(b1);
		p2.add(b2);
		p3.add(b3);

		add(p1);
		add(p2);
		add(p3);

	}
	public void paintComponent(Graphics g) {  //draw the background
		super.paintComponent(g); 
		g.drawImage(img,0,0,this); }

	/**
	 * the action listener
	 */
	private class MyListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			SubLevelPanel slp=null;
			/*
			 * create the sub-level panel according to the number of the button
			 */
			if(e.getSource().equals(b1))
				slp=new SubLevelPanel(0);
			else 
				if(e.getSource().equals(b2))
					slp=new SubLevelPanel(1);
				else slp=new SubLevelPanel(2);

			JFrame f=new JFrame("בחר תת שלב");
			ImageIcon ficon=new ImageIcon("src/icon.png");
			f.setIconImage(ficon.getImage());
			f.add(slp);
			f.setSize(580, 930);
			Window win[] = Window.getWindows();  //close all windows
			for(int i=0;i<win.length;i++)
				win[i].dispose();
			f.setVisible(true);

		}
	}
	/**
	 * the mouse listener
	 */
	private class MyMouseListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) { //create red border around the buttons
			if(e.getSource().equals(b1))
				b1.setBorder(redBorder);
			else 
				if(e.getSource().equals(b2))
					b2.setBorder(redBorder);
				else b3.setBorder(redBorder);
		}
		public void mouseExited(MouseEvent e) {
			if(e.getSource().equals(b1))
				b1.setBorder(emptyBorder);
			else 
				if(e.getSource().equals(b2))
					b2.setBorder(emptyBorder);
				else b3.setBorder(emptyBorder);
		}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
	}
}
