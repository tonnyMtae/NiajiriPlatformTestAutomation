package tz.co.niajiri.qa.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RetryListener implements IRetryAnalyzer, IAnnotationTransformer {
    private int retryCount = 0;
    private static final int maxRetryCount = 3; // Global retry limit

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            LoggerHelper.info(RetryListener.class, "Retrying testcase for the "+retryCount+" count");
            retryCount++;
            return true; // Retry the test
        }
        return false; // No more retries
    }

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        // Apply RetryAnalyzer to all test methods by default
        annotation.setRetryAnalyzer(RetryListener.class);
    }
}

