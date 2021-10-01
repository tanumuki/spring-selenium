package com.jiosaavn.web.springselenium.util;

import com.github.javafaker.Faker;
import com.jiosaavn.web.springselenium.page.BaseConfig;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

@Lazy
@Component
public class ScreenshotUtil {


    @Autowired
    public TakesScreenshot driver;

    @Autowired
    Faker faker;

    @Value("${screenshot.path}")
    public Path path;

    public void takeScreenshot() throws IOException {
        File sourceFile=  ((TakesScreenshot)this.driver).getScreenshotAs(OutputType.FILE);
        FileCopyUtils.copy(sourceFile, this.path.resolve(faker.name().firstName() +".png").toFile());
    }



}
