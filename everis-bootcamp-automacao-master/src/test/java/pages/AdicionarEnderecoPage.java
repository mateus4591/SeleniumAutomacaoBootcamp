package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Utils;

public class AdicionarEnderecoPage {
	
	private WebDriver driver;
	private Utils util;
    RealizarLoginPage login = new RealizarLoginPage(driver);
	
	public AdicionarEnderecoPage(WebDriver driver) {
		this.driver = driver;
        util = new Utils(driver);

	}
	
    public void AdicionarEndereco() { 
        WebDriverWait wait = new WebDriverWait(driver, 15);
        driver.get("http://automationpractice.com/index.php");

        

        login.RealizarLogin();
        util.clickPorCss("#center_column > div > div:nth-child(1) > ul > li:nth-child(3) > a > span");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#center_column > div.clearfix.main-page-indent > a > span")));
        util.clickPorCss("#center_column > div.clearfix.main-page-indent > a > span");
        util.preencheCampoPorId("firstname", "roberval");
        util.preencheCampoPorId("lastname", "da silva");
        util.preencheCampoPorId("company", "Everis");
        util.preencheCampoPorId("address1", "Av. Burglary");
        util.preencheCampoPorId("address2", "274");
        util.preencheCampoPorId("city", "New Hampshire");
        util.preencheCampoPorId("id_state", "Arizona");
        util.preencheCampoPorId("postcode", "17568");
        util.preencheCampoPorId("id_country", "United States");
        util.preencheCampoPorId("phone", "1188888888");
        util.preencheCampoPorId("phone_mobile", "1199999999");
        util.preencheCampoPorId("alias", "Endereconovoaimen");
        util.clickPorCss("#submitAddress > span");

    }

}