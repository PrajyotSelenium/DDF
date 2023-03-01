package com.cjc.dws.webapp.pages;

import java.io.IOException;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cjc.dws.webapp.utility.Commons;

public class LoginPage {
        
	    public LoginPage(WebDriver driver)
	    {
	    	Commons.driver=driver;
	    }
	    
	    @FindBy(xpath = "/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
	    WebElement loginHyper;
	    
	    @FindBy(xpath = "//*[@id=\"Email\"]")
	    WebElement email;
	    
	    @FindBy(xpath = "//*[@id=\"Password\"]")
	    WebElement password;
	    
	    @FindBy(xpath = "//*[@id=\"RememberMe\"]")
	    WebElement remember;
	    
	    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")
	    WebElement logIn;
	    
	    public void login(String e,String pw) throws IOException, InterruptedException
	    {
	    	Commons.log=Logger.getLogger(LoginPage.class.getName());
	    	Commons.ap=new FileAppender(Commons.l,"src//test//resources//log4j//login.txt");
	    	Commons.log.addAppender(Commons.ap);
	    	
	    	loginHyper.click();
	    	
	    	Thread.sleep(3000);
	    	
	    	email.sendKeys(e);
	    	password.sendKeys(pw);
	    	
	    	Thread.sleep(3000);
	    	
	    	remember.click();
	    	
	    	Thread.sleep(3000);
	    	
	    	logIn.click();
	    	
	    	Commons.log.info("WE HAVE TO LOGGED IN SUCCESSFULLY");
	    	
	    	Thread.sleep(3000);
	    }
}
