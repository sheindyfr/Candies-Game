import java.util.Vector;

public class Level3 extends Level {

	public Level3(){
		
		letters[0]="מוקפצ";
		letters[1]="הכניס";
		letters[2]="מאוזנ";
		letters[3]="כפתור";
		
		Vector<String> v1=new Vector<>();
		Vector<String> v2=new Vector<>();
		Vector<String> v3=new Vector<>();
		Vector<String> v4=new Vector<>();
		
		v1.add("מוקפצ"); v1.add("מוקצפ"); v1.add("מוצק"); v1.add("מצוק"); v1.add("קופצ"); 
		v2.add("הכניס"); v2.add("נסיכה"); v2.add("סכנה"); v2.add("ינסה"); v2.add("סכינ"); 
		v3.add("מאוזנ"); v3.add("אוזנ"); v3.add("נואמ"); v3.add("מזונ"); v3.add("מאזנ");
		v4.add("כפתור"); v4.add("כפרות"); v4.add("כופר"); v4.add("פתור"); v4.add("תופר");
	
		words.add(v1); words.add(v2); words.add(v3); words.add(v4); 
	} 
}
