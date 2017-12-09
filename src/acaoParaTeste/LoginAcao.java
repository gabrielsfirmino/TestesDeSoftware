package acaoParaTeste;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginAcao 
{

	public static void Logar(WebDriver drive, String usuario, int senha)
	{
		By id_1 = By.id("user_email");
		WebElement campoEmail_1 = drive.findElement(id_1);
		campoEmail_1.sendKeys("gabrielsfirmino@alu.ufc.br");
		
		By id_2 = By.id("user_password");
		WebElement campoSenha_1 = drive.findElement(id_2);
		campoSenha_1.sendKeys("85866021");
		
		By xpath_1 = By.xpath("//input[@class='btn btn-primary btn-block btn-flat']");
		WebElement button_1 = drive.findElement(xpath_1);
		button_1.click();
	}
	
}
