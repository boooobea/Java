package ObjectClass;

public class FieldinitValueExample {
	public static void main(String[] args) {
		//개발자도, default 생성자도, 필드의 값을 초기화 해주지 않으면 
		//타입별 기본값으로 초기화된다(정수타입-0,실수타입-.0,참조타입-null,boolean타입-null)
		FieldInitValue fiv = new FieldInitValue();
		
		System.out.println("byteField: "+fiv.byteField);
		System.out.println("shortField: "+fiv.shortField);
		System.out.println("intField: "+fiv.intField);
		System.out.println("longField: "+fiv.longField);
		System.out.println("booleanField: "+fiv.booleanField);
		System.out.println("charField: "+fiv.charField);
		System.out.println("floatField: "+fiv.floatField);
		System.out.println("doubleField: "+fiv.doubleField);
		System.out.println("arrField: "+fiv.arrField);
		System.out.println("referenceField: "+fiv.referenceField);
		
	}//main
	
}//end class
