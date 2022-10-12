package week5.day1;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLead extends TestngBaseClass {

	@Test(dataProvider ="create")
	public void runCreateLead(String copmpanyname,String firstname,String lastname) {
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(copmpanyname);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastname);
		driver.findElement(By.name("submitButton")).click();
		
	}
	
	@DataProvider(name ="create")
	public String[][] fetchdata() {
		String[][] data=new String[2][3];
		data[0][0]="testleaf";
		data[0][1]="viji";
		data[0][2]="R";
		
		data[1][0]="tcs";
		data[1][1]="vinoth";
		data[1][2]="k";		
		return data;
	}
	
	/*@DataProvider(name="create")
	public String[][] fetchdata() throws IOException{
		String[][] data;
		
		data = ReadExcel.runreadexcel("LeaftapsCred");
		return data;
		
	}
	*/
	
	
	
	
}
