package casosDeTeste;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EnviarSenhaTest {

	@Test
	public void testeEnviarSenhaParaEmailNaoCadastrado() 
	{
		System.setProperty("webdriver.gecko.driver", "/home/gabrielsfirmino/Downloads/geckodriver");
		
		WebDriver drive = new FirefoxDriver();
		
		drive.get("http://med-profile.apps.intmed.com.br/");
		
		By link_1 = By.linkText("Esqueceu sua senha?");
		WebElement button_1 = drive.findElement(link_1);
		button_1.click();
		
		By id_1 = By.id("user_email");
		WebElement campoEmail = drive.findElement(id_1);
		campoEmail.sendKeys("usuariosemcadastro@gmail.com");
		
		By xpath_1 = By.xpath("//input[@class='btn btn-primary btn-block btn-flat']");
		WebElement button_2 = drive.findElement(xpath_1);
		button_2.click();
		
		drive.close();
	}
	
	@Test
	public void testeEnviarSenhaParaEmailCadastrado() 
	{
		System.setProperty("webdriver.gecko.driver", "/home/gabrielsfirmino/Downloads/geckodriver");
		
		WebDriver drive = new FirefoxDriver();
		
		drive.get("http://med-profile.apps.intmed.com.br/");
		
		By link = By.linkText("Esqueceu sua senha?");
		WebElement button = drive.findElement(link);
		button.click();
		
		By id = By.id("user_email");
		WebElement campoEmail = drive.findElement(id);
		campoEmail.sendKeys("gabrielsfirmino@alu.ufc.br");
		
		By clas = By.xpath("//input[@class='btn btn-primary btn-block btn-flat']");
		WebElement btn = drive.findElement(clas);
		btn.click();
		
		drive.close();
	}

}
