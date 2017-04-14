package src.main.java.com.hix.base;


import java.io.File;
import java.net.URL;

//import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import src.main.java.com.hix.test.framework.utils.CommonUtils;

public class BrowserFactory {
	private static WebDriver browser = null;

	/**
	 * Instantiates the appropriate Browser object Reads the config and creates
	 * Corresponding IE, Firefox or Chrome browser object
	 * 
	 * @return WebDriver
	 * 
	 */
	public static WebDriver getBrowser() {

		if (browser == null) {
			try {

				String browserName = CommonUtils.readFromConfig("Browser");

				if ("FF".equalsIgnoreCase(browserName)) {
					System.out.println("Im inside firefox call ");
					browser = loadFireFoxDriver();
				} else if ("IE".equalsIgnoreCase(browserName)) {
					browser = loadIEDriver();
				} else if ("chrome".equalsIgnoreCase(browserName)) {
					browser = loadChromeDriver();
				}
				
			} catch (Exception exception) {
			}

		}

		return browser;
	}

	/**
	 * private method to load the Firefox Driver
	 * 
	 * @param loadRemote
	 * 
	 */

	private static RemoteWebDriver loadFireFoxDriver() throws Exception {

		String loadffProfile = CommonUtils.readFromConfig("loadffProfile");

		RemoteWebDriver remoteDriver = null;

		FirefoxProfile profile = null;

		if ("true".equalsIgnoreCase(loadffProfile)) {
			String profilePath = CommonUtils
					.readFromConfig("FIREFOXPROFILEDIR");
			File profileDir = new File(profilePath);
			profile = new FirefoxProfile(profileDir);
			profile.setAcceptUntrustedCertificates(false);

		}

		if ("true".equalsIgnoreCase(loadffProfile)) {
			remoteDriver = new FirefoxDriver(profile);
		} else {
			remoteDriver = new FirefoxDriver();
		}
		return remoteDriver;

	}

	/**
	 * private method to load the InternetExplorer Driver
	 * 
	 * @param loadRemote
	 * 
	 */
	private static RemoteWebDriver loadIEDriver() throws Exception {

		RemoteWebDriver remoteDriver = null;
		DesiredCapabilities capabilities = DesiredCapabilities
				.internetExplorer();
		capabilities
				.setCapability(
						InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);

		System.setProperty("webdriver.ie.driver",
				"src/main/resources/browser_exe/ie/IEDriverServer.exe");
		remoteDriver = new InternetExplorerDriver(capabilities);
		return remoteDriver;

	}

	/**
	 * private method to load the Chrome Driver
	 * 
	 * @param loadRemote
	 * 
	 */

	private static RemoteWebDriver loadChromeDriver() throws Exception {

		RemoteWebDriver remoteDriver = null;
		String hostOS = CommonUtils.getHostOperatingSystem();

		if (hostOS.equalsIgnoreCase("Mac OS X")) {
			System.setProperty("webdriver.chrome.driver",
					"src/main/resources/browser_exe/chrome/chromedriver");
		} else {
			System.setProperty("webdriver.chrome.driver",
					"src/main/resources/browser_exe/chrome/chromedriver.exe");
		}		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options); 

		remoteDriver = new ChromeDriver(capabilities);		
		return remoteDriver;
	}

}
