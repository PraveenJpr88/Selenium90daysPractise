package practise90daysclass;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Nykaa {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) throws InterruptedException {
		
		//Launch the browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		  ChromeOptions options=new ChromeOptions();
		  options.addArguments("--disable-notifications");
		 	ChromeDriver driver=new ChromeDriver(options);
	
	//	ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		//Mouseover on Brands and Mouseover on Popular
		//@throws org.openqa.selenium.NoSuchElementException for the below line
		WebElement bname = driver.findElementByXPath("//a[text()='brands']");
		Actions builder = new Actions(driver);
		builder.moveToElement(bname).build().perform();
		WebElement pop = driver.findElementByXPath("//a[text()='Popular']");
		builder.moveToElement(pop).build().perform();
		pop.click();
		
		WebElement Wind = driver.findElementByXPath("//a[@href='/brands/loreal-paris/c/595?eq=desktop']");
		Wind.click();
		// First Window Handling
		Set<String> Parent = driver.getWindowHandles();
		List<String> allwind = new ArrayList<String>();
		allwind.addAll(Parent);
		driver.switchTo().window(allwind.get(1));
		String title = driver.getTitle();
		if (title.contains("L'Oreal")) {
			System.out.println("Title Verified successfully");
		}else {
		System.out.println("Title is not Verified successfully");
		}	
		driver.findElementByXPath("//span[@title='POPULARITY']").click();
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='customer top rated']")));
		driver.findElementByXPath("//span[text()='customer top rated']").click();
		Thread.sleep(1000);
		  driver.findElementByXPath("(//div[@class='clearfix'])[2]").click();
		  driver.findElementByXPath("//span[text()='Shampoo (21)']").click();
		  System.out.println("Popular");
		  
		  boolean displayed =
		  driver.findElementByXPath("//li[text()='Shampoo']").isDisplayed();
		  System.out.println("Shampoo selection option is diplayed under filter box : " +displayed);
			driver.findElementByXPath("//span[@title='POPULARITY']").click();
		 
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='price: high to low']")));
			driver.findElementByXPath("//span[text()='price: high to low']").click();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@class='listing-img'])[1]")));
			driver.findElementByXPath("(//img[@class='listing-img'])[1]").click();
		
			// Second Window Handling
			Set<String> BrandWind = driver.getWindowHandles();
			List<String> Secnewwin = new ArrayList<String>();
			Secnewwin.addAll(BrandWind);
			driver.switchTo().window(Secnewwin.get(2));
			String title1 = driver.getTitle();
			if (title1.contains("L'Oreal Paris")) {
				System.out.println("Title Verified successfully");
			}else {
			System.out.println("Title is not Verified successfully");
			}	
			
			driver.findElementByXPath("//span[text()='175ml']").click();
			
			WebElement MRP = driver.findElementByClassName("post-card__content-price-offer");
			String RateofProduct = MRP.getText();
			System.out.println(RateofProduct);
			driver.findElementByXPath("//button[@class='combo-add-to-btn prdt-des-btn js--toggle-sbag nk-btn nk-btn-rnd atc-simple m-content__product-list__cart-btn  ']").click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("AddBagIcon")));
			driver.findElementByClassName("AddBagIcon").click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='value'])[4]")));
			String GrandTotal = driver.findElementByXPath("(//div[@class='value'])[4]").getText();
			System.out.println("Grand Total is printed here:   "+GrandTotal);
			
			//Click Proceed button
			driver.findElementByXPath("//span[text()='Proceed']").click();
			
		/*
		 * // Window Handling Set<String> FinalParentWindow = driver.getWindowHandles();
		 * List<String> thridchild = new ArrayList<String>();
		 * thridchild.addAll(FinalParentWindow);
		 * driver.switchTo().window(thridchild.get(2));
		 */
			
			//click on continue as guest
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='CONTINUE AS GUEST']")));
			driver.findElementByXPath("//button[text()='CONTINUE AS GUEST']").click();
			
			String warning = driver.findElementByClassName("message").getText();
			System.out.println("Warning message is printing here as:   "+warning);
			
			
		//Close the browser
			System.out.println("Going to close all the browser");
			driver.quit();

		
	
}
	
}
