package com.fonet.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/fonet/step_definitions",
        features = "@target/rerun.txt"

)

public class FailedTestsRunner {
}
