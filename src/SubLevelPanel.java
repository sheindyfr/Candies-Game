import java.awt.*;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
//sheindy frenkel 207191131***ruth siman tov 208179168
public class SubLevelPanel extends JPanel{
	private ImageIcon[] images;
	private JPanel p1, p2, p3;
	private JButton[] buttons;
	private JButton b1;
	private ImageIcon i1;
	private int indexLevel;
	private Image img;
	private Border emptyBorder, redBorder;
	private Game game;

	public SubLevelPanel(int indexLevel){

		this.indexLevel=indexLevel;
		game=new Game();

		MyListener myl=new MyListener();
		MyMouseListener myml=new MyMouseListener();

		setLayout(new BorderLayout());
		img = Toolkit.getDefaultToolkit().createImage("src/back1.png");  //the background

		emptyBorder=BorderFactory.createEmptyBorder();
		redBorder=BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red);

		p1=new JPanel(new GridLayout(2, 2, 25, 0));
		p2=new JPanel();
		p3=new JPanel(new GridLayout(2, 1));
		p1.setOpaque(false);
		p2.setOpaque(false);

		i1=new ImageIcon("src/return.png");
		images=new ImageIcon[5];
		images[0]=new ImageIcon("src/one.png");
		images[1]=new ImageIcon("src/two.png");
		images[2]=new ImageIcon("src/three.png");
		images[3]=new ImageIcon("src/four.png");

		b1=new JButton(i1);
		b1.setContentAreaFilled(false);
		b1.setBorder(emptyBorder);
		b1.addActionListener(myl);
		b1.addMouseListener(myml);
		p2.add(b1);
		p3.add(p2);
		buttons=new JButton[4];
		for(int i=0; i<buttons.length; i++){
			buttons[i]=new JButton(images[i]);
			buttons[i].setContentAreaFilled(false);
			buttons[i].setBorder(emptyBorder);
			buttons[i].addActionListener(myl);
			buttons[i].addMouseListener(myml);
			p1.add(buttons[i]);
		}
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);

	}
	public void paintComponent(Graphics g) { //draw the background
		super.paintComponent(g); 
		g.drawImage(img,0,0,this); }

	/**
	 * the action listener
	 */
	private class MyListener implements ActionListener{

		public void actionPerformed(ActionEvent e){

			/* if the user click b1-return to the previous panel 
			 */
			if(e.getSource().equals(b1)){
				LevelPanel lp=new LevelPanel();
				JFrame f=new JFrame("בחר שלב");
				ImageIcon ficon=new ImageIcon("src/icon.png");
				f.setIconImage(ficon.getImage());
				f.add(lp);
				f.setSize(580, 930);
				Window win[] = Window.getWindows();
				for(int i=0; i<win.length; i++)
					win[i].dispose();
				f.setVisible(true);
			}
			else{  
				//the event come from one of the sublevel buttons
				GamePanel gp=null;
				int i;
				for(i=0; i<buttons.length; i++){
					if(e.getSource().equals(buttons[i])){
						gp=new GamePanel(game.l[indexLevel], indexLevel, i, 0);  //open new panel
						break;
					}
				}
				JFrame f=new JFrame(" שלב "+(indexLevel+1)+"/"+(i+1));
				ImageIcon ficon=new ImageIcon("src/icon.png");
				f.setIconImage(ficon.getImage());
				f.add(gp);
				f.setSize(580, 930);
				Window win[] = Window.getWindows();  //close all windows
				for(int j=0; j<win.length; j++)
					win[j].dispose();
				f.setVisible(true);

			}
		}
	}
	/**
	 * the mouse listener
	 */
	private class MyMouseListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {  //create red border around the buttons
			if(e.getSource().equals(b1))
				b1.setBorder(redBorder);
			for(int i=0; i<buttons.length; i++){
				if(e.getSource().equals(buttons[i]))
					buttons[i].setBorder(redBorder);
			}
		}
		public void mouseExited(MouseEvent e) {
			if(e.getSource().equals(b1))
				b1.setBorder(emptyBorder);
			for(int i=0; i<buttons.length; i++){
				if(e.getSource().equals(buttons[i]))
					buttons[i].setBorder(emptyBorder);
			}
		}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
	}
}
