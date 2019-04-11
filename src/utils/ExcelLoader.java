package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import map.TileType;

public abstract class ExcelLoader {
	private static XSSFWorkbook currentExcelBook = null;
	private static FileInputStream inputExcelFile = null;
	private static XSSFSheet currentTable = null;
	private static XSSFRow currentRow = null;
	private static XSSFCell currentCell = null;
	
	/*public static void loadChunkInArray(String nameFile, Tile[][] arrayTiles) {
		getConnectionWithExcelFile(nameFile);
		loadMapInArray(arrayTiles);
	}
	
	private static void getConnectionWithExcelFile(String nameFile) {
		try {
			inputExcelFile = new FileInputStream(new File(nameFile));
			currentExcelBook = new XSSFWorkbook (inputExcelFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Ошибка. Excel " + nameFile + " file не найден.");
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
				int currentCellValue = Integer.parseInt(currentCell.getRawValue());
				arrayTiles[i][j] = new Tile(TileType.ground, i, j);
			}
		}
		return arrayTiles;
	}
	/*	
	 * currentTable = currentExcelBook.getSheetAt(0);
		for(int i = 0; i < Constants.HEIGHT_CHUNK; i++) {
			currentRow = currentTable.getRow(i);
			for(int j = 0; j < Constants.WIDTH_CHUNK; j++) {
				currentCell = currentRow.getCell(j);
				switch(Integer.parseInt(cell.getRawValue())) {
					case 0: {
						array[i][j] = new Tile(TileType.ground, i, j);
						break;
					}
					
					case 1: {
						array[i][j] = new Tile(TileType.water, i, j);
						break;
					}
					
					case 2: {
						array[i][j] = new Tile(TileType.road, i, j);
						break;
					}
					
					case 3: {
						array[i][j] = new Tile(TileType.door, i, j);
						break;
					}
				}
				
			}
		}
		
	}*/
}
