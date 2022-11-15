package testcomponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryClass implements IRetryAnalyzer{

	int n=0;
	int maxTry=1;
			
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(n<maxTry)
		{
			n++;
			return true;
		}
		return false;
	}

}
