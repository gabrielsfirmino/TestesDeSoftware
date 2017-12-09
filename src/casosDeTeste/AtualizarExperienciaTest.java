package casosDeTeste;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import acaoParaTeste.LoginAcao;

public class AtualizarExperienciaTest 
{

	@Test
	public void TesteAdicionarExperienciaValida() 
	{
		System.setProperty("webdriver.gecko.driver", "/home/gabrielsfirmino/Downloads/geckodriver");
		
		WebDriver drive = new FirefoxDriver();
		
		drive.get("http://med-profile.apps.intmed.com.br/");
		
		LoginAcao.Logar(drive, "gabrielsfirmino@alu.ufc.br", 85866021);
		
		By xpath_1 = By.xpath("//a[@class='btn btn-primary btn-xs']");
		WebElement button_1 = drive.findElement(xpath_1);
		button_1.click();
		
		By id_1 = By.id("formation_location");
		WebElement campoInstituicao = drive.findElement(id_1);
		campoInstituicao.sendKeys("Universidade Federal do Ceara");
		
//		By id_1 = By.id("formation_location");
//		WebElement campoInstituicao = drive.findElement(id_1);
//		campoInstituicao.sendKeys("Universidade Federal do Ceara");
	}
	
//	@Test
//	public void TesteRemoverExperiencia() 
//	{
//		fail("Not yet implemented");
//	}

}
