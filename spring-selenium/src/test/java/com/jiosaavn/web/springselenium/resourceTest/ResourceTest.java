package com.jiosaavn.web.springselenium.resourceTest;

import com.jiosaavn.web.springselenium.SpringBaseTestNGTest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ResourceTest extends SpringBaseTestNGTest {

    @Value("classpath:testResources/Data.csv")
    private Resource resource;

    @Value("http://a.sop.saavncdn.com/866/SAA-JSPAB-S1-EP03.mp3")
    private Resource resource2;

    @Value("${screenshot.path}/abz.mp3")
    private Path path;

    /*
    Scenario: When you want to print all the contents from a file on local disk
     */

    @Test
    public void resourceTest() throws IOException {
        Files.readAllLines(resource.getFile().toPath()).forEach(s -> System.out.println(s));

    }
    /*
    Scenario: When you want to download any song from the web to verify something
     */

    @Test
    public void testDownloadExternalFile() throws IOException {

        FileCopyUtils.copy(resource2.getInputStream(), Files.newOutputStream(path));
        System.out.println("done!");
    }
}
