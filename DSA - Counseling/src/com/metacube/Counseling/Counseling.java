package com.metacube.Counseling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class Counseling {
	
	public Queue<Student> getStudents(){
		Queue<Student> result = new LinkedList<Student>();
		
		try{
			String filePath = "C:\\Users\\yash.songara_metacub\\workspace\\Counseling\\src\\com\\metacube\\data\\students.xls";
			FileInputStream inputStream = new FileInputStream(new File(filePath));
			
			HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
			HSSFSheet sheet = workbook.getSheetAt(0);
			
			int rowNo = sheet.getLastRowNum();
			int cellNo = sheet.getRow(0).getLastCellNum();
			
			for(int row = 0; row < rowNo; row++){
				String student_name = sheet.getRow(row).getCell(0).toString();
				System.out.print(student_name + " - ");
				
				String[] programs = new String[cellNo];
				int pos = 0;
				for(int cell = 1; cell< cellNo; cell++){
					programs[pos] = sheet.getRow(row).getCell(cell).toString();
					System.out.print(programs[pos] + ",");
					pos++;
				}
				
				System.out.println();
				Student student = new Student(student_name, programs);
				result.add(student);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}
	
	public HashMap<String, Integer> getPrograms(){
		
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		
		try{
			String filePath = "C:\\Users\\yash.songara_metacub\\workspace\\Counseling\\src\\com\\metacube\\data\\programs.xls";
			FileInputStream inputStream = new FileInputStream(new File(filePath));
			
			HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
			HSSFSheet sheet = workbook.getSheetAt(0);
			
			int rowCount = sheet.getLastRowNum();
			
			for(int i = 0; i <= rowCount; i++){
				String capacityStr = (sheet.getRow(i).getCell(1)).toString();
				int capacity = (int) Float.parseFloat(capacityStr);
				result.put(sheet.getRow(i).getCell(0).toString(), capacity);
				System.out.println(sheet.getRow(i).getCell(0).toString() + " : " + capacity);
			}
			
			workbook.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}
	
	public HashMap<String, String> allocate(HashMap<String, Integer> programs,
			Queue<Student> students) {
		// TODO Auto-generated method stub
		HashMap<String, String> result = new HashMap<String, String>();
		
		for(Student s : students){
			
			String student_name = s.getStudent_name();
			String choosenBranch;
			int branchCap;
			
			for(int i = 0; i < s.getProgram_list().length; i++){
				
				choosenBranch = s.getProgram_list()[i];
				
				if(programs.containsKey(choosenBranch)){
					
					branchCap = programs.get(choosenBranch);
					
					if(branchCap != 0){
						result.put(student_name, choosenBranch);
						programs.put(choosenBranch, --branchCap);
						System.out.println(student_name + " : " + choosenBranch);
						i--;
						break;
					}
					
				}
				
			}
			
		}
		
		return result;
	}
	
	public void createNewExcelSheetForSelectedBranches(
			HashMap<String, String> allocateBranches) {
		// TODO Auto-generated method stub
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		
		int rowCount = 0;
		
		Row row = sheet.createRow(rowCount);
		
		Cell cell = row.createCell(0);
		cell.setCellValue("Student Name");
		cell = row.createCell(1);
		cell.setCellValue("Allocated Branch");
		
		for(String student_name: allocateBranches.keySet()){
			
			row = sheet.createRow(++rowCount);
			
			cell = row.createCell(0);
			cell.setCellValue(student_name);
			cell = row.createCell(1);
			cell.setCellValue(allocateBranches.get(student_name));
		}
		
		String outputFilePath = "C:\\Users\\yash.songara_metacub\\workspace\\Counseling\\src\\com\\metacube\\data\\allocatedBranches.xls";
		try {
			FileOutputStream outputStream = new FileOutputStream(new File(outputFilePath));
			workbook.write(outputStream);
			workbook.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args)	 {
		
		Counseling counseling = new Counseling();
		
		Queue<Student> students = counseling.getStudents();
		HashMap<String, Integer> programs = new HashMap<String, Integer>();
		HashMap<String, String> allocateBranches = new HashMap<String, String>();
		
		programs = counseling.getPrograms();
		
		allocateBranches = counseling.allocate(programs, students);
		
		counseling.createNewExcelSheetForSelectedBranches(allocateBranches);
		
	}

}
