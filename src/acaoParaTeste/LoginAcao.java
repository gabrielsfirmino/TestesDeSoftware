package acaoParaTeste;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginAcao 
{
	
	public static final String AMBIENTE_GABRIEL = "/home/gabrielsfirmino/Downloads/geckodriver";
	public static final String AMBIENTE_CESAR = "C:\\Users\\CESAR\\Documents\\Github\\TrabFinalTestes\\geckodriver-v0.19.1-win64\\geckodriver.exe";
	
	public static File getAmbienteCesar() {
		File file = new File(AMBIENTE_CESAR);
		return file;
	}

	public static void Logar(WebDriver drive, String usuario, String senha)
	{
		By id_1 = By.id("user_email");
		WebElement campoEmail_1 = drive.findElement(id_1);
		campoEmail_1.sendKeys(usuario);
		
		By id_2 = By.id("user_password");
		WebElement campoSenha_1 = drive.findElement(id_2);
		campoSenha_1.sendKeys(senha);
		
		By xpath_1 = By.xpath("//input[@class='btn btn-primary btn-block btn-flat']");
		WebElement button_1 = drive.findElement(xpath_1);
		button_1.click();
	}
	
}
