package SetChromeProfile;

import java.util.Arrays;

import org.openqa.selenium.chrome.ChromeOptions;

public class SetChrome {
	public static ChromeOptions getChromeSetup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-web-security");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("C:\\Users\\testa\\AppData\\Local\\Google\\Chrome\\User Data");
        options.addArguments("profile-directory=Profile 85");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
//        options.addArguments("--headless=new"); 
        return options;
    }
}


//public static ChromeOptions getChromeSetup() {
//    ChromeOptions options = new ChromeOptions();
//    options.addArguments("--disable-web-security");
//    options.addArguments("--no-sandbox");
//    options.addArguments("--disable-popup-blocking");
//    options.addArguments("--disable-blink-features=AutomationControlled");
//    
//    // ✅ Correct way to launch specific Chrome profile:
//    options.addArguments("user-data-dir=C:\\Users\\testa\\AppData\\Local\\Google\\Chrome\\User Data");
//    options.addArguments("profile-directory=Profile 85");  // Optional if default profile
//    
//    options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
//    options.setExperimentalOption("useAutomationExtension", false);
//    
//    // options.addArguments("--headless=new"); // Uncomment only if needed
//    
//    return options;
//}