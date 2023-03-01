package com.cjc.dws.webapp.pages;

import java.io.IOException;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cjc.dws.webapp.utility.Commons;

public class RegisterPage {
            
	      public RegisterPage(WebDriver driver)
	      {
	    	  Commons.driver=driver;
	      }
	      
	      @FindBy(xpath = "//*[@id=\"gender-male\"]")
	      WebElement gender;
	      
	      @FindBy(xpath = "//*[@id=\"FirstName\"]")
	      WebElement fName;
	      
	      @FindBy(xpath = "//*[@id=\"LastName\"]")
	      WebElement lName;
	      
	      @FindBy(xpath = "//*[@id=\"Email\"]")
	      WebElement e;
	      
	      @FindBy(xpath = "//*[@id=\"Password\"]")
	      WebElement pass;
	      
	      @FindBy(xpath = "//*[@id=\"ConfirmPassword\"]")
	      WebElement cPass;
	      
	      @FindBy(xpath = "//*[@id=\"register-button\"]")
	      WebElement btn;
	      
	      public void register() throws IOException, InterruptedException
	      {
	    	 Commons.log=Logger.getLogger(RegisterPage.class.getName());
	    	 Commons.ap=new FileAppender(Commons.l,"src//test//resources//log4j//register.txt");
	    	 Commons.log.addAppender(Commons.ap);
	    	 
	    	 gender.click();
	    	 
	    	 Thread.sleep(3000);
	    	 
	    	 String fn=Commons.fn_excel();
	    	 String ln=Commons.ln_excel();
	    	 String email=Commons.email_excel();
	    	 String pw=Commons.pw_excel();
	    	 String cpw=Commons.cpw_excel();
	    	 
	    	 fName.sendKeys(fn);
	    	 lName.sendKeys(ln);
	    	 e.sendKeys(email);
	    	 
	    	 Thread.sleep(3000);
	    	 
	    	 pass.sendKeys(pw);
	    	 cPass.sendKeys(cpw);
	    	 
	    	 Thread.sleep(3000);
	    	 
	    	 btn.click();
	    	 
	    	 Thread.sleep(3000);
	    	 
	    	 Commons.log.info("WE HAVE TO REGISTERED SUCCESSFULLY");
	      }
}
