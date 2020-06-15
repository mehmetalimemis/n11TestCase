package TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class n11TestCase {

	public static void main(String[] args) {

//		Define Chrome Driver
		System.setProperty("webdriver.chrome.driver", "C:\\chrome\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

//		Open the link and maximize the window
		driver.get("https://www.n11.com/");
		driver.manage().window().maximize();
		String pageTitle = driver.getTitle();
		System.out.println("ActualTitle is " + pageTitle);

//	    Close the message
		driver.findElement(By.className("closeBtn")).click();

//	    Open the sign in page
		driver.findElement(By.className("btnSignIn")).click();

//		Login n11.com
		driver.findElement(By.id("email")).sendKeys("mmtalii86@gmail.com");
		driver.findElement(By.id("password")).sendKeys("n11girissifresi");
		driver.findElement(By.xpath("//*[@id=\"loginButton\"]")).click();

//	    Search samsung 
		driver.findElement(By.id("searchData")).sendKeys("samsung");
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[2]/div[1]/a/span")).click();
		String searchSamsung = driver.getTitle();
		System.out.println("SearchTitle is " + searchSamsung);

//	    Click second link 
		driver.findElement(By.xpath("//*[@id=\"p-425569920\"]/div[1]/a/h3")).click();
		String secondLink = driver.getTitle();
		System.out.println("SecondLinkTitle is " + secondLink);

//	    Add to favorites and print the production title
		driver.navigate().back();
		driver.findElement(By.xpath("//*[@id=\"p-420814918\"]/div[1]/span")).click();
		driver.findElement(By.id("p-420814918")).click();
		String thirdProductionTitle = driver.getTitle();
		System.out.println("ProductionTitle is " + thirdProductionTitle);

//	    Click my favorites
		driver.navigate().back();
		Select drpMyPage = new Select(driver.findElement(By.name("Hesabım")));
		drpMyPage.selectByVisibleText("Favorilerim / Listelerim");
		driver.findElement(By.className("listItemTitle")).click();

//	    My favorites list
		driver.findElement(By.id("p-420814918")).click();
		String thirdProductionTitle2 = driver.getTitle();
		System.out.println("ProductionTitle is " + thirdProductionTitle2);

//	    Delete my favorite 
		driver.navigate().back();
		driver.findElement(By.className("deleteProFromFavorites")).click();
		driver.findElement(By.className("closeBtn")).click();

//	    No favorite in the link
		WebElement noFavorites = driver.findElement(By.xpath("//*[@id=\"watchList\"]/div"));
		System.out.println(noFavorites);

//		Quit
		driver.quit();

	}

}
