package support;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Set;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;

import definitions.hooks;

public class util extends hooks {
	public static WebDriverWait wait;
	public static JavascriptExecutor js;

    public util() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        js = (JavascriptExecutor) driver;
    }

    public void ventanaActiva(){
        Set<String> identificadores = driver.getWindowHandles();
        for (String identificador:identificadores){
            driver.switchTo().window(identificador);
        }
    }

    public void ventanaInicial(){
        driver.close();
        driver.switchTo().window("");
    }
    public void scrollVertical(){
        js.executeScript("window.scrollBy(0,1000)");
    }
    public static void evidencias() throws IOException {
    	Date fecha = new Date();
    	SimpleDateFormat formato =  new SimpleDateFormat("ddMMyyyy_HHmmssSSS");
    	String path = "\\Users\\PC\\eclipse-workspace\\Proyecto.Febrero\\target\\evidencias\\";
    	String nombre = formato.format(fecha)+"_evidencia.jpg";
    	
    	File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(file, new File(path+nombre));

    }
}
