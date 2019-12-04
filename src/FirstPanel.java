//sheindy frenkel 207191131***ruth siman tov 208179168‏
import java.awt.*;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class FirstPanel extends JPanel{

	private ImageIcon i1;
	private Color c;
	private JPanel p1, p2, p3;
	private JButton b1;
	private Image img;
	private Border emptyBorder, redBorder;
	
	public FirstPanel(){
		
		c=new Color(255, 51, 51);
		setLayout(new GridLayout(4, 1));
		
		MyListener myl=new MyListener();
		MyMouseListener myml=new MyMouseListener();
		
		i1=new ImageIcon("src/play3.png");
		img = Toolkit.getDefaultToolkit().createImage("src/back.png");  //the background
		
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p1.setOpaque( false );
		p2.setOpaque( false );
		p3.setOpaque( false );

		b1=new JButton(i1);
		b1.addActionListener(myl);
		b1.addMouseListener(myml);
		
		emptyBorder = BorderFactory.createEmptyBorder();
		redBorder=BorderFactory.createMatteBorder(2, 2, 2, 2, c);
		
		b1.setBorder(emptyBorder);
		p3.add(b1);
		b1.setContentAreaFilled(false);
	
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
			/*
			 * create the level panel
			 */
			LevelPanel lp=new LevelPanel();
			
			JFrame f=new JFrame("בחר שלב");
			ImageIcon ficon=new ImageIcon("src/icon.png");
			f.setIconImage(ficon.getImage());
			f.add(lp);
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
			b1.setBorder(redBorder);
		}
		public void mouseExited(MouseEvent e) {
			b1.setBorder(emptyBorder);
		}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
	}
	
}
