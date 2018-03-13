package com.demo.test.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;


import com.demo.test.utils.SeleniumUtil;
/**
 * @description 登录页面元素定位声明
 * */
public class LoginPage {
	// 提供本类中日志输出对象
			public static Logger logger = Logger.getLogger(LoginPage.class);
	/**用户名输入框*/
	public static final By LP_INPUT_USERNAME = By.name("username");
	
	/**密码输入框*/
	public static final By LP_INPUT_PASSWORD = By.name("password");
	
	/**登录按钮*/
	public static final By LP_BUTTON_LOGIN = By.name("login");
	
	/**登录错误信息*/
	public static final By LP_TEXT_ERROR= By.xpath("//*[@color='red']");
	
	public static final By LP_Link_SIGNUP=By.linkText("sign up now");
	public static final By Lp_SIGINUP_INPUT_USERNAME=By.name("username");
	public static final By Lp_SIGINUP_INPUT_PWD=By.name("password");
	public static final By Lp_SIGINUP_INPUT_CONFIRM_PWD=By.name("passwordConfirm");
	public static final By LP_REGISTER=By.name("register");
	
public static void signup(SeleniumUtil seleniumutil,String userName,String pwd,String confirmPWD)
{
	seleniumutil.switchFrame(seleniumutil.findElementBy(FramePage.FP_FRAME_BODY));
	seleniumutil.switchFrame(seleniumutil.findElementBy(FramePage.FP_FRAME_INFO));
	seleniumutil.click(LP_Link_SIGNUP);
	seleniumutil.type(Lp_SIGINUP_INPUT_USERNAME, userName);
	seleniumutil.type(Lp_SIGINUP_INPUT_PWD, pwd);
	seleniumutil.type(Lp_SIGINUP_INPUT_CONFIRM_PWD, confirmPWD);
	seleniumutil.click(LP_REGISTER);
	
}
		/**
		 * @description 等待登录页面元素加载
		 * @param seleniumUtil
		 *            selenium api封装引用对象
		 * @param timeOut
		 *            等待元素超时的时间
		 * */
		public static void waitLoginPageLoad(SeleniumUtil seleniumUtil, int timeOut) {
			seleniumUtil.pause(1000);
			// 对此处的解释：这个登录页面有两个大frame，一个header一个body ,
			// 而登录的用户名、密码输入框以及登录按钮都在body frame下的navbar frame下,
			// 所以先要进入body frame中，然后在进入navbar frame中，才能查找到登录界面的相关元素
//			FramePage.jumpInToFrame(seleniumUtil, FramePage.FP_FRAME_BODY);// 先进入到body
//																					// frame中
//			FramePage.jumpInToFrame(seleniumUtil, FramePage.FP_FRAME_NAVBAR);// 再进入body
																					// frame的子frame:navbar
																					// frame中
			logger.info("开始检查登录页面元素");
			seleniumUtil.waitForElementToLoad(timeOut, LoginPage.LP_INPUT_USERNAME);
			seleniumUtil.waitForElementToLoad(timeOut, LoginPage.LP_INPUT_PASSWORD);
			seleniumUtil.waitForElementToLoad(timeOut, LoginPage.LP_BUTTON_LOGIN);
			logger.info("检查登录页面元素完毕");
		}

		/**
		 * @description 登录操作封装
		 * @param seleniumUtil
		 *            selenium api封装引用对象
		 * @param username
		 *            用户名值
		 * @param password
		 *            用户密码值
		 * */
		public static void typeLoginInfo(SeleniumUtil seleniumUtil,
				String username, String password) {

			logger.info("开始输入登录信息");
			// 清空用户名输入框
			seleniumUtil.clear(LoginPage.LP_INPUT_USERNAME);
			// 输入用户名到用户名输入框
			seleniumUtil.type(LoginPage.LP_INPUT_USERNAME, username);
			// 清空密码输入框
			seleniumUtil.clear(LoginPage.LP_INPUT_PASSWORD);
			// 输入密码到密码输入框
			seleniumUtil.type(LoginPage.LP_INPUT_PASSWORD, password);
			logger.info("输入登录信息完毕");
			// 点击登录按钮
			seleniumUtil.click(LoginPage.LP_BUTTON_LOGIN);

		}

		/**
		 * @description 验证登录错误信息
		 * @param seleniumUtil
		 *            selenium api封装引用对象
		 * @param error
		 *            错误文本
		 * */
		public static void checkLoginErrorInfo(SeleniumUtil seleniumUtil,
				String error) {
			FramePage.jumpOut(seleniumUtil);
			FramePage.jumpInToFrame(seleniumUtil, FramePage.FP_FRAME_BODY);
			FramePage.jumpInToFrame(seleniumUtil, FramePage.FP_FRAME_INFO);
			seleniumUtil.isTextCorrect(
					seleniumUtil.getText(LoginPage.LP_TEXT_ERROR), error);
		}
	
}
