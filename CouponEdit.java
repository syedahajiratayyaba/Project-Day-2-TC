import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CouponEdit {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream file = new FileInputStream("./TestData/aminportal.properties");
		Properties prop = new Properties();
		prop.load(file);
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait wait= new WebDriverWait(driver, 60);
		driver.get(url);
		
		WebElement emailEle=driver.findElement(By.name("email"));
		emailEle.sendKeys(username);
		
		WebElement passEle=driver.findElement(By.name("pword"));
		passEle.sendKeys(password);
		
		WebElement loginEle=driver.findElement(By.cssSelector(".btn"));
		loginEle.click();

		WebElement MarketingEle=driver.findElement(By.linkText("Marketing"));
		MarketingEle.click();
		
		WebElement CouponEle=driver.findElement(By.linkText("Coupons"));
		CouponEle.click();
		
		WebElement actionEle=driver.findElement(By.cssSelector(".odd .btn"));
		actionEle.click();
		
		WebElement editEle=driver.findElement(By.linkText("Edit"));
		editEle.click();
		
		WebElement saveEle=driver.findElement(By.cssSelector("button.btn.btn-primary"));
		saveEle.click();
		
		
		

	}

}
