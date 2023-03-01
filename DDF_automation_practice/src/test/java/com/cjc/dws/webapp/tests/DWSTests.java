package com.cjc.dws.webapp.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.cjc.dws.webapp.pages.AddToCartPage;
import com.cjc.dws.webapp.pages.LoginPage;
import com.cjc.dws.webapp.pages.RegisterPage;
import com.cjc.dws.webapp.utility.Commons;

  // Test class
public class DWSTests {
           
	   @BeforeSuite
	   public void openBrowser() throws IOException
	   {
		   Commons.log=Logger.getLogger(DWSTests.class.getName());
	       Commons.ap=new FileAppender(Commons.l,"src//test//resources//log4j//test.txt");
	       Commons.log.addAppender(Commons.ap);
	       
	       System.setProperty("webdriver.chrome.driver", "G:\\drivers\\latest version\\chromedriver_win32 (2)\\chromedriver.exe");
	       Commons.driver=new ChromeDriver();
	       
	       Commons.log.info("Browser opened successfully");
	   }
	   
	   @BeforeTest
	   public void openUrl() throws IOException
	   {

		   Commons.log=Logger.getLogger(DWSTests.class.getName());
	       Commons.ap=new FileAppender(Commons.l,"src//test//resources//log4j//test.txt");
	       Commons.log.addAppender(Commons.ap); 
	       
	       Commons.fis=new FileInputStream("src//test//resources//screenshot//properties//ddf.properties");
	       Commons.pro.load(Commons.fis);
	       Commons.driver.get(Commons.pro.getProperty("url"));
	       
	       Commons.log.info("Url opened successfully");
	   }
	   
	   @BeforeClass
	   public void max() throws IOException
	   {
		   Commons.log=Logger.getLogger(DWSTests.class.getName());
	       Commons.ap=new FileAppender(Commons.l,"src//test//resources//log4j//test.txt");
	       Commons.log.addAppender(Commons.ap);
	       
		   Commons.driver.manage().window().maximize();
		   
		   Commons.log.info("Screen maximized successfully");
	   }
	   
	   @BeforeMethod
	   public void timeoutsAndCookies() throws IOException
	   {
		   Commons.log=Logger.getLogger(DWSTests.class.getName());
	       Commons.ap=new FileAppender(Commons.l,"src//test//resources//log4j//test.txt");
	       Commons.log.addAppender(Commons.ap);
	       
		   Commons.driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);   
		   
		   Commons.log.info("Timeouts successfully");
		   
		   Set<Cookie> cookies=Commons.driver.manage().getCookies();
		   for(Cookie cookie:cookies)
		   {
			   Commons.log.info("Details of cookies");
			   Commons.log.info("Name of cookies = "+cookie.getName());
			   Commons.log.info("Name of cookies = "+cookie.getDomain());
			   Commons.log.info("Name of cookies = "+cookie.getClass());
			   Commons.log.info("Name of cookies = "+cookie.getValue());
			   Commons.log.info("Name of cookies = "+cookie.getPath());
			   Commons.log.info("Name of cookies = "+cookie.getExpiry());
			   Commons.log.info("Name of cookies = "+cookie.isHttpOnly());
			   Commons.log.info("Name of cookies = "+cookie.isSecure());
			   Commons.log.info("================================================================================");
		   }
	   }
	   
	   @Test(priority=1)
	   public void register() throws IOException, InterruptedException
	   {
		   Commons.log=Logger.getLogger(DWSTests.class.getName());
	       Commons.ap=new FileAppender(Commons.l,"src//test//resources//log4j//test.txt");
	       Commons.log.addAppender(Commons.ap);
	       
		   RegisterPage rp=PageFactory.initElements(Commons.driver, RegisterPage.class);
		   rp.register();
		   
		   Commons.log.info("We have to registered successfully");
	   }
	   
	   @Parameters({"email","pw"})
	   @Test(priority=2)
	   public void login(String email,String pw) throws IOException, InterruptedException
	   {
		   Commons.log=Logger.getLogger(DWSTests.class.getName());
	       Commons.ap=new FileAppender(Commons.l,"src//test//resources//log4j//test.txt");
	       Commons.log.addAppender(Commons.ap);
	       
	       LoginPage lp=PageFactory.initElements(Commons.driver, LoginPage.class);
	       lp.login(email, pw);
	       
	       Commons.log.info("We have to logged in successfully");
	   }
	   
	   @DataProvider
	   public Object[][] getData()
	   {
		   return new Object[][]
				   {
			   new Object[] {"Prajyot","gujarkarprajyot@gmail.com"}
				   };
	   }
	   
	   @Test(priority=3,dataProvider="getData")
	   public void addToCart(String name,String email) throws IOException, InterruptedException
	   {
		   Commons.log=Logger.getLogger(DWSTests.class.getName());
	       Commons.ap=new FileAppender(Commons.l,"src//test//resources//log4j//test.txt");
	       Commons.log.addAppender(Commons.ap); 
	       
	       AddToCartPage ac=PageFactory.initElements(Commons.driver, AddToCartPage.class);
	       ac.addToCart(name, email);
	       
	       Commons.log.info("We have to checked out successfully");
	   }
	   
	   @AfterMethod
	   public void screenshot() throws IOException
	   {
		   Commons.log=Logger.getLogger(DWSTests.class.getName());
	       Commons.ap=new FileAppender(Commons.l,"src//test//resources//log4j//test.txt");
	       Commons.log.addAppender(Commons.ap);
	       
	       File src=((TakesScreenshot)Commons.driver).getScreenshotAs(OutputType.FILE);
	       FileUtils.copyFileToDirectory(src, new File("src//test//resources//screenshot"));
	       
	       Commons.log.info("Screenshot taken successfully");
	   }
	   
	   @AfterClass
	   public void deleteCookies() throws IOException
	   {
		   Commons.log=Logger.getLogger(DWSTests.class.getName());
	       Commons.ap=new FileAppender(Commons.l,"src//test//resources//log4j//test.txt");
	       Commons.log.addAppender(Commons.ap);
	       
	       Commons.driver.manage().deleteAllCookies();
	       
	       Commons.log.info("After deleted all cookies");
	       
	       Set<Cookie> cookies=Commons.driver.manage().getCookies();
	       for(Cookie cookie:cookies)
	       {
	    	   Commons.log.info("Details of cookies");
			   Commons.log.info("Name of cookies = "+cookie.getName());
			   Commons.log.info("Name of cookies = "+cookie.getDomain());
			   Commons.log.info("Name of cookies = "+cookie.getClass());
			   Commons.log.info("Name of cookies = "+cookie.getValue());
			   Commons.log.info("Name of cookies = "+cookie.getPath());
			   Commons.log.info("Name of cookies = "+cookie.getExpiry());
			   Commons.log.info("Name of cookies = "+cookie.isHttpOnly());
			   Commons.log.info("Name of cookies = "+cookie.isSecure());
			   Commons.log.info("================================================================================");
	       }
	   }
	   
	   @AfterTest
	   public void dbClose() throws IOException
	   {
		   Commons.log=Logger.getLogger(DWSTests.class.getName());
	       Commons.ap=new FileAppender(Commons.l,"src//test//resources//log4j//test.txt");
	       Commons.log.addAppender(Commons.ap);
	       
	       Commons.log.info("Database connections are closed successsfully");
	   }
	   
	   @AfterSuite
	   public void browserClose() throws IOException
	   {
		   Commons.log=Logger.getLogger(DWSTests.class.getName());
	       Commons.ap=new FileAppender(Commons.l,"src//test//resources//log4j//test.txt");
	       Commons.log.addAppender(Commons.ap);
	       
	       Commons.driver.close();
	       
	       Commons.log.info("Browser closed successfully");
	   }
}
