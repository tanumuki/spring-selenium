package com.jiosaavn.web.springselenium;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "classpath:features",
        glue = "com.jiosaavn.web.springselenium.stepDefs",
        plugin = {
                "pretty"
//                "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"
        },
        tags = "not @ignore"

)
public class CucumberRunner extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                return super.scenarios();
        }


}
