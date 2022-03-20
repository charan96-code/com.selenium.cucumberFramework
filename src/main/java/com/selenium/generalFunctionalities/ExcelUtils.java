package com.selenium.generalFunctionalities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private static Sheet sheet = null;
	private static Workbook workbook = null;

	/***
	 * Method to open an Excel File
	 */
	public static Workbook setExcel(String excelFilePath) {
		try {
			FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
			workbook = getWorkbook(inputStream, excelFilePath);

		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return workbook;
	}

	/***
	 * Method to close an Excel File
	 */
	public static void closeExcel() {
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/***
	 * Method to get workbook from excel file
	 */
	private static Workbook getWorkbook(FileInputStream inputStream, String excelFilePath) throws IOException {
		Workbook workBook = null;
		if (excelFilePath.endsWith("xlsx")) {
			workBook = new XSSFWorkbook(inputStream);
		} else if (excelFilePath.endsWith("xls")) {
			workBook = new HSSFWorkbook(inputStream);
		} else {
			throw new IllegalArgumentException("The specified file is not Excel file");
		}
		return workBook;
	}
}