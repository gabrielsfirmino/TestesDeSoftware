package casosDeTeste;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import acaoParaTeste.LoginAcao;

public class EditarUsuarioTest {
	
	@Test
	public void TesteEditarUsuarioDadosValidos() {
		File file = new File("C:\\Users\\CESAR\\Documents\\Github\\TrabFinalTestes\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
		
		WebDriver drive = new FirefoxDriver();
		
		drive.get("http://med-profile.apps.intmed.com.br/");
		
		LoginAcao.Logar(drive, "gabrielsfirmino@alu.ufc.br", 85866021);
		
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
		
		By xpathSave = By.xpath("//*[@id=\"edit_user_440\"]/div[2]/button");
		WebElement save = drive.findElement(xpathSave);
		save.click();
		
		String birthplace = drive.findElement(By.xpath("//*[@id=\"edit_user_440\"]/div[1]/div[3]/span")).getText();
		String crm = drive.findElement(By.xpath("//*[@id=\"edit_user_440\"]/div[1]/div[4]/div[2]/div/span")).getText();
		String cep = drive.findElement(By.xpath("//*[@id=\"edit_user_440\"]/div[1]/div[5]/div[1]/div/span")).getText();
		String number = drive.findElement(By.xpath("//*[@id=\"edit_user_440\"]/div[1]/div[6]/div[2]/div/span")).getText();
		
		assertTrue((birthplace.isEmpty() && crm.isEmpty() && cep.isEmpty() && number.isEmpty()));
	}
	
	@Test
	public void TesteEditarUsuarioDadosInvalidos() {
		File file = new File("C:\\Users\\CESAR\\Documents\\Github\\TrabFinalTestes\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
		
		WebDriver drive = new FirefoxDriver();
		
		drive.get("http://med-profile.apps.intmed.com.br/");
		
		LoginAcao.Logar(drive, "gabrielsfirmino@alu.ufc.br", 85866021);
		
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
		
		By idAddressNumber = By.id("user_address_attributes_number");
		WebElement addressNumber = drive.findElement(idAddressNumber);
		addressNumber.clear();
		addressNumber.sendKeys("450547878787784487");
		
		By xpathSave = By.xpath("//*[@id=\"edit_user_440\"]/div[2]/button");
		WebElement save = drive.findElement(xpathSave);
		save.click();
		
		By xpathError = By.xpath("/html/body/div");
		WebElement error = drive.findElement(xpathError);
		assertTrue(error.isDisplayed());
	}
}
