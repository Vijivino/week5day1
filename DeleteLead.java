package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {
@Test
	public  void rundeletelead() throws InterruptedException {
		// TODO Auto-generated method stub

	//Launch the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
   //Enter the username and the password	 
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
   //Click crmlogin,/sfa link,Leads link,Find leads,Phone	
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.partialLinkText("Find")).click();
		//driver.findElement(By.xpath("//div[@class=' x-grid3-cell-inner x-grid3-col-partyId ']")).click();
		driver.findElement(By.xpath("(//span[@class='x-tab-strip-text '])[2]")).click();
	//Enter phone number	
		driver.findElement(By.xpath("//input[@name='phoneAreaCode']")).sendKeys("12");
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("2147483647");
	//Click find leads button	
		driver.findElement(By.xpath("//button[contains(text(),'Find')]")).click();
		Thread.sleep(2000);
	//Capture lead ID of First Resulting lead	
		WebElement id = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]"));
		String text = id.getText();
		System.out.println(text);
	//Click First Resulting lead	
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
	//Click Delete
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
	//Click Find leads
		driver.findElement(By.partialLinkText("Find")).click();
	//Enter captured lead ID	
		driver.findElement(By.xpath("(//div[@class='x-form-element']/input)[13]")).sendKeys(text);
	//Click find leads button	
		driver.findElement(By.xpath("//button[contains(text(),'Find')]")).click();
	//Verify message "No records to display" in the Lead List.
		String text2 = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
		System.out.println(text2);
		if (text2.contains("NO records"))
		{
		System.out.println("Successfully deleted");
		}
		

	}

}
