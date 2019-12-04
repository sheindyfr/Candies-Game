import javax.swing.ImageIcon;
import javax.swing.JFrame;
//sheindy frenkel 207191131***ruth siman tov 208179168

public class Tester {
	public static void main(String[] args){

		//open the first panel

		
		FirstPanel p2=new FirstPanel();
		ImageIcon ficon=new ImageIcon("src/icon.png");
		JFrame f=new JFrame("תפוס את המילה");
		f.setIconImage(ficon.getImage());
		f.add(p2);
		f.setSize(580, 930);
		f.setVisible(true);

	}

}
