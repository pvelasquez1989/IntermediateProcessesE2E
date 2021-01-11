package co.com.bancolombia.certificacion.intermediateprocesses.util.driver;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.windows.WindowsDriver;


public class WinAppDriver {
	
	private WindowsDriver<WebElement> winDriver;
	public WinAppDriver (String winName) {
		DesiredCapabilities capabilities= new DesiredCapabilities();
		capabilities.setCapability("app", winName);
		capabilities.setCapability("platformName", "windows");
		capabilities.setCapability("deviceName", "CPX-S9XZ44L3X2M");
		winDriver = null;
		
		try {
			winDriver = new WindowsDriver<>(new java.net.URL("http://127.0.0.1:4723/"), capabilities);
			winDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (Exception e) {
	        Logger.getLogger("Log").log(Level.WARNING, e.getMessage());
		}
	}

	public WindowsDriver<WebElement> sapLogon(){
		return winDriver;
	}
	
	public static WinAppDriver theApplication(String winName) {
		return new WinAppDriver(winName);
	}
	
	public WindowsDriver<WebElement> switchWindow() {
			WebElement winName = winDriver.findElement(By.className("SAP_FRONTEND_SESSION"));
			String winNameTopLevelWindowHandle = winName.getAttribute("NativeWindowHandle");
			winNameTopLevelWindowHandle = Integer.toHexString(Integer.parseInt(winNameTopLevelWindowHandle));
			
			DesiredCapabilities capabilities= new DesiredCapabilities();
			capabilities.setCapability("platformName", "windows");
			capabilities.setCapability("appTopLevelWindow", winNameTopLevelWindowHandle);
			
			try {
				winDriver = new WindowsDriver<>(new java.net.URL("http://127.0.0.1:4723/"), capabilities);
				winDriver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
				return winDriver;
			} catch (MalformedURLException e) {
		        Logger.getLogger("Log").log(Level.WARNING, e.getMessage());
				return null;
			}
	}
}
