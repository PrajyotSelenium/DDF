package com.cjc.dws.webapp.pages;

import java.io.IOException;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cjc.dws.webapp.utility.Commons;

public class AddToCartPage {
       
	    public AddToCartPage(WebDriver driver)
	    {
	    	Commons.driver=driver;
	    }
	    
	    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[3]/div/div/div[3]/div[2]/div/div[2]/div[3]/div[2]/input")
	    WebElement addtocart;
	    
	    @FindBy(xpath = "//*[@id=\"giftcard_2_RecipientName\"]")
	    WebElement recName;
	    
	    @FindBy(xpath = "//*[@id=\"giftcard_2_RecipientEmail\"]")
	    WebElement recEmail;
	    
	    @FindBy(xpath = "//*[@id=\"add-to-cart-button-2\"]")
	    WebElement btn;
	    
	    @FindBy(xpath = "//*[@id=\"topcartlink\"]/a/span[1]")
	    WebElement shoppingCart;
	    
	    @FindBy(xpath = "//*[@id=\"termsofservice\"]")
	    WebElement terms;
	    
	    @FindBy(xpath = "//*[@id=\"checkout\"]")
	    WebElement checkOut;
	    
	    @FindBy(xpath = "/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
	    WebElement logOut;
	    
	    public void addToCart(String name,String email) throws IOException, InterruptedException
	    {
	    	Commons.log=Logger.getLogger(AddToCartPage.class.getName());
	    	Commons.ap=new FileAppender(Commons.l,"src//test//resources//log4j//addtocart.txt");
	    	Commons.log.addAppender(Commons.ap);
	    	
	    	addtocart.click();
	    	
	    	Thread.sleep(3000);
	    	
	    	recName.sendKeys(name);
	    	recEmail.sendKeys(email);
	    	
	    	Thread.sleep(3000);
	    	
	    	btn.click();
	    	
	    	Thread.sleep(3000);
	    	
	    	shoppingCart.click();
	    	
	    	Thread.sleep(3000);
	    	
	    	terms.click();
	    	
	    	Thread.sleep(3000);
	    	
	    	checkOut.click();
	    	
	    	Commons.log.info("WE HAVE TO CHECKED OUT SUCCESSFULLY");
	    	
	    	Thread.sleep(3000);
	    	
	    	logOut.click();
	    	
	    	Commons.log.info("WE HAVE TO LOGGED OUT SUCCESSFULLY");
	    	
	    	Thread.sleep(3000);
	    }
}
