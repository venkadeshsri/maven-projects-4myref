package examples_selenium;

public class variablesex {
	
	int a=0;
	static int b=0;
	void counter() { 
		a++;
		b++;
		System.out.println("int--> " + a + "Static   "+b);
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		variablesex ve = new variablesex();
				ve.counter();
				ve.counter();
				

	}

}
