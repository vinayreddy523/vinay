package com.hix.tests.smokes;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hix.test.dataobjects.INDIVIDUAL;
import com.hix.test.dataobjects.PERSONS;
import com.hix.test.framework.utils.ExcelDataProvider;

public class ExcelDataProviderGetRows {

	String fileName = "src/test/resources/testdata/Individuals.xls";
	ExcelDataProvider excelDataProvider;

	@DataProvider(parallel = true)
	public Object[][] getIndividualData() throws Exception {
		Object[][] object = null;
		object = excelDataProvider.getAllExcelRows(new INDIVIDUAL());
		return object;
	}

	@Test(dataProvider = "getIndividualData")
	public void getAllExcelRows(INDIVIDUAL myData) throws Exception {
		System.out.println("Zip Code :" + myData.getZipCode().toString());
		System.out.println("Start Date :" + myData.getStartDate().toString());
	}

	@DataProvider(parallel = true)
	public Object[][] getPersonData() throws Exception {
		Object[][] object = null;
		object = excelDataProvider.getAllExcelRows(new PERSONS());
		return object;
	}

	@Test(dataProvider = "getPersonData")
	public void getAllExcelRows(PERSONS myData) throws Exception {
		System.out.println("Date of Birth :" + myData.getDateOfBirth().toString());
		System.out.println("Gender :" + myData.getGender().toString());
	}
	
	@BeforeClass
	public void beforeClass() throws IOException {
		excelDataProvider = new ExcelDataProvider(fileName);
	}

}
