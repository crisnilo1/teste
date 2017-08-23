package tes.selenium.org;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestComandoNavegacao {
	WebDriver driver;

public void invocarBrowser(){
	System.setProperty("webdriver.chrome.driver","C:\\Selenium\\Chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
	comandoNavegacao();
}
public void comandoNavegacao(){
	try {
		driver.navigate().to("http://minhasplantas.com.br/");
		driver.findElement(By.className("Plantas")).click();
		driver.findElement(By.xpath("//li [contains(text(), 'flores')]")).click();//uhuuu
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.navigate().refresh();
		driver.close();//fecha a pag
		//driver.quit();//fecha a janela 
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
}
public static void main(String[]args) {
	
	TestComandoNavegacao myobj = new  TestComandoNavegacao();
	myobj.invocarBrowser();
	
}
}