package com.jiosaavn.web.springselenium.util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

@Lazy
@Component
public class ScreenshotUtil {

    /**
     * Chromedriver can be type-casted to TakeScreenShot as ChromeDriver extends RemoteWebDriver which again extends TakeScreenShot
     * Hence, we are directly using the TakeScreenShot class instead of WebDriver instance
     */
    @Autowired
    private TakesScreenshot driver;

    @Value("${screenshot.path}/img.png")
    private Path path;

    /**
     * The driver is taking the screenshot as the sourceFile and it is kept to the path location given to the method
     */
    public void takeScreenShot() throws IOException {
        File sourceFile = this.driver.getScreenshotAs(OutputType.FILE);
        FileCopyUtils.copy(sourceFile, this.path.toFile());
    }

}
