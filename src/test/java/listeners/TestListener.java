package listeners;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.internal.IResultListener;

public class TestListener implements IResultListener {

	static Logger logger = LogManager.getLogger(TestListener.class);

	public void onStart(ITestContext arg0) {

		String msg = "automation started...";

		System.out.println(msg);

		System.out.println("=========================");

		logger.info(msg);

		logger.info("=========================");

	}

	public void onTestSuccess(ITestResult result) {

		String msg = "Test case passed successfully.";

		System.out.println(msg);

		logger.info(msg);

	}

	public void onTestFailure(ITestResult arg0) {

		String msg = String.format("Test case failed %s.%s", arg0.getTestClass().getName(),

				arg0.getMethod().getMethodName());

		System.out.println(msg);

		logger.info(msg);

		StringWriter sw = new StringWriter();

		PrintWriter pw = new PrintWriter(sw);

		Throwable cause = arg0.getThrowable();

		if (null != cause) {

			cause.printStackTrace(pw);

			logger.info(sw.getBuffer().toString());

			System.out.println(sw.getBuffer().toString());

		}

	}

	public void onTestSkipped(ITestResult arg0) {

		String msg = String.format("Test case Skipped %s.%s", arg0.getTestClass().getName(),

				arg0.getMethod().getMethodName());

		System.out.println(msg);

		logger.info(msg);

		StringWriter sw = new StringWriter();

		PrintWriter pw = new PrintWriter(sw);

		Throwable cause = arg0.getThrowable();

		if (null != cause) {

			cause.printStackTrace(pw);

			logger.info(sw.getBuffer().toString());

			System.out.println(sw.getBuffer().toString());

		}

	}

	public void onFinish(ITestContext context) {

		String msg = "automation completed successfully...";

		System.out.println("========================================");

		System.out.println(msg);

		logger.info("========================================");

		logger.info(msg);

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

		// TODO Auto-generated method stub

	}

	public void onTestStart(ITestResult arg0) {

		System.out.println("\n" + arg0.getName() + " - Test method execution started.");

		logger.info("\n" + arg0.getName() + " - Test method execution started.");

	}

	public void onConfigurationFailure(ITestResult arg0) {

		// TODO Auto-generated method stub

	}

	public void onConfigurationSkip(ITestResult arg0) {

		// TODO Auto-generated method stub

	}

	public void onConfigurationSuccess(ITestResult arg0) {

		// TODO Auto-generated method stub

	}

}
