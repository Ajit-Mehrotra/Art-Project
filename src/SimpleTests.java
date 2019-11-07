
public class SimpleTests {
	public static void main(String args[]) {
		boolean yeet = true;
		do{
			double ranNum = Math.random() + 99;
			if(ranNum == 100) {
				System.out.println("Works");
				yeet = false;

			}
		}while(yeet);


		
		System.out.println(yeet);
		//System.out.println(Math.random() + 99);
	}
}
