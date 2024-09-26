package TestNG_Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerClass extends BaseClass implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getTestContext().getName()+"_"+result.getMethod().getMethodName());
		captureScreenshot(result.getTestContext().getName()+"_"+result.getMethod().getMethodName()+".png");
	}
	 public void onTestSkipped(ITestResult result) {
		 System.out.println("test is skipped");
	 }
	 public void onFinish(ITestContext context)
	 {
		 System.out.println("test is finished");
	 }
	

}
