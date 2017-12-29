package stepDefinition;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.When;

public class test {
	
	ChromeDriver driver;
	
	@When("^I open n number of website$")
	  public void I_open_n_number_0f_website() throws Exception
	{  
		  	System.setProperty("webdriver.chrome.driver", "D:\\Sel\\Selenium with Cucumber project\\chromedriver.exe");
	 //Read the txt file
	  		FileReader FR = new FileReader("D:\\Sel\\Selenium with Cucumber project\\input.txt");
	  		BufferedReader BR = new BufferedReader(FR);
	  		String Content = "";
	  
	 //Loop to read all lines one by one from file and print It.
	   		while((Content = BR.readLine())!= null)
	   {
	 //lanch the browser 
	   		driver=new ChromeDriver();
	 //get the url
	   		driver.get(Content);
	 //get the title 	
			String title=driver.getTitle();
			System.out.println(title);
	 // write the data txt file
			BufferedWriter bw=new BufferedWriter(new FileWriter("D:\\output-"+title+".txt"));
	 /*//verify url 
			String ActualURL=driver.getCurrentUrl();
 			Assert.assertEquals(ActualURL, Content);*/
 	 //get the all links
 		    List<WebElement> all_links_webpage = driver.findElements(By.tagName("a")); 
			System.out.println("Total no of links Available: " + all_links_webpage.size());
			int k = all_links_webpage.size();
			System.out.println("List of links Available: ");
			for(int i=0;i<k;i++)
			{
		    String link11 = all_links_webpage.get(i).getAttribute("href");
			System.out.println(link11);
			bw.write(link11);
			bw.write("\r\n"); 
			}
	// close the txt file
			 bw.close();
	//close the browser 
			 driver.close(); 
	  }
         	  }
}
