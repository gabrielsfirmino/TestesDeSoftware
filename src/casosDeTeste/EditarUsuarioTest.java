package casosDeTeste;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import acaoParaTeste.LoginAcao;

public class EditarUsuarioTest {
	
	@Test
	public void TesteEditarUsuarioDadosValidos() {
		System.setProperty("webdriver.gecko.driver", LoginAcao.AMBIENTE_GABRIEL);
		
		WebDriver drive = new FirefoxDriver();
		
		drive.get("http://med-profile.apps.intmed.com.br/");
		
		LoginAcao.Logar(drive, "cesar.nascimento.ufc@gmail.com", String.valueOf(85363983));
		
		By idUserBirthplace = By.id("user_birthplace");
		WebElement userBirthplace = drive.findElement(idUserBirthplace);
		userBirthplace.clear();
		userBirthplace.sendKeys("Fortaleza");
		
		By idUserCRM = By.id("user_crm");
		WebElement userCRM = drive.findElement(idUserCRM);
		userCRM.clear();
		userCRM.sendKeys("4375");
		
		By idUserCRMLocation = By.id("user_crm_location");
		WebElement userCRMLocation = drive.findElement(idUserCRMLocation);
		userCRMLocation.sendKeys("CE");
		
		By idUserCEP = By.id("user_address_attributes_cep");
		WebElement userCEP = drive.findElement(idUserCEP);
		userCEP.clear();
		userCEP.sendKeys("61621015");
		
		By idAddressNumber = By.id("user_address_attributes_number");
		WebElement addressNumber = drive.findElement(idAddressNumber);
		addressNumber.clear();
		addressNumber.sendKeys("450");
		
		By idCity = By.id("user_address_attributes_city");
		WebElement addressCity = drive.findElement(idCity);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		By xpathSave = By.xpath("//html/body/div/div[2]/section/div/div/div[2]/form/div[2]/button");
		WebElement save = drive.findElement(xpathSave);
		save.click();
		
		String birthplace = drive.findElement(By.xpath("//*[@id=\"edit_user_487\"]/div[1]/div[3]/span")).getText();
		String crm = drive.findElement(By.xpath("//*[@id=\"edit_user_487\"]/div[1]/div[4]/div[2]/div/span")).getText();
		String cep = drive.findElement(By.xpath("//*[@id=\"edit_user_487\"]/div[1]/div[5]/div[1]/div/span")).getText();
		String number = drive.findElement(By.xpath("//*[@id=\"edit_user_487\"]/div[1]/div[6]/div[2]/div/span")).getText();
		
		assertTrue((birthplace.isEmpty() && crm.isEmpty() && cep.isEmpty() && number.isEmpty()));
		
		drive.close();
	}
	
	@Test
	public void TesteEditarUsuarioDadosInvalidos() {
		System.setProperty("webdriver.gecko.driver", LoginAcao.AMBIENTE_GABRIEL);
		
		WebDriver drive = new FirefoxDriver();
		
		drive.get("http://med-profile.apps.intmed.com.br/");
		
		LoginAcao.Logar(drive, "cesar.nascimento.ufc@gmail.com", String.valueOf(85363983));
		
		By idUserBirthplace = By.id("user_birthplace");
		WebElement userBirthplace = drive.findElement(idUserBirthplace);
		userBirthplace.clear();
		userBirthplace.sendKeys("sadgsadgyasdgaydgaydgays");
		
		By idUserCRM = By.id("user_crm");
		WebElement userCRM = drive.findElement(idUserCRM);
		userCRM.clear();
		userCRM.sendKeys("437546545645456456");
		
		By idUserCRMLocation = By.id("user_crm_location");
		WebElement userCRMLocation = drive.findElement(idUserCRMLocation);
		userCRMLocation.sendKeys("XR");
		
		By idUserCEP = By.id("user_address_attributes_cep");
		WebElement userCEP = drive.findElement(idUserCEP);
		userCEP.clear();
		userCEP.sendKeys("999999999");
		
		drive.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		By idAddressNumber = By.id("user_address_attributes_number");
		WebElement addressNumber = drive.findElement(idAddressNumber);
		addressNumber.clear();
		addressNumber.sendKeys("450547878787784487");
		
		By xpathSave = By.xpath("//html/body/div/div[2]/section/div/div/div[2]/form/div[2]/button");
		WebElement save = drive.findElement(xpathSave);
		save.click();
		
		By xpathError = By.xpath("/html/body/div");
		WebElement error = drive.findElement(xpathError);
		assertTrue(error.isDisplayed());
		
		drive.close();
	}
}
