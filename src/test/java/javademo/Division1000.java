package javademo;

public class Division1000 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num = 1000;
		for (int i=1; i<=num;i++)
		{
		//   int a = i /10;
			if (i % 10 ==0)
			{
				System.out.println("Answer :" + i);
			}
		}
	}
}
