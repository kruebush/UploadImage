package com.revature.revspace.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)				
@CucumberOptions(features="Features",glue={"UploadImageSteps"})	
public class UploadTestRunner {

					
				


}