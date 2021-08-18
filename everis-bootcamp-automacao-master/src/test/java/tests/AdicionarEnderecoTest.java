package tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.RealizarLoginPage;

public class AdicionarEnderecoTest {

    
	private ChromeDriver driver;
    

	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
        
	}

    @Test
	public void AdicionarEndereco() {
		
        
        RealizarLoginPage login = new RealizarLoginPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        driver.get("http://automationpractice.com/index.php");
        

        login.RealizarLogin();
        driver.findElement(By.cssSelector("#center_column > div > div:nth-child(1) > ul > li:nth-child(3) > a > span")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#center_column > div.clearfix.main-page-indent > a > span")));
        driver.findElement(By.cssSelector("#center_column > div.clearfix.main-page-indent > a > span")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#submitAddress > span")));
        driver.findElement(By.id("firstname")).sendKeys("roberval");
        driver.findElement(By.id("lastname")).sendKeys("Da silva");
        driver.findElement(By.id("company")).sendKeys("Everis NTT DATA");
        driver.findElement(By.id("address1")).sendKeys("Av Street");
        driver.findElement(By.id("address2")).sendKeys("Delaware");
        driver.findElement(By.id("city")).sendKeys("New Houston");
        driver.findElement(By.id("id_state")).sendKeys("Arizona");
        driver.findElement(By.id("id_country")).sendKeys("United States");
        driver.findElement(By.id("postcode")).sendKeys("17567");
        driver.findElement(By.id("phone")).sendKeys("119988998877");
        driver.findElement(By.id("phone_mobile")).sendKeys("11999999996");
        driver.findElement(By.id("alias")).sendKeys("Um novo endereço");
        driver.findElement(By.cssSelector("#submitAddress > span")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#center_column > div.clearfix.main-page-indent > a > span")));
        WebElement validaTexto = driver.findElement(By.cssSelector("#center_column > div.clearfix.main-page-indent > a > span"));
		Assert.assertEquals("Add a new address", validaTexto.getText());
        
		
	}

    @After
	public void afterCenario() {
			driver.quit();		
	}

}