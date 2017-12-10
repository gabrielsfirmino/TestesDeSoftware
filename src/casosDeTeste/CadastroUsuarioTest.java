package casosDeTeste;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import acaoParaTeste.LoginAcao;

public class CadastroUsuarioTest {
	
	@Test
	public void TesteCadastrarUsuarioInformacoesValidas() {
		
		System.setProperty("webdriver.gecko.driver", LoginAcao.getAmbienteCesar().getAbsolutePath());
		
		WebDriver drive = new FirefoxDriver();
		
		drive.get("http://med-profile.apps.intmed.com.br/cadastro");
		
		By idName = By.id("user_name");
		WebElement userName = drive.findElement(idName);
		userName.sendKeys("César Rodrigues Nascimento");
		
		By idUserCPF = By.id("user_cpf");
		WebElement userCPF = drive.findElement(idUserCPF);
		userCPF.sendKeys("06001137366");
		
		By idPhone = By.id("user_phone");
		WebElement userPhone = drive.findElement(idPhone);
		userPhone.sendKeys("85985363983");
		
		By idUserEmail = By.id("user_email");
		WebElement userEmail = drive.findElement(idUserEmail);
		userEmail.sendKeys("teste4322211@teste1342212.com");
		
		By idPassword = By.id("user_password");
		WebElement userPassword = drive.findElement(idPassword);
		userPassword.sendKeys("85363983");
		
		By idConfirmPassword = By.id("user_password_confirmation");
		WebElement userConfirmPassword = drive.findElement(idConfirmPassword);
		userConfirmPassword.sendKeys("85363983");
		
		By xpathRegister = By.xpath("/html/body/div/div[2]/form/div[7]/div[2]/input");
		WebElement buttonRegister = drive.findElement(xpathRegister);
		buttonRegister.click();
		
		drive.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
		String url = drive.getCurrentUrl();
		assertTrue(url.equals("http://med-profile.apps.intmed.com.br/perfil/editar"));
		
		drive.close();
	}
	
	@Test
	public void TesteCadastrarUsuarioInformacoesInvalidas() {
		
		System.setProperty("webdriver.gecko.driver", LoginAcao.getAmbienteCesar().getAbsolutePath());
		
		WebDriver drive = new FirefoxDriver();
		
		drive.get("http://med-profile.apps.intmed.com.br/cadastro");
		
		By idName = By.id("user_name");
		WebElement userName = drive.findElement(idName);
		userName.sendKeys("César Rodrigues Nascimento");
		
		By idUserCPF = By.id("user_cpf");
		WebElement userCPF = drive.findElement(idUserCPF);
		userCPF.sendKeys("06001137365");
		
		By idPhone = By.id("user_phone");
		WebElement userPhone = drive.findElement(idPhone);
		userPhone.sendKeys("85985363983");
		
		By idUserEmail = By.id("user_email");
		WebElement userEmail = drive.findElement(idUserEmail);
		userEmail.sendKeys("teste@teste.com");
		
		By idPassword = By.id("user_password");
		WebElement userPassword = drive.findElement(idPassword);
		userPassword.sendKeys("85363983");
		
		By idConfirmPassword = By.id("user_password_confirmation");
		WebElement userConfirmPassword = drive.findElement(idConfirmPassword);
		userConfirmPassword.sendKeys("853639835");
		
		By xpathRegister = By.xpath("/html/body/div/div[2]/form/div[7]/div[2]/input");
		WebElement buttonRegister = drive.findElement(xpathRegister);
		buttonRegister.click();
		
		String emailSpan = drive.findElement(By.xpath("/html/body/div/div[2]/form/div[4]/span[2]")).getText();
		String passwordSpan = drive.findElement(By.xpath("/html/body/div/div[2]/form/div[6]/span[2]")).getText();
		
		assertTrue(!emailSpan.isEmpty() || !passwordSpan.isEmpty());
		
		drive.close();
	}
}
