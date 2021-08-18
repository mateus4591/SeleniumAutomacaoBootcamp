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

import pages.AdicionarEnderecoPage;

public class AdicionarEnderecoPageTeste {

	private WebDriver driver;
	private AdicionarEnderecoPage adicionarEnderecoPage;

	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		adicionarEnderecoPage = new AdicionarEnderecoPage(driver);
	}

    @Test
	public void AdicionarEnderecoPage() {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);

		adicionarEnderecoPage.AdicionarEndereco();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#center_column > div.clearfix.main-page-indent > a > span")));
        WebElement validaTexto = driver.findElement(By.cssSelector("#center_column > div.clearfix.main-page-indent > a > span"));
		Assert.assertEquals("Add a new address", validaTexto.getText());
		
	}

    @After
	public void afterCenario() {
			driver.quit();
	}
}