package in.tharun.utility;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.tharun.entity.CitizenPlan;
import in.tharun.repo.CitizenRepo;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ExcelGenerator
{
	
	public void generateExcel(HttpServletResponse response,List<CitizenPlan> plans)throws Exception
	{
		Workbook wb=new HSSFWorkbook();
		   Sheet sheet = wb.createSheet("plans-data");
		   Row row = sheet.createRow(0);
		   row.createCell(0).setCellValue("id");
		   row.createCell(1).setCellValue("name");
		   row.createCell(2).setCellValue("gender");
		   row.createCell(3).setCellValue("plan name");
		   row.createCell(4).setCellValue("plan status");
		   row.createCell(5).setCellValue("start date");
		   row.createCell(6).setCellValue("end date");
		   row.createCell(7).setCellValue("benifit amount");
		   
		   
		  
		   int rows=1;
		   for(CitizenPlan plan:plans)
		   {
			   Row createRow = sheet.createRow(rows);
			   createRow.createCell(0).setCellValue(plan.getCITIZEN_ID());
			   createRow.createCell(1).setCellValue(plan.getCITIZEN_NAME());
			   createRow.createCell(2).setCellValue(plan.getGENDER());
			   createRow.createCell(3).setCellValue(plan.getPLAN_NAME());
			   createRow.createCell(4).setCellValue(plan.getPLAN_STATUS());
			   createRow.createCell(5).setCellValue(plan.getPLAN_START_DATE()+"");
			   createRow.createCell(6).setCellValue(plan.getPLAN_END_DATE()+"");
			   if(plan.getBENEFIT_AMOUNT()!=null)
			   {
			   createRow.createCell(7).setCellValue(plan.getBENEFIT_AMOUNT());
			   }
			   else
			   {
				   createRow.createCell(7).setCellValue("N/A");
			   }
			   rows++;
		   }
		   
		   ServletOutputStream output=response.getOutputStream();
		   wb.write(output);
	}
}
