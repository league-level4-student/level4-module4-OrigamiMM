package _01_introduction_to_encapsulation;

public class t {
public static void main(String[] args) {
	String a = "hello";
	EncapsulateTheData e = new EncapsulateTheData();
	e.setItemsReceived(-100);
	System.out.println(e.getItemsReceived());
	e.setmemberObj(a);
	if(e.getmemberObj() instanceof Object) {
		System.out.println("This is an Object");
	}
}
}
