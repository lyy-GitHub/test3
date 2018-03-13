package com.demo.test.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.demo.test.utils.SeleniumUtil;

/**
 * @description 首页面元素定位声明
 * */
public class HomePage {
	
	// 提供本类中日志输出对象
			public static Logger logger = Logger.getLogger(HomePage.class);

	
	/**用户名显示区域*/
	public static final By HP_TEXT_USERNAME= By.xpath("//blockquote/b");
	/**Flights按钮*/
	public static final By HP_BUTTON_FLIGHTS = By.xpath("//*[@src='/WebTours/images/flights.gif']");
	/**Itinerary按钮*/
	public static final By HP_BUTTON_ITINERARY = By.xpath("//*[@src='/WebTours/images/itinerary.gif']");
	/**Home按钮*/
	public static final By HP_BUTTON_HOME = By.xpath("//*[@src='/WebTours/images/in_home.gif']");
	/**Sign Off按钮*/
	public static final By HP_BUTTON_SIGNOFF = By.xpath("//*[@src='/WebTours/images/signoff.gif']");
	/**首页完整文本*/
	public static final By HP_TEXT_HOME= By.xpath("//blockquote");	
	
	
	public static final By HP_SELECT_DEPART=By.name("depart");
	public static final By HP_SELECT_ARRIVAL=By.name("arrive");
	public static final By HP_TEXT_DEPARTDATE=By.name("departDate");
	public static final By HP_TEXT_RETURNDATE=By.name("returnDate");
	public static final By HP_TEXT_NUMPASSAGERS=By.name("numPassengers");
	public static final By HP_TEXT_FIND=By.name("findFlights");
	
	
	
		/**
		 * @author Young
		 * @description 等待首页元素加载
		 * @param seleniumUtil
		 *            selenium api封装引用对象
		 * @param timeOut
		 *            等待元素超时的时间
		 * */
		public static void waitHomePageLoad(SeleniumUtil seleniumUtil, int timeOut) {
			FramePage.jumpOut(seleniumUtil);
			// 等待body frame显示出来
			seleniumUtil.waitForElementToLoad(timeOut, FramePage.FP_FRAME_BODY);
			FramePage.jumpInToFrame(seleniumUtil, FramePage.FP_FRAME_BODY);// 先进入到body
																					// frame中
			// 等待navbar frame显示出来
			seleniumUtil.waitForElementToLoad(timeOut, FramePage.FP_FRAME_NAVBAR);
			FramePage.jumpInToFrame(seleniumUtil, FramePage.FP_FRAME_NAVBAR);// 再进入body
																					// frame的子frame:navbar
																					// frame中
			logger.info("开始等待首页元素加载");
			seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_BUTTON_FLIGHTS);
			seleniumUtil
					.waitForElementToLoad(timeOut, HomePage.HP_BUTTON_ITINERARY);
			seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_BUTTON_HOME);
			seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_BUTTON_SIGNOFF);
			logger.info("首页元素加载完毕");
			FramePage.jumpOut(seleniumUtil);

		}

		/**
		 * @Description 登录成功之后验证用户名是不是正确的
		 * */
		public static void checkUserName(SeleniumUtil seleniumUtil, int timeOut,
				String username) {
			FramePage.jumpInToFrame(seleniumUtil, FramePage.FP_FRAME_BODY);// 先进入到body
																					// frame中
			FramePage.jumpInToFrame(seleniumUtil, FramePage.FP_FRAME_INFO);// 先进入到body
																					// frame中的子frame:info
																					// frame中
			logger.info("开始检查用户名是不是：" + username);
			seleniumUtil.isTextCorrect(
					seleniumUtil.getText(HomePage.HP_TEXT_USERNAME), username);
			logger.info("用户名检查完毕,用户名是：" + username);

		}

		/**
		 * @description 登录成功之后验证首页的文本内容
		 * */
		public static void checkHomeText(SeleniumUtil seleniumUtil) {
			FramePage.jumpInToFrame(seleniumUtil, FramePage.FP_FRAME_BODY);// 先进入到body
																					// frame中
			FramePage.jumpInToFrame(seleniumUtil, FramePage.FP_FRAME_INFO);// 先进入到body
																					// frame中的子frame:info
																					// frame中
			seleniumUtil
					.isTextCorrect(
							seleniumUtil.getText(HomePage.HP_TEXT_HOME),
							"Welcome, jojo, to the Web Tours reservation pages."
									+ "\n"
									+ "Using the menu to the left, you can search for new flights to book, or review/edit the flights already booked. Don't forget to sign off when you're done!");

		}
		public static void FindFlight(SeleniumUtil seleniumUtil)
		{
			seleniumUtil.click(HP_BUTTON_FLIGHTS);
			seleniumUtil.click(HP_SELECT_DEPART);
		}

}
