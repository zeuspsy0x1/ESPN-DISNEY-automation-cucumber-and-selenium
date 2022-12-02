//package org.espn.utils;
//
//import org.espn.reporting.Reporter;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//
//    public class Listener implements ITestListener {
//        @Override
//        public void onTestStart(ITestResult iTestResult) {
//            Reporter.info("Test " + iTestResult.getName() + " starting...");
//        }
//        @Override
//        public void onTestSuccess(ITestResult iTestResult){
//            Reporter.info("Test: " + iTestResult.getName() + " *** PASSED ***");
//        }
//        @Override
//        public void onTestFailure(ITestResult iTestResult){
//            Reporter.error("Test: " + iTestResult.getName() + " *** FAILED ***");
//        }
//        @Override
//        public void onTestSkipped(ITestResult iTestResult) {
//            Reporter.info("Test " + iTestResult.getTestName() + " --- SKIPPED ---");
//        }
//        @Override
//        public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
//
//        }
//        @Override
//        public void onStart(ITestContext iTestContext) {
//
//        }
//        @Override
//        public void onFinish(ITestContext iTestContext) {
//        }
//    }
