package com.demo.test.testcases.login;



import org.testng.annotations.Test;

import com.demo.test.base.BaseParpare;
import com.demo.test.pages.HomePage;
import com.demo.test.pages.LoginPage;

public class FlightTest extends BaseParpare {
	@Test
public void FindFlight()
{
		  LoginPage.waitLoginPageLoad(seleniumUtil, timeOut);
		  // 输入登录信息
		  LoginPage.typeLoginInfo(seleniumUtil,"test", "test");
		  //等待首页元素显示出来
		  HomePage.waitHomePageLoad(seleniumUtil, timeOut);
		HomePage.waitHomePageLoad(seleniumUtil, timeOut);
		HomePage.FindFlight(seleniumUtil);
}
}
