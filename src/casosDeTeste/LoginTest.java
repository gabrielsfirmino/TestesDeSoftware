package casosDeTeste;

import static org.junit.Assert.*;

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
		
		LoginAcao.Logar(drive, "gabrielsfirmino@alu.ufc.br", 85866021);
		
		assertTrue(drive.getCurrentUrl().equals("http://med-profile.apps.intmed.com.br/perfil"));
		
		By xpath = By.xpath("//ul[@class='list-group list-group-unbordered']");
		WebElement elemento = drive.findElement(xpath);
		assertTrue(elemento.getText().contains("gabrielsfirmino@alu.ufc.br"));
		
		drive.close();
		
	}
	
//	@Test
//	public void TesteLogarComUsuarioNaoCadastrado() 
//	{
//		fail("Not yet implemented");
//	}

}
