package casosDeTeste;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import acaoParaTeste.LoginAcao;

public class EnviarSenhaTest 
{

	@Test
	public void TesteEnviarSenhaParaEmailNaoCadastrado()
	{
		System.setProperty("webdriver.gecko.driver", LoginAcao.AMBIENTE_GABRIEL);
		
		WebDriver drive = new FirefoxDriver();
		
		drive.get("http://med-profile.apps.intmed.com.br/");
		
		By link_1 = By.linkText("Esqueceu sua senha?");
		WebElement button_1 = drive.findElement(link_1);
		button_1.click();
		
		By id_1 = By.id("user_email");
		WebElement campoEmail_1 = drive.findElement(id_1);
		campoEmail_1.sendKeys("usuariosemcadastro@gmail.com");
		
		By xpath_1 = By.xpath("//input[@class='btn btn-primary btn-block btn-flat']");
		WebElement button_2 = drive.findElement(xpath_1);
		button_2.click();
		
		By xpath_2 = By.xpath("//div[@id='error_explanation']");
		WebElement message_1 = drive.findElement(xpath_2);
		assertTrue(message_1.getText().contains("Email não encontrado"));
		
		drive.close();
	}
	
	@Test
	public void TesteEnviarSenhaParaEmailCadastrado() 
	{
		System.setProperty("webdriver.gecko.driver", LoginAcao.AMBIENTE_GABRIEL);
		
		WebDriver drive = new FirefoxDriver();
		
		drive.get("http://med-profile.apps.intmed.com.br/");
		
		By link_2 = By.linkText("Esqueceu sua senha?");
		WebElement button_3 = drive.findElement(link_2);
		button_3.click();
		
		By id_2 = By.id("user_email");
		WebElement campoEmail_2 = drive.findElement(id_2);
		campoEmail_2.sendKeys("gabrielsfirmino@alu.ufc.br");
		
		By xpath_3 = By.xpath("//input[@class='btn btn-primary btn-block btn-flat']");
		WebElement button_4 = drive.findElement(xpath_3);
		button_4.click();
		
		assertTrue(drive.getCurrentUrl().equals("http://med-profile.apps.intmed.com.br/login"));
		
		drive.close();
	}

}
