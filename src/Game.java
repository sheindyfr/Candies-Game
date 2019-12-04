//sheindy frenkel 207191131***ruth siman tov 208179168
public class Game {
	public Level[] l;  //array of the levels
	public int money;  //the money

	public Game(){

		//initalizationthe levels
		l=new Level[3];
		l[0]=new Level1();
		l[1]=new Level2();
		l[2]=new Level3();
		money=0;
	}
}