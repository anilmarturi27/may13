package Scary.Testing;
//hello hi
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Pages.DocumentHomePage;
import Pages.HomePage;
import Pages.Signin;
import Pages.WindowHandle;
import SetChromeProfile.SetChrome;




@SuppressWarnings("unused")
public class Box {
	
	
	
	
	WebDriver driver = new ChromeDriver();
		
	Random random = new Random();
	String DocumentName ="april10"+random.nextInt(9999);
	String GoogleEmail = "user1@boxengsandbox.com";
	String TrustedMail = "marturi@google.com";
	
	@BeforeSuite
	public void SignIn(){
//		WebDriver driver = new ChromeDriver();
		driver.get("https://boxfordocs.app.box.com/folder/0");
//		WebDriver profiledriver = new ChromeDriver(SetChrome.getChromeSetup());
//		profiledriver.get("https://www.google.com");
		driver.manage().window().maximize();
		Signin sn = new Signin(driver);
		sn.login();

	}
	

	
	
	
//	@Test(priority=7)
//	public void close() {
//		driver.quit();
//	}
////	
//	
////	@AfterMethod
////	public void CloseDriver() {
////		driver.close();
////	}
//	

}
