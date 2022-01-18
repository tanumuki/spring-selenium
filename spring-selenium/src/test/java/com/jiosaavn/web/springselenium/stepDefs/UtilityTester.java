package com.jiosaavn.web.springselenium.stepDefs;

import org.testng.annotations.Test;

public class UtilityTester {


    @Test
    public void test(){

        String str = " ·  3:11  ·  Hindi";
        String ans = str.replaceAll("[A-Za-z ·]", "");
        System.out.println("ans is="+ans);
    }
}
