package web_p;


import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;




public class Test_web_site {

	
	WebDriver driver = new ChromeDriver();
	Random rand = new Random();
	String site = "https://codenboxautomationlab.com/practice/";
	
	
	
	@BeforeTest
	public void web_site() {
		
		driver.manage().window().maximize();
		driver.get(site);
		
		
		
	}
		
		

	
	
	@Test(priority =1 , description = "radio button" , invocationCount = 1 , enabled = false)
	private void first() throws InterruptedException {
		

		List<WebElement> radio_button = driver.findElements(By.className("radioButton"));
		//radio_button.get(0).click();
		int rand_x = rand.nextInt(radio_button.size());
		//radio_button.get(rand_x).click();
		
		for (int i = 0; i < radio_button.size(); i++) {
			Thread.sleep(1000);
			radio_button.get(i).click();
		}
	}
	
	
	
	@Test(priority =2 , description ="drop down list" , invocationCount =1 , enabled = false)
	private void second() throws InterruptedException {
		
		String [] drop_down_arry = { "US", "CA", "OM", "BR", "AR", "FR", "DE", "IT", "ES" };
		int rand_x = rand.nextInt(drop_down_arry.length);
		
		
		WebElement drop_down = driver.findElement(By.id("autocomplete"));
		drop_down.sendKeys(drop_down_arry[rand_x]);
		Thread.sleep(1000);
		drop_down.sendKeys(Keys.chord(Keys.ARROW_DOWN,Keys.ENTER));
	}
	
	
	
	
	@Test(priority =3 , description ="static down down" , invocationCount =1 , enabled = false)
	private void therd() {
		
		WebElement select  = driver.findElement(By.id("dropdown-class-example"));
		Select sel = new Select(select);
		//sel.selectByIndex(1);
		//sel.selectByValue("option3");
		sel.selectByVisibleText("Appium");
	}
	
	
	@Test(priority =4 , description ="check box" , invocationCount =1 , enabled = false)
	private void forth() {
		

		List<WebElement> check_box = driver.findElements(By.xpath("//input[@type='checkbox']"));
		int rand_x = rand.nextInt(check_box.size());
		//check_box.get(rand_x).click();
		check_box.getFirst().click();
		check_box.getLast().click();
	}
	
	
	
	@Test(priority =5 , description ="this is to move from window to another one", invocationCount =1 , enabled = false)
	private void fifth() throws InterruptedException {
		

		WebElement OpenWindowButton = driver.findElement(By.id("openwindow"));
		OpenWindowButton.click();
		Thread.sleep(2000);
		List<String> windowsHandels = new ArrayList<String>(driver.getWindowHandles());
		// number of opened windows
		System.out.println(windowsHandels.size());
// switch to the other window 
		driver.switchTo().window(windowsHandels.get(1));
		// in the second window
		WebElement ContactButton = driver.findElement(By.id("menu-item-9680"));
		ContactButton.click();

		System.out.println(driver.getTitle() + " hello from the second window");

		driver.close();
		// switch to the first window
		driver.switchTo().window(windowsHandels.get(0));
		System.out.println(driver.getTitle() + " site chrome");
	}
	
	
	
	
	@Test(priority =6 , description = "check moving to another tab", invocationCount =1 , enabled = false)
	private void sexth() throws InterruptedException {
		
	
		
			WebElement OpenTabButton = driver.findElement(By.id("opentab"));

			OpenTabButton.click();

			List<String> windowsHandels = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(windowsHandels.get(1));
			Thread.sleep(2000);
			System.out.println(driver.getTitle());

		}
	
	
	@Test(priority = 7, description = "Alert and confirm", enabled = true)
	public void Switch_To_Alert_Example() throws InterruptedException {
		WebElement nameBox = driver.findElement(By.id("name"));
		nameBox.sendKeys("abedalraheem");
		// WebElement AlertBox = driver.findElement(By.id("alertbtn"));
		// AlertBox.click();

		Thread.sleep(1000);
		// driver.switchTo().alert().accept();
		// driver.switchTo().alert().dismiss();

		WebElement ConfirmBox = driver.findElement(By.id("confirmbtn"));
		ConfirmBox.click();
		Thread.sleep(1000);
		// driver.switchTo().alert().accept();
		// driver.switchTo().alert().dismiss();

		// System.out.println(driver.switchTo().alert().getText());

	}
	
	
	@AfterTest()
	public void after() {}
		

		
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



