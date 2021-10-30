import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class testClass {

private static WebDriver driver=null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		singleTonClass app = singleTonClass.getInstance();
		
		// start reporters
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
    
        // create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // creates a toggle for the given test, adds all log events under it    
        ExtentTest test = extent.createTest("Google Search test 1", "this is test to run the google search");
        String projectPath=System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/Drivers/chromedriver.exe");
        driver=new ChromeDriver();
        test.log(Status.INFO, "Starting Test Case");
        driver.get("https://www.google.com/");
        test.pass("Browser launched successfully");
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Automation");
        test.pass("Entered text in search box");
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(Keys.RETURN);
        test.pass("Clicks on search button");
        driver.close();
        driver.quit();
        test.pass("driver Closed");
        test.info("Test Execution completed");
        extent.flush();
        System.out.println("Test Completed");
	}

}
