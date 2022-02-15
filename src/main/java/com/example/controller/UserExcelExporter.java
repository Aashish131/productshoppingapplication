package com.example.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.example.model.User;

public class UserExcelExporter extends AbstractUserExporter {
    

	 

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    
    public UserExcelExporter () {
        workbook=new XSSFWorkbook();
    }
    
    private void writeHeaderLine() {
        sheet =workbook.createSheet("Users");
        XSSFRow row=sheet.createRow(0);
        
        
        XSSFCellStyle cellStyle=workbook.createCellStyle();
        XSSFFont font=workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        cellStyle.setFont(font);
        
        createCell(row, 0, "User Id", cellStyle);
        createCell(row, 1, "Email", cellStyle);
        createCell(row, 2, "First Name", cellStyle);
        createCell(row, 3, "Second Name", cellStyle);
        createCell(row, 4, "Roles", cellStyle);
        createCell(row, 5, "Enabled", cellStyle);
    }
    
    private void createCell(XSSFRow row,int columnIndex, Object value, CellStyle style) {

 

        XSSFCell cell= row.createCell(columnIndex);
        sheet.autoSizeColumn(columnIndex);
        
        if(value instanceof Integer) {
            cell.setCellValue((Integer) value);
        }else if(value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
        
    }

 

    public void export(List<User> listUsers, HttpServletResponse response) throws IOException{
        super.setResponseHeader(response, "application/octet-stream", ".xlsx");
        
        writeHeaderLine();
        writeDataLines(listUsers);
        
        ServletOutputStream outputStream=response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
    private void writeDataLines(List<User> listUsers) {
        int rowIndex=1;
        
        XSSFCellStyle cellStyle=workbook.createCellStyle();
        XSSFFont font=workbook.createFont();
        font.setFontHeight(14);
        cellStyle.setFont(font);
        
        for(User user : listUsers) {
            XSSFRow row= sheet.createRow(rowIndex++);
            int columnIndex=0;
            
            createCell(row, columnIndex++,user.getUser_Id(),cellStyle);
            createCell(row, columnIndex++,user.getEmail(),cellStyle);
            createCell(row, columnIndex++,user.getFirstName(),cellStyle);
            createCell(row, columnIndex++,user.getLastName(),cellStyle);
            createCell(row, columnIndex++,user.getRoles().toString(),cellStyle);
            
        }
    }
}
 