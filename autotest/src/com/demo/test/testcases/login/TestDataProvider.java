package com.demo.test.testcases.login;

import java.util.Map;

import org.testng.annotations.*;

import com.demo.test.utils.XmlDataProvider;

public class TestDataProvider  {

    @Test(dataProvider="providerMethod", dataProviderClass=XmlDataProvider.class)
    public void testmethod1(Map<?, ?> param){
        System.out.println("method1 received:"+param.get("input"));
    }
     
    @Test(dataProvider="providerMethod", dataProviderClass=XmlDataProvider.class)
    public void testmethod2(Map<?, ?> param){
        System.out.println("method2 received:"+param.get("input"));
    }
     
    @Test(dataProvider="providerMethod", dataProviderClass=XmlDataProvider.class)
    public void testmethod3(Map<?, ?> param){
        System.out.println("method3 received:"+param.get("input"));
    }
    
    @Test
    public void testmethod4(){
        System.out.println("method4 received:4");
    }

}