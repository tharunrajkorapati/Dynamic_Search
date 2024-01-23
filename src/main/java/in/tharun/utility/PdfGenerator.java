package in.tharun.utility;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.tharun.entity.CitizenPlan;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class PdfGenerator 
{
      public void pdfGenerator(HttpServletResponse response,List<CitizenPlan> all) throws Exception
      {
    	  
  	    
  	    
  		Document d=new Document(PageSize.A4);
  	     PdfWriter.getInstance(d,response.getOutputStream());
  	     d.open();
  	     
  	     // Creating font
  	     // Setting font style and size
  	     Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
  	     fontTiltle.setSize(20);
  	     // Creating paragraph
  	     Paragraph paragraph1 = new Paragraph("Citizen Plan Detais", fontTiltle);
  	     // Aligning the paragraph in the document
  	     paragraph1.setAlignment(Paragraph.ALIGN_CENTER);
  	     // Adding the created paragraph in the document
  	     d.add(paragraph1);
  	     
  	     
  	     
  	     PdfPTable table =new PdfPTable(8);
  	     
  	     // Setting width of the table, its columns and spacing
  	     table.setWidthPercentage(100f);
  	     table.setWidths(new int[] {3,3,3,3,3,3,3,3});
  	     table.setSpacingBefore(5);
  	     
  	     PdfPCell cell=new PdfPCell();
  	     
  	  // Setting the background color and padding of the table cell
  	     cell.setBackgroundColor(CMYKColor.BLUE);
  	     cell.setPadding(5);
  	     
  	     table.addCell("id");
  	     table.addCell("name");
  	     table.addCell("gender");
  	     table.addCell("plan name");
  	     table.addCell("plan status");
  	     table.addCell("benifit amount");
  	     table.addCell("start date");
  	     table.addCell("end date");
  	     
  	     for(CitizenPlan plan:all)
  	     {
  	    	 table.addCell(String.valueOf(plan.getCITIZEN_ID()));
  	    	 table.addCell(plan.getCITIZEN_NAME());
  	    	 table.addCell(plan.getGENDER());
  	    	 table.addCell(plan.getPLAN_NAME());
  	    	 table.addCell(plan.getPLAN_STATUS());
  	    	 table.addCell(plan.getBENEFIT_AMOUNT()+"");
  	    	 table.addCell(plan.getPLAN_START_DATE()+"");
  	    	 table.addCell(plan.getPLAN_END_DATE()+"");
  	     }
  	     d.add(table);
  	     d.close();
      }
}
