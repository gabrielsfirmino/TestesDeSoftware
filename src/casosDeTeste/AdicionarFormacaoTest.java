package casosDeTeste;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import acaoParaTeste.LoginAcao;

public class AdicionarFormacaoTest 
{

	@Test
	public void TesteAdicionarFormacaoValida() 
	{
		System.setProperty("webdriver.gecko.driver", "/home/gabrielsfirmino/Downloads/geckodriver");
		
		WebDriver drive = new FirefoxDriver();
		
		drive.get("http://med-profile.apps.intmed.com.br/");
		
		LoginAcao.Logar(drive, "gabrielsfirmino@alu.ufc.br", 85866021);
		
		
	}
	
//	@Test
//	public void TesteAdicionarFormacaoInvalida() 
//	{
//		fail("Not yet implemented");
//	}

}
