package com.revature.revspace.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@CucumberOptions(
		features = {"feature"},
		glue = {"com.example.gluecode"}
		)
public class FollowerTestRunner {

}
