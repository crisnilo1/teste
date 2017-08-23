package tes.selenium.org;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;




public class Day1 {
	
	WebDriver driver;
	
	public void invokBrowser(){
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );//A espera implícita serve, basicamente, para dizer ao WebDriver um tempo máximo pelo qual ele deve aguardar quando estiver tentando encontrar um elemento.
			driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
			
			driver.get("https://www.letras.mus.br/");//carrega pag.
			
			seacherCourser();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	public void seacherCourser(){
		
			driver.findElement(By.id("main_suggest")).sendKeys("weak");
			//Thread.sleep(3000);
			driver.findElement(By.className("main-search_submit")).click();
		
	}

	public static void main(String[] args) {
		Day1 myobj = new Day1();
		myobj.invokBrowser();
	}

}
