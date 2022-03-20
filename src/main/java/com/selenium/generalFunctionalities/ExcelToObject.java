package com.selenium.generalFunctionalities;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelToObject {

	/***
	 * Method to read MetaData Excel File
	 */
	public static List<ExcelValues> readXlFile() {
		List<ExcelValues> excelLst = new ArrayList<ExcelValues>();
		try {
			FileInputStream file = new FileInputStream(Constants.dataPath+Constants.metaDataName);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIt = sheet.rowIterator();
			while (rowIt.hasNext()) {
				ExcelValues excelValues = new ExcelValues();
				Row row = rowIt.next();
				if (row.getRowNum() != 0) {
					for (Cell cell : row) {

						int colunmCnt = cell.getColumnIndex();

						if (colunmCnt == 0) {
							if(cell.getCellType().equals(CellType.STRING)) {
								excelValues.setTestCaseName(cell.getStringCellValue());
							} else if(cell.getCellType().equals(CellType.NUMERIC))
							{
								Object o = cell.getNumericCellValue();
								excelValues.setTestCaseName(new BigDecimal(o.toString()).toPlainString());
							}						
						}

						else if (colunmCnt == 1) {
							if(cell.getCellType().equals(CellType.STRING)) {
								excelValues.setDescription(cell.getStringCellValue());
							} else if(cell.getCellType().equals(CellType.NUMERIC))
							{
								Object o = cell.getNumericCellValue();
								excelValues.setDescription(new BigDecimal(o.toString()).toPlainString());
							}						
						}

						else if(colunmCnt == 2) {
							if(cell.getCellType().equals(CellType.STRING)) {
								excelValues.setExecuteStatus(cell.getStringCellValue());
							} else if(cell.getCellType().equals(CellType.NUMERIC))
							{
								Object o = cell.getNumericCellValue();
								excelValues.setExecuteStatus(new BigDecimal(o.toString()).toPlainString());
							}
						}

					}
					excelLst.add(excelValues);
				}
			}
			System.out.println("test results -" + excelLst);
			file.close();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return excelLst;
	}		
}