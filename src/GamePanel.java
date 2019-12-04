import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

//sheindy frenkel 207191131***ruth siman tov 208179168
public class GamePanel extends JPanel{

	private ImageIcon i1, i2, i3, i4, i5, i6;
	private JPanel p1, p2, p3, p4, p5, p6, p7, p8;
	private JLabel l1, l2, l3, l4, l5, l6, l7;
	private JLabel[] wor;
	private Color c;
	private JButton hint, finish, clear, info;
	private JButton[] let;
	private Game game;
	private String word;
	private int indexLevel, indexSubLevel;
	private Level level;
	private Vector<String> v;
	private Image img;
	private Font font;
	private Border emptyBorder;
	private int money;


	public GamePanel(Level level, int indexLev, int indexSubLev, int money){  //constructor
		
		setLayout(new GridLayout(4, 1));

		this.indexLevel=indexLev;
		this.indexSubLevel=indexSubLev;
		this.level=level;
		game=new Game();
		game.money=money;
		word="";
		font=new Font("Amatica SC", Font.BOLD, 50);
		
		//copy the current sub-level words to new vector
		v=new Vector<>();   
		for(int i=0; i<this.level.words.get(indexSubLevel).size(); i++){
			v.add(this.level.words.get(indexSubLevel).get(i));
		}
		
		if(this.level instanceof Level3){
			let=new JButton[5];
		}
		else let=new JButton[4];
		initButtons(let);

		wor=new JLabel[5];
		initLabel(wor);

		//read the high score from the file score1 in order to create label of high score
		try{
			FileReader fr =new FileReader("src/score1.txt");
			BufferedReader br= new BufferedReader(fr);
			String line=br.readLine();
			br.close();
			this.money=Integer.parseInt(line);
		}
		catch (IOException e) {	
			e.printStackTrace();
		}

		img = Toolkit.getDefaultToolkit().createImage("src/back3.png");  //the background
		c=new Color(128, 255, 255);

		emptyBorder=BorderFactory.createEmptyBorder();
		MyListener l=new MyListener();

		p1=new JPanel(new GridLayout(3, 1));
		p2=new JPanel(new BorderLayout());
		p3=new JPanel();
		p4=new JPanel(new GridLayout(3, 1));
		p5=new JPanel(new GridLayout(1, 2));
		p6=new JPanel(new GridLayout(1, 2));
		p7=new JPanel();
		p8=new JPanel();

		p1.setOpaque(false);
		p2.setOpaque(false);
		p3.setOpaque(false);
		p4.setOpaque(false);
		p5.setBackground(Color.CYAN);
		p6.setBackground(Color.CYAN);
		p7.setBackground(Color.CYAN);
		p8.setOpaque(false);

		i1=new ImageIcon("src/money.png");
		i2=new ImageIcon("src/vi.png");
		i3=new ImageIcon("src/hint.png");
		i4=new ImageIcon("src/x.png");
		i5=new ImageIcon("src/info.png");
		i6=new ImageIcon("src/celebration.png");

		hint=new JButton("רמז", i3);
		hint.setFont(font);
		hint.addActionListener(l);
		hint.setContentAreaFilled(false);
		hint.setBorder(emptyBorder);

		clear=new JButton(i4);
		clear.setFont(font);
		clear.addActionListener(l);
		clear.setContentAreaFilled(false);
		clear.setBorder(emptyBorder);

		finish=new JButton(i2);
		finish.setFont(font);
		finish.addActionListener(l);
		finish.setContentAreaFilled(false);
		finish.setBorder(emptyBorder);

		info=new JButton(i5);
		info.setFont(font);
		info.addActionListener(l);
		info.setContentAreaFilled(false);
		info.setBorder(emptyBorder);


		l1=new JLabel("", i1, JLabel.CENTER);
		if(game.money<0)
			l1.setText(" מינוס "+game.money*-1+" מטבעות ");
		else l1.setText(" "+game.money+" מטבעות ");
		l1.setFont(font);
		l2=new JLabel("", JLabel.CENTER);
		l2.setFont(font);
		l2.setBackground(Color.white);
		l2.setOpaque(true);

		l7=new JLabel(" שיא "+this.money, JLabel.CENTER);
		l7.setFont(font);

		p1.add(l7);
		p1.add(l1);

		p5.add(wor[0]); p5.add(wor[1]);
		p6.add(wor[2]); p6.add(wor[3]);
		p7.add(wor[4]); 
		p2.add(p5, BorderLayout.NORTH);
		p2.add(p6, BorderLayout.CENTER);
		p2.add(p7, BorderLayout.SOUTH);

		//add the buttons to the panel
		for(int i=0; i<let.length; i++){
			let[i].addActionListener(l);
			p3.add(let[i]);
		}

		p8.add(hint);
		p4.add(l2);
		p4.add(p8);
		p3.add(finish);
		p3.add(clear);
		p3.add(info);

		add(p1, BorderLayout.NORTH);
		add(p2);
		add(p4);
		add(p3);
	}
	public void paintComponent(Graphics g) {  //draw the background
		super.paintComponent(g); 
		g.drawImage(img,0,0,this); 
	}

	/**
	 * the method initialization the buttons in the array 
	 * @param let
	 */
	public void initButtons(JButton[] let){
		String s=level.letters[indexSubLevel];
		for(int i=0; i<s.length(); i++){
			let[i]=new JButton(Character.toString(s.charAt(i)));
			let[i].setFont(font);
			let[i].setBackground(Color.cyan);
		}
	}
	/**
	 * the method initialization the labels in the array 
	 * @param wor
	 */
	public void initLabel(JLabel[] wor){
		for(int i=0; i<wor.length; i++){
			wor[i]=new JLabel("אורך המילה:" + level.words.get(indexSubLevel).get(i).length(), JLabel.CENTER);
			wor[i].setFont(font);
		}
	}
	/**
	 * the method play the game 
	 * @param word
	 */
	public void play(String word){

		if (v.contains(word)){  //check if the word exist
			wor[level.words.get(indexSubLevel).indexOf(word)].setText(word);  //put the word in her place in the labels array
			v.remove(word);    
		}
		if(v.isEmpty()){  //if all the words found
			if(indexSubLevel==3){  //if the level finished
				indexLevel++;  //pass to the next level
				indexSubLevel=0;  //zero the sub level

				l3=new JLabel("סיימת את השלב ");
				if(indexLevel==3)
					l3.setText("סיימת את המשחק!!! ");
				l3.setFont(font);
				JOptionPane.showMessageDialog(null, l3,"end",JOptionPane.INFORMATION_MESSAGE, i6);
			}
			else indexSubLevel++;  //pass to the next sub level
		}
	}
	/**
	 * the method give to the user the first letter of the first available word
	 */
	public void hint(){
		for(int i=0; i<wor.length; i++){  //If the user has already clicked a hint. Unable to click again
			if(wor[i].getText().length()==1)
				return;
		}
		//set the text of the word of the hint
		wor[level.words.get(indexSubLevel).indexOf(v.get(0))].setText(Character.toString(v.get(0).charAt(0)));
		
		game.money-=10;  //update the money
		if(game.money<0)
			l1.setText(" מינוס "+game.money*-1+" מטבעות ");
		else l1.setText(" "+game.money+" מטבעות ");

	}
	/**
	 * the method open the next sublevel when the user finish this
	 * if the user finish the game we check his score
	 */
	public void finishLevel(){
		if(indexLevel==3){
			Score score=new Score(game.money);  //go to the score class to check the high score
			return;
		}
		GamePanel gp=new GamePanel(game.l[indexLevel], indexLevel, indexSubLevel, game.money);

		JFrame f=new JFrame(" שלב "+(indexLevel+1)+"/"+(indexSubLevel+1));
		ImageIcon ficon=new ImageIcon("src/icon.png");
		f.setIconImage(ficon.getImage());
		f.add(gp);
		f.setSize(580, 930);
		Window win[] = Window.getWindows();  //close all windows
		for(int i=0;i<win.length;i++)
			win[i].dispose();
		f.setVisible(true);
	}
	/**
	 * the listener
	 */
	private class MyListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			/* if the event come from the letters buttons
			 * set the lable of the example and save the word 
			 */
			for(int i=0 ; i<let.length; i++){
				if(e.getSource().equals(let[i])){
					word+=let[i].getText();
					l2.setText(word);
				}
			}
			
			/* if the event come from the clear button 
			 * clear the word and the example lable
			 */
			if(e.getSource().equals(clear)){
				word="";
				l2.setText("");
			}
			
			/* if the event come from the finish button
			 * play the game 
			 * and clear the word and the example lable
			 */
			if(e.getSource().equals(finish)){
				
				if(word.isEmpty() || !v.contains(word)){ 
					word="";
					l2.setText("");
					return;
				}
				
				play(word);
				word="";
				l2.setText("");
				game.money=game.money+5;  //update the money
				
				if(game.money<0)
					l1.setText(" מינוס "+game.money*-1+" מטבעות ");
				else l1.setText(" "+game.money+" מטבעות ");

				if(v.isEmpty()){  //if it was the last word call the method finish
					finishLevel();
				}
			}
			
			/* if the event come from the hint button
			 * call the method hint
			 */
			if(e.getSource().equals(hint)){
				hint();
			}
			
			/* if the event come from the info button
			 * open panel with the information of the game
			 */
			if(e.getSource().equals(info)){

				l3=new JLabel("לחץ על מספר האותיות הנדרש לפי סדר.", JLabel.CENTER);
				l4=new JLabel("נסה לעשות את צירופי המילים עד להשלמת כל המילים הרצויות.", JLabel.CENTER);
				l5=new JLabel("*יש אפשרות להעזר ברמז*", JLabel.CENTER);
				l3.setFont(font);
				l4.setFont(font);
				l4.setBackground(Color.white);
				l4.setOpaque(true);
				l5.setBackground(c);
				l5.setOpaque(true);
				l5.setFont(font);
				l6=new JLabel("", i5, JLabel.CENTER);
				l6.setBackground(c);
				l6.setOpaque(true);
				JPanel p=new JPanel(new GridLayout(4, 1));
				p.setBackground(Color.cyan);
				p.add(l3);
				p.add(l4);
				p.add(l5);
				p.add(l6);
				
				JFrame f=new JFrame();
				ImageIcon ficon=new ImageIcon("src/icon.png");
				f.setIconImage(ficon.getImage());
				f.add(p);
				f.setSize(900, 400);
				f.setVisible(true);
			}
		}
	}
}