import java.util.Vector;

public class Level1 extends Level{
	
	public Level1(){
	
		letters[0]="����";
		letters[1]="����";
		letters[2]="����";
		letters[3]="����";
		
		Vector<String> v1=new Vector<>();
		Vector<String> v2=new Vector<>();
		Vector<String> v3=new Vector<>();
		Vector<String> v4=new Vector<>();
		
		v1.add("����"); v1.add("����"); v1.add("����"); v1.add("���"); v1.add("���"); 
		v2.add("����"); v2.add("����"); v2.add("���"); v2.add("���"); v2.add("���");
		v3.add("����"); v3.add("����"); v3.add("���"); v3.add("���"); v3.add("���"); 
		v4.add("����"); v4.add("���"); v4.add("���"); v4.add("���"); v4.add("���");
	
		words.add(v1); words.add(v2); words.add(v3); words.add(v4); 
	} 
}
