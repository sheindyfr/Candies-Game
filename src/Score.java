import java.awt.Font;
import java.awt.Window;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
//sheindy frenkel 207191131***ruth siman tov 208179168
public class Score {

	private FileReader fr;
	private BufferedReader br;
	private FileWriter fw;
	private BufferedWriter bw;
	private int max;
	private ImageIcon i;

	public Score(int money){

		try{
			fr =new FileReader("src/score1.txt");  
			br= new BufferedReader(fr);
			String line = br.readLine();  //read the first line in the file
			br.close();
			max=Integer.parseInt(line);  //save the current high score

			if(money>max){

				fw=new FileWriter("src/score1.txt");
				bw=new BufferedWriter(fw);
				bw.write(""+money);  //write the new high score
				bw.close();
				i=new ImageIcon("src/podium.png");
				JLabel l=new JLabel("שברת שיא! השיא שלך: "+money);
				l.setFont(new Font("Amatica SC", Font.BOLD, 50));
				JOptionPane.showMessageDialog(null, l,"end",JOptionPane.INFORMATION_MESSAGE, i);
				Window win[] = Window.getWindows();
				for(int i=0;i<win.length;i++)
					win[i].dispose();
			}
			else{  
				i=new ImageIcon("src/dead.png");
				JLabel l=new JLabel("לא שברת שיא- חסרות לך: "+(max-money+1)+" מטבעות ");
				l.setFont(new Font("Amatica SC", Font.BOLD, 50));
				JOptionPane.showMessageDialog(null, l,"end",JOptionPane.INFORMATION_MESSAGE, i);
				Window win[] = Window.getWindows();
				for(int i=0;i<win.length;i++)
					win[i].dispose();
			}

		} catch (IOException e){
			e.printStackTrace();
		}

	}
}
