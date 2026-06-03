package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer{
	
	int count=0;
	int retrychance=3;

	@Override
	public boolean retry(ITestResult result) {
		
		if (retrychance>count) 
		{
			count++;
			
			return true;
			
		}
		
		return false;
	}

}
