import java.util.Vector;
//sheindy frenkel 207191131***ruth siman tov 208179168
public class Level {
	protected String[] letters;
	protected Vector<Vector<String>> words;
	
	public Level(){
		letters=new String[4];  //array with the letters of every sub-level 
		words=new Vector<>();   //the vector with the vectors of the words
		
		// indexes in the array are the same as the vector
	}
}
