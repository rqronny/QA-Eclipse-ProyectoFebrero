package support;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= ("src/test/resources/features"),
glue= ("definitions"),
tags = "@smoke",
plugin = {"html:target/cucumber-report/index.html", "json:target/cucumber-report/cucumber.json"})

public class runtest {

}
