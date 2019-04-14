package myTestPackage.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import components.Coordinates;
import myTestPackage.map.Tile;
import myTestPackage.map.TileType;
import myTestPackage.utils.Constants;

public abstract class ExcelLoader {
	private static XSSFWorkbook currentExcelBook = null;
	private static FileInputStream inputExcelFile = null;
	private static XSSFSheet currentTable = null;
	private static XSSFRow currentRow = null;
	private static XSSFCell currentCell = null;
	
	public static void loadChunkInArray(String nameFile, Tile[][] arrayTiles) {
		getConnectionWithExcelFile(nameFile);
		loadMapInArray(arrayTiles);
	}
	
	private static void getConnectionWithExcelFile(String nameFile) {
		try {
			inputExcelFile = new FileInputStream(new File("resources/chunks/" + nameFile + ".xlsx"));
			currentExcelBook = new XSSFWorkbook (inputExcelFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Ошибка. Excel " + nameFile + " file не найден или путь указан неверно.");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Ошибка считывания файла: " + nameFile);
		} finally {
			try {
				inputExcelFile.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Поток чтения из excel файла не закрылся!");
				inputExcelFile = null; 
				System.out.println("Поток чтения из excel файла прибит.");
			}
		}	
	}
	
	private static Tile[][] loadMapInArray(Tile[][] arrayTiles) {
		currentTable = currentExcelBook.getSheetAt(0);
		for(int i = 0; i < Constants.HEIGHT_CHUNK; i++) {
			currentRow = currentTable.getRow(i);
			for(int j = 0; j < Constants.WIDTH_CHUNK; j++) {
				currentCell = currentRow.getCell(j);
				String currentCellValue = currentCell.getStringCellValue();
				arrayTiles[i][j] = new Tile(TileType.valueOf(currentCellValue), new Coordinates(i, j, true));
			}
		}
		return arrayTiles;
	}
}
