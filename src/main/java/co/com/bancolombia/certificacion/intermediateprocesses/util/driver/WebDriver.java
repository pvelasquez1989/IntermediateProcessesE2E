package co.com.bancolombia.certificacion.intermediateprocesses.util.driver;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import co.com.bancolombia.certificacion.intermediateprocesses.util.Files;
import net.thucydides.core.webdriver.SerenityWebdriverManager;

public class WebDriver {

	public WebDriver() {
	}

	private static String downloadFilepath;
	private static ChromeDriver driver;

	public static ChromeDriver solman() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/files/chromedriver.exe");
		downloadFilepath = System.getProperty("user.dir").concat("\\target\\site\\serenity\\CBTA");
		Files.createFolder(downloadFilepath);
		Files.cleanFolder(downloadFilepath);
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		@SuppressWarnings({ "rawtypes", "unchecked" })
		HashMap<String, Object> chromePrefs = new HashMap();
		chromePrefs.put("download.default_directory", downloadFilepath);
		Logger.getLogger("Log").log(Level.INFO, downloadFilepath);
		chromeOptions.setExperimentalOption("prefs", chromePrefs);
		driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://pbmdebpass01.bancolombia.corp/sap/bc/webdynpro/sap/smud_frame");
		SerenityWebdriverManager.inThisTestThread().setCurrentDriverTo(driver);
		return driver;
	}

	public static String getDownloadFilepath() {
		return downloadFilepath;
	}

	public static ChromeDriver successFactors() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/files/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://performancemanager8.successfactors.com/login?/companyEntry");
		SerenityWebdriverManager.inThisTestThread().setCurrentDriverTo(driver);
		return driver;
	}
}
