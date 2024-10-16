package tz.co.niajiri.qa.runner;

import org.testng.TestNG;

import java.util.Arrays;

public class TestRunnner {
    public static void main(String[] args) {
        // Get the suite file passed as a system property
        String suiteFile = System.getProperty("suiteFile");

        if (suiteFile != null && !suiteFile.isEmpty()) {
            // Initialize TestNG
            TestNG testng = new TestNG();

            // Set the test suite from the suiteFile system property
            testng.setTestSuites(Arrays.asList(suiteFile));

            // Run TestNG
            testng.run();
        } else {
            System.out.println("Please provide a suiteFile system property");
        }
    }
}
