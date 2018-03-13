package com.demo.test.testcases.login;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.demo.test.base.BaseParpare;
import com.demo.test.pages.HomePage;
import com.demo.test.pages.LoginPage;
import com.demo.test.utils.ExcelDataProvider;

/**
 * @description 登录之后验证用户名是不是正确的
  * */

public class LoginPage_001_LoginSuccessFunction_Test extends BaseParpare{
	
	  @Test(dataProvider="testData")
	  public void loginSuccessFunction(Map<String, String> data) {
		  //等待登录页面加载
		  LoginPage.waitLoginPageLoad(seleniumUtil, timeOut);
		  // 输入登录信息
		  LoginPage.typeLoginInfo(seleniumUtil,data.get("USERNAME"), data.get("PASSWORD"));
		  //等待首页元素显示出来
		  HomePage.waitHomePageLoad(seleniumUtil, timeOut);
		  //检查用户名是不是期望的"jojo"
		  HomePage.checkUserName(seleniumUtil, timeOut, data.get("USERNAME"));

	  }
	  
	  @Test(dataProvider="registerTestData")
	  public void register(Map<String, String> data) {
		  //等待登录页面加载
		  System.out.println(data.get("USERNAME"));
		  //startTest(testContext);
		  LoginPage.signup(seleniumUtil,data.get("USERNAME"),data.get("PASSWORD"),data.get("CONFIRMPASSWORD"));
		  // 输入登录信息
//		  LoginPage.typeLoginInfo(seleniumUtil,data.get("USERNAME"), data.get("PASSWORD"));
//		  //等待首页元素显示出来
//		  HomePage.waitHomePageLoad(seleniumUtil, timeOut);
//		  //检查用户名是不是期望的"jojo"
//		  HomePage.checkUserName(seleniumUtil, timeOut, data.get("USERNAME"));

	  }
	  
	  @DataProvider(name = "registerTestData")
		public Iterator<Object[]> dataFortestMethod() throws IOException {
//			String moduleName = null; // 模块的名字
//			String caseNum = null; // 用例编号
//			String className = this.getClass().getName();
//			int dotIndexNum = className.indexOf("."); // 取得第一个.的index
//			int underlineIndexNum = className.indexOf("_"); // 取得第一个_的index
//
//			if (dotIndexNum > 0) {	
//				moduleName = className.substring(24, className.lastIndexOf(".")); // 取到模块的名称
//			}
//
//			if (underlineIndexNum > 0) {
//				caseNum = className.substring(underlineIndexNum + 1, underlineIndexNum + 4); // 取到用例编号
//			}
			//将模块名称和用例的编号传给 ExcelDataProvider ，然后进行读取excel数据
			return new ExcelDataProvider("login", "register");
		}
		
		  @DataProvider(name = "testData")
			public Iterator<Object[]> testDataFortestMethod() throws IOException {
				String moduleName = null; // 模块的名字
				String caseNum = null; // 用例编号
				String className = this.getClass().getName();
				int dotIndexNum = className.indexOf("."); // 取得第一个.的index
				int underlineIndexNum = className.indexOf("_"); // 取得第一个_的index
	
				if (dotIndexNum > 0) {	
					moduleName = className.substring(24, className.lastIndexOf(".")); // 取到模块的名称
				}
	
				if (underlineIndexNum > 0) {
					caseNum = className.substring(underlineIndexNum + 1, underlineIndexNum + 4); // 取到用例编号
				}
				//将模块名称和用例的编号传给 ExcelDataProvider ，然后进行读取excel数据
				return new ExcelDataProvider("login", "001");
			}
}
