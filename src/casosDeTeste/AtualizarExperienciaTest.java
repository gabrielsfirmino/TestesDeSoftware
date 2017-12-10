package casosDeTeste;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import acaoParaTeste.LoginAcao;

public class AtualizarExperienciaTest 
{

	@Test
	public void TesteAdicionarExperiencia() 
	{
		System.setProperty("webdriver.gecko.driver", LoginAcao.AMBIENTE_GABRIEL);
		
		WebDriver drive = new FirefoxDriver();
		
		drive.get("http://med-profile.apps.intmed.com.br/");
		
		LoginAcao.Logar(drive, "gabrielsfirmino@alu.ufc.br", String.valueOf(85866021));
		
		By xpath_1 = By.xpath("//a[@href='/experiences/new']");
		WebElement button_1 = drive.findElement(xpath_1);
		button_1.click();
		
		By id_1 = By.id("experience_post");
		WebElement campoCargo = drive.findElement(id_1);
		campoCargo.sendKeys("Testador");
		
		By id_2 = By.id("experience_location");
		WebElement campoInstituicao = drive.findElement(id_2);
		campoInstituicao.sendKeys("Universidade Federal do Ceara");
		
		By id_3 = By.id("experience_initial_date");
		WebElement campoDataInicial = drive.findElement(id_3);
		campoDataInicial.sendKeys("032017");
		
		By id_4 = By.id("experience_final_date");
		WebElement campoDataFinal = drive.findElement(id_4);
		campoDataFinal.sendKeys("012018");
		
		By xpath_2 = By.xpath("//button[@class='btn btn-info pull-right']");
		WebElement button_2 = drive.findElement(xpath_2);
		button_2.click();
		
		By xpath_3 = By.xpath("//div[@id='experiences']");
		WebElement elemento = drive.findElement(xpath_3);
		assertTrue(elemento.getText().contains("Testador"));
		
		drive.close();
	}
	
//	@Test
//	public void TesteRemoverExperiencia() 
//	{
//		System.setProperty("webdriver.gecko.driver", "/home/gabrielsfirmino/Downloads/geckodriver");
//		
//		WebDriver drive = new FirefoxDriver();
//		
//		drive.get("http://med-profile.apps.intmed.com.br/");
//		
//		LoginAcao.Logar(drive, "gabrielsfirmino@alu.ufc.br", 85866021);
//		
//		By xpath_1 = By.xpath("//td[contains(text(), 'Testador')]//a[]");
//		WebElement button_1 = drive.findElement(xpath_1);
//		button_1.click();
//		
//		By xpath_2 = By.xpath("//a[contains(text(), 'Você tem certeza?')]");
//		WebElement button_2 = drive.findElement(xpath_2);
//		
//		WebDriverWait wait = new WebDriverWait(drive, 5);
//		wait.until(ExpectedConditions.visibilityOf(button_2));
//		
//		button_2.click();
//		
//		By xpath_3 = By.xpath("//div[@id='experiences']");
//		WebElement elemento = drive.findElement(xpath_3);
//		assertFalse(elemento.getText().contains("Testador"));
//	}

}
