import java.util.Vector;

public class Level1 extends Level{
	
	public Level1(){
	
		letters[0]="חולמ";
		letters[1]="שודד";
		letters[2]="שעונ";
		letters[3]="דואר";
		
		Vector<String> v1=new Vector<>();
		Vector<String> v2=new Vector<>();
		Vector<String> v3=new Vector<>();
		Vector<String> v4=new Vector<>();
		
		v1.add("חולמ"); v1.add("לוחמ"); v1.add("מלוח"); v1.add("לוח"); v1.add("חול"); 
		v2.add("שודד"); v2.add("שדוד"); v2.add("דוש"); v2.add("דוד"); v2.add("שוד");
		v3.add("שעונ"); v3.add("עונש"); v3.add("שענ"); v3.add("עשנ"); v3.add("נוע"); 
		v4.add("דואר"); v4.add("ארד"); v4.add("דור"); v4.add("אור"); v4.add("אדר");
	
		words.add(v1); words.add(v2); words.add(v3); words.add(v4); 
	} 
}
