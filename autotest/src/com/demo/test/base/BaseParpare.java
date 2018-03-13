package com.demo.test.base;
/**
 * @Description 测试开始 和 测试结束 的操作
 * 
 * */
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import com.demo.test.utils.LogConfiguration;
import com.demo.test.utils.SeleniumUtil;
import com.demo.test.utils.ExcelDataProvider;

public class BaseParpare {
	//输出本页面日志 初始化
	static Logger logger = Logger.getLogger(BaseParpare.class.getName());
	protected SeleniumUtil seleniumUtil = null;
	// 添加成员变量来获取beforeClass传入的context参数
	protected ITestContext testContext = null;
	protected String webUrl="";
	protected int timeOut = 0;
	static Method testMethod=null;
	
	@BeforeMethod
	/**启动浏览器并打开测试页面*/
	public void startTest(ITestContext context) {
		LogConfiguration.initLog(this.getClass().getSimpleName());
		seleniumUtil = new SeleniumUtil();
		// 这里得到了context值
		this.testContext = context;
		//从testng.xml文件中获取浏览器的属性值
		String browserName ="chrome";// context.getCurrentXmlTest().getParameter("browserName");
		timeOut = 20;//Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		webUrl ="http://127.0.0.1:1080/WebTours/index.htm"; //context.getCurrentXmlTest().getParameter("testurl");
		

		try {
			//启动浏览器launchBrowser方法可以自己看看，主要是打开浏览器，输入测试地址，并最大化窗口
			seleniumUtil.launchBrowser(browserName, context,webUrl,timeOut);
		} catch (Exception e) {
			logger.error("浏览器不能正常工作，请检查是不是被手动关闭或者其他原因",e);
		}
		//设置一个testng上下文属性，将driver存起来，之后可以使用context随时取到，主要是提供arrow 获取driver对象使用的，因为arrow截图方法需要一个driver对象
		testContext.setAttribute("SELENIUM_DRIVER", seleniumUtil.driver);
	}

	@AfterMethod
	/**结束测试关闭浏览器*/
	public void endTest() {
		if (seleniumUtil.driver != null) {
			//退出浏览器
			seleniumUtil.quit();
		} else {
			logger.error("浏览器driver没有获得对象,退出操作失败");
			Assert.fail("浏览器driver没有获得对象,退出操作失败");
		}
	}
	
	/**
	 * 测试数据提供者 - 方法
	 * */
	
}
