package Scary.Testing;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.DocumentHomePage;
import Pages.HomePage;
import Pages.Signin;
import Pages.WindowHandle;

public class TestCases extends Box {
	
	
	
	@Test(priority=1)
	public void Createdoc() throws InterruptedException, IOException {
		HomePage hm = new HomePage(driver);
		WindowHandle wh = new WindowHandle(driver);
		Signin sn = new Signin(driver);
		DocumentHomePage dhm = new DocumentHomePage(driver);
		
//		Clicking on the Google Docs in the Box HomeScreen
		boolean ClickResult=  hm.ClickOnProduct("google docs");
		Assert.assertTrue( ClickResult,"Google docs is not accessible");
		
//		Creating the document with the given document name
		boolean CreateDocName = hm.CreateDocWithProductNameOverWrite(DocumentName);
		Assert.assertTrue(CreateDocName,"Document is not created");
//		hm.DuplicateDocCancel("April071");
		
//		If document is created, switching the document window
		boolean DocCreated = wh.DocmentWindow();
		Assert.assertTrue( DocCreated,"Document is not created and switched ");
		
//		Clicking Google SignIn Button
		sn.GoogleSignInButton();
		
//		Switching to signin window
		wh.switchTo("sign in");
		
		//vrgergergerherheherhfwefwfwefwefwef
//		loging in using the credentials
		sn.GoogleLogin(GoogleEmail,TrustedMail);
//		
//		WebDriver profiledriver = new ChromeDriver(SetChrome.getChromeSetup());
//		profiledriver.get("https:www.google.com");
//		
		wh.switchTo(DocumentName);
		
		boolean documentload = dhm.isDocumentLoaded();
		Assert.assertTrue(documentload);
		System.out.println("Document is loaded");
		Thread.sleep(2000);
		dhm.TakeScreenshot("document creation");
		driver.switchTo().defaultContent();
	}
	
	
	@Test(priority=2,dependsOnMethods="Createdoc")
	public void CreateDocFromFile() throws InterruptedException, IOException {
		
		Signin sn = new Signin(driver);
		DocumentHomePage dhm = new DocumentHomePage(driver);
		WindowHandle wh = new WindowHandle(driver);
		
//		Creating the document from document File menu
		boolean FileMenuDoc=dhm.DocFromFileMenu();
		Assert.assertTrue( FileMenuDoc,"document is not created from file menu");
		
//		Checking the created file menu document
		boolean Checked = dhm.DocumentCheck();
		Assert.assertTrue(Checked);
		Thread.sleep(2000);
		dhm.TakeScreenshot("New doc");
		driver.close();
		
//		Switching the document to the main document
		boolean switched = wh.switchTo(DocumentName);
		Assert.assertTrue(switched);
	}
////	
	@Test(priority=3,dependsOnMethods="Createdoc")
	public void MakeACopy() throws InterruptedException, IOException {
		DocumentHomePage dhm = new DocumentHomePage(driver);
		WindowHandle wh = new WindowHandle(driver);
		dhm.MakeACopyFromFileMenu();
		System.out.println(driver.getTitle());
		Thread.sleep(5000);
		boolean switched = wh.switchTo("copy");
//		Set<String> s = driver.getWindowHandles();
//		List<String> list = new ArrayList<>();
//		Iterator<String> itr = s.iterator();
//		while(itr.hasNext()) {
//			String ss = itr.next();
//			driver.switchTo().window(ss);
//			list.add(driver.getTitle());
//		}
//		
//		System.out.println(list);
		Assert.assertTrue(switched);
		boolean Checked = dhm.DocumentCheck();
		Assert.assertTrue(Checked);
		Thread.sleep(2000);
		dhm.TakeScreenshot("Make a copy");
		driver.close();
		
//		Switching the document to the main document
		boolean switchedd = wh.switchTo(DocumentName);
		Assert.assertTrue(switchedd);
		
	}
////		
	@Test(priority=4,dependsOnMethods="Createdoc")
	public void TextEntering() throws InterruptedException, IOException {
		DocumentHomePage dhm = new DocumentHomePage(driver);
		dhm.EnterText("Hello Anil Marturi");
		Thread.sleep(2000);
		dhm.TakeScreenshot("Text");
	}
	
	@Test(priority=5,dependsOnMethods="Createdoc")
	public void InsertDrawing() throws InterruptedException, IOException {
		DocumentHomePage dhm = new DocumentHomePage(driver);
		dhm.DrwaingInsert();
		boolean Checked = dhm.DocumentCheck();
		Assert.assertTrue(Checked);
		//switching the driver to the default content because documentcheck method returns boolean and i am unable to switch to default content in that method itself
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		dhm.TakeScreenshot("Drawing");
	}
//	
	@Test(priority=6)
	public void comment() throws InterruptedException, IOException {
		DocumentHomePage dhm = new DocumentHomePage(driver);
		dhm.InsertComment("This is automated comment1");
		dhm.InsertComment("comment2");
		dhm.ClickOnCommentStream();
		dhm.CommentReply("This is automated comment","Reply 1");
		dhm.ClickOnCommentStream();
		dhm.ResolveComment("This is automated comment");
		dhm.ClickOnCommentStream();
		dhm.ReOpenComment("This is automated comment");
		boolean Checked = dhm.DocumentCheck();
		Assert.assertTrue(Checked);
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys(Keys.END).keyUp(Keys.CONTROL).build().perform();
		driver.switchTo().defaultContent();
		
		//switching the driver to the default content because documentcheck method returns boolean and i am unable to switch to default content in that method itself
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		dhm.TakeScreenshot("comments");
		
	}
	
	
	@Test(priority=7)
	public void InsertHorizontalLine() throws InterruptedException, IOException {
		DocumentHomePage dhm = new DocumentHomePage(driver);
		dhm.HorizontalLine();
		boolean Checked = dhm.DocumentCheck();
		Assert.assertTrue(Checked);
		//switching the driver to the default content because documentcheck method returns boolean and i am unable to switch to default content in that method itself
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		dhm.TakeScreenshot("Horizontal line");
		}
	
	@Test(priority=8)
	public void InsertSpecialCharacter() throws InterruptedException, IOException {
		DocumentHomePage dhm = new DocumentHomePage(driver);
		dhm.SpecialCharacters();
		boolean Checked = dhm.DocumentCheck();
		Assert.assertTrue(Checked);
		//switching the driver to the default content because documentcheck method returns boolean and i am unable to switch to default content in that method itself
		
//		Actions action = new Actions(driver);
//		action.keyDown(Keys.CONTROL).sendKeys(Keys.END).keyUp(Keys.CONTROL).build().perform();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		dhm.TakeScreenshot("Special characters");
	}
	
	@Test(priority=9)
	public void SuggestionMode() throws InterruptedException, IOException {
		DocumentHomePage dhm = new DocumentHomePage(driver);
		
		// Select any One : Editing ,Suggesting, Viewing 
		dhm.SwitchToMode("Suggesting");
		
		dhm.EnterText("This is automated suggestion");
		boolean Checked = dhm.DocumentCheck();
		Assert.assertTrue(Checked);
		
		Thread.sleep(2000);
		dhm.TakeScreenshot("Suggestions");
		
		driver.switchTo().defaultContent();
		dhm.SwitchToMode("Editing");
		
		
		
	}
	
	@Test(priority=10)
	public void InsertImage() throws InterruptedException, IOException {
		String Exe_FilePath = "\"C:\\Users\\testa\\OneDrive\\Documents\\MyHub\\may13\\Image_insertion.exe\"";
		DocumentHomePage dhm = new DocumentHomePage(driver);
		dhm.ImageInsertion(Exe_FilePath);
		Thread.sleep(4000);
		dhm.TakeScreenshot("Image");
	}
}
