package com.accenture.web;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="classpath:features"
//, tags= {"@tag","@tag12"}
)
public class Runner {

}
