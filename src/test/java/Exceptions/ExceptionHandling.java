package Exceptions;

import java.util.Scanner;

import org.testng.annotations.Test;

public class ExceptionHandling { // below are Handled exceptions, thread.sleep are unhandled exception

	@Test
	public void exception()
	{
		System.out.println("Program has started");
		Scanner sc = new Scanner(System.in);
		
//		try
//		{
//		//java.lang.ArithmeticException
//		System.out.println("Enter the value : ");
//		int value = sc.nextInt();
//		int operation = 100/value;
//		System.out.println(operation);
//		}
//		catch(Exception e)
//		{
//			System.out.println("Exception handled");
//			System.out.println(e.getMessage());
//		}
		
//		try
//		{
//		//java.lang.ArrayIndexOutOfBoundsException
//		int a[] = new int[5];
//		System.out.println("Enter the position (0-4) : ");
//		int pos =sc.nextInt();
//		System.out.println("Enter the value : ");
//		int data =sc.nextInt();
//		a[pos] = data;
//		System.out.println("a[pos]=data: ");
//		}
//		catch(Exception e)
//		{
//			System.out.println("Exception handled");
//			System.out.println(e.getMessage());
//		}
		
		
//		try
//		{
//		//java.lang.NumberFormatException:
//		String S = "welcome"; //"12345" no exception for this
//		int i = Integer.parseInt(S);
//		System.out.println(i);
//		}
//		catch(Exception e)
//		{
//			System.out.println("Exception handled");
//			System.out.println(e.getMessage());
//		}
		
		try
		{
		//java.lang.NullPointerException
		String S1 = null; //"" no exception for this
		System.out.println(S1.length());
		}
		catch(Exception e)
		{
			System.out.println("Exception handled");
			System.out.println(e.getMessage());
		}
		finally //this will work always regardless of catch block but we should have catch block for finally block
		{
			System.out.println("Entered into the finally block");
		}
		
		
	}
}
