package tes.selenium.org;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class testCommand {

	WebDriver driver;
	JavascriptExecutor jse;
		
	public void invoqueBronwser(){
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
			getCommands();
			//SearchCourser();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	/*public void SearchCourser(){
		try {
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	*/
	public void getCommands(){
		
		try {
			driver.get("https://www.letras.mus.br/");//vai p pagina
			String titleofPage = driver.getTitle();
			
			driver.findElement(By.id("main_suggest")).sendKeys("weak");//procura musica
			Thread.sleep(5000);
			
			driver.findElement(By.className("main-search_submit")).click();
			System.out.println("Title of Page"+titleofPage);
			driver.findElement(By.linkText("Enviar letra")).click();
			String currentUrl = driver.getCurrentUrl();
			System.out.println("The Current Url is"+currentUrl);
			Thread.sleep(3000);
			
			driver.findElement(By.className("ccid_login_f")).click();
			System.out.println("Title of Page"+titleofPage);
			Thread.sleep(3000);
			
			driver.quit();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		testCommand myObj = new testCommand();
		myObj.invoqueBronwser();
		
		
	}

}
