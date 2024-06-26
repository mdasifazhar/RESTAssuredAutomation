package tests;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Test {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		
		SimpleDateFormat sdf= new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		long milisec=1716570765000l;
		Date d = new Date(milisec);
		System.out.println(sdf.format(d));
		
		Scanner in = new Scanner(System.in);

		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int n = in.nextInt();
			String result="";
			int sum=0;
			for (int count = 1;  count<= n; count++) {
				if(count==1)
					sum = sum+a+(int)Math.pow(2, count-1)*b;
				else
					sum = sum+(int)Math.pow(2, count-1)*b;
				result=result+sum+" ";
			}
			System.out.println(result);
		}
		in.close();
	}
}
