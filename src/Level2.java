import java.util.Vector;

public class Level2 extends Level{
	
	public Level2(){
		
		letters[0]="עשיר";
		letters[1]="מזרק";
		letters[2]="פטיש";
		letters[3]="מצבר";
		
		Vector<String> v1=new Vector<>();
		Vector<String> v2=new Vector<>();
		Vector<String> v3=new Vector<>();
		Vector<String> v4=new Vector<>();
		
		v1.add("עשיר"); v1.add("שיער"); v1.add("ישר"); v1.add("שיר"); v1.add("יער"); 
		v2.add("מזרק"); v2.add("מרק"); v2.add("קרמ"); v2.add("זרק"); v2.add("זרמ"); 
		v3.add("פטיש"); v3.add("טיפש"); v3.add("שפט"); v3.add("טיפ"); v3.add("שטפ");
		v4.add("מצבר"); v4.add("מבצר"); v4.add("מצב"); v4.add("צרב"); v4.add("צרמ");
	
		words.add(v1); words.add(v2); words.add(v3); words.add(v4);
	} 
}
