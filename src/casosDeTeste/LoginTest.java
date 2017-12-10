package casosDeTeste;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import acaoParaTeste.LoginAcao;

public class LoginTest {

	@Test
	public void TesteLogarComUsuarioCadastrado() 
	{
		
		System.setProperty("webdriver.gecko.driver", LoginAcao.AMBIENTE_GABRIEL);
		
		WebDriver drive = new FirefoxDriver();
		
		drive.get("http://med-profile.apps.intmed.com.br/");
		
		LoginAcao.Logar(drive, "gabrielsfirmino@alu.ufc.br", String.valueOf(85866021));
		
		assertTrue(drive.getCurrentUrl().equals("http://med-profile.apps.intmed.com.br/perfil"));
		
		By xpath = By.xpath("//ul[@class='list-group list-group-unbordered']");
		WebElement elemento = drive.findElement(xpath);
		assertTrue(elemento.getText().contains("gabrielsfirmino@alu.ufc.br"));
		
		drive.close();
		
	}
	
	@Test
	public void TesteLogarComUsuarioNaoCadastrado(){
		System.setProperty("webdriver.gecko.driver", LoginAcao.getAmbienteCesar().getAbsolutePath());
		
		WebDriver drive = new FirefoxDriver();
		
		drive.get("http://med-profile.apps.intmed.com.br/login");
		
		LoginAcao.Logar(drive, "teste@teste.com.br", String.valueOf(85866021));
		
		By xpathError = By.xpath("/html/body/div/div[2]/div");
		WebElement error = drive.findElement(xpathError);
		
		assertTrue(error.isDisplayed());
		
		drive.close();
	}

}
