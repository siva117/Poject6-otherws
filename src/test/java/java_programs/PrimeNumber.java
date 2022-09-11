package java_programs;

public class PrimeNumber {

	public static void main(String[] args) {
		
		int x=10;
		int y=20;
	
		System.out.println(x+y);
	
	}
	
	public void checkPrimeNumber() {
		
		int n=9;
		int count=0;
		for (int i = 1; i <=9; i++) {
			if (n/i==0) {
				count++;
				
			}
		}
		if (count<2) {
			
			System.out.println("prime");
			
		}else {
			System.out.println("not prime");
		}
		
	}
	
	
	public void checkPrimeNumber1() {
		
		int n=9;
		int count=0;
		for (int i = 1; i <=9; i++) {
			if (n/i==0) {
				count++;
				
			}
		}
		if (count<2) {
			
			System.out.println("prime");
			
		}else {
			System.out.println("not prime");
		}
		
	}

}
