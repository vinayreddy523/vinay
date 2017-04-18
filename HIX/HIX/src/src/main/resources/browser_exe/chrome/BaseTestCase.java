package src.main.resources.browser_exe.chrome;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import src.test.java.com.hix.test.dataobjects.INDIVIDUAL;
import com.hix.test.framework.utils.CommonUtils;
import com.hix.test.framework.utils.ExcelDataProvider;

/**
 * All the Test classes in the project will extend this BaseTestCase Contains
 * methods using testng annotations that perform operations
 * beforesuite,aftersuite,beforetest,aftertest etc.
 */
public class BaseTestCase {

	private static WebDriver browser = BrowserFactory.getBrowser();

	String fileName = "src/test/resources/testdata/Individuals.xls";
	ExcelDataProvider excelDataProvider;

	@BeforeSuite
	@DataProvider(parallel = false)
	public Object[][] getIndividualData() throws Exception {
		Object[][] object = null;
		object = excelDataProvider.getAllExcelRows(new INDIVIDUAL());
		return object;
	}

	@BeforeSuite
	public void beforeClass() throws IOException {
		excelDataProvider = new ExcelDataProvider(fileName);
	}
	
	

	@AfterMethod
	public void takeScreenShot(Method methodName) {
		try {
			if (methodName != null) {
				String path = CommonUtils.readFromConfig("screenshotpath")
						+ "TC_" + methodName.getName().toString() + "/"
						+ methodName.getName();
				Browser.captureScreenShot(CommonUtils.currentDateFileName(path)
						+ ".jpeg");
			}

		} catch (Exception e) {
		}
	}
	 @AfterSuite(alwaysRun = true)
	 public void resetAndCloseBrowser() {
	 try {
	// browser.quit();
	 } catch (Exception e) {
	 }
	 }
}
