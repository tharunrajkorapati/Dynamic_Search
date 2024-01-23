package in.tharun.service.imp;

import java.time.LocalDate;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.tharun.entity.CitizenPlan;
import in.tharun.repo.CitizenRepo;
import in.tharun.service.CitizenDynamic;
import in.tharun.service.CitizenService;
import in.tharun.utility.ExcelGenerator;
import in.tharun.utility.PdfGenerator;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class CitizenServiceImp implements CitizenService
{
	@Autowired
	private CitizenRepo repo;
	@Autowired
    private ExcelGenerator excelgenerator;
	@Autowired
	private PdfGenerator pdfgenerator;
	
	@Override
	public List<String> getPlanName() {
		
		return repo.getPlanNames();
	}

	@Override
	public List<String> getPlanStatus() {
		
		return repo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> getDynamic(CitizenDynamic search)
	{
		CitizenPlan p=new CitizenPlan();
		if(null!=search.getPlanName() && !"".equals(search.getPlanName()))
		{
			p.setPLAN_NAME(search.getPlanName());
		}
		if(null!=search.getPlanStatus() && !"".equals(search.getPlanStatus()))
		{
			p.setPLAN_STATUS(search.getPlanStatus());
		}
		if(null!=search.getGender() && !"".equals(search.getGender()))
		{
			p.setGENDER(search.getGender());
		}
		if(null!=search.getStartDate() && !"".equals(search.getStartDate()))
		{
			String startDate = search.getStartDate();
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//			LocalDate date = LocalDate.parse(startDate, formatter);
//			p.setPLAN_START_DATE(date);
			
			LocalDate today = LocalDate.parse(startDate);
			p.setPLAN_START_DATE(today);
		}
		if(null!=search.getEndDate() && !"".equals(search.getEndDate()))
		{
			String endDate = search.getEndDate();
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//			LocalDate date = LocalDate.parse(endDate, formatter);
//			p.setPLAN_END_DATE(date);
			
			LocalDate today = LocalDate.parse(endDate);
			p.setPLAN_END_DATE(today);
		}
		
		return repo.findAll(Example.of(p));
		
		//return repo.findAll();
	}

	@Override
	public boolean exportExcel(HttpServletResponse response)throws Exception {
		   List<CitizenPlan> list = repo.findAll();
		   excelgenerator.generateExcel(response, list);
		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
	    List<CitizenPlan> all = repo.findAll();
	    pdfgenerator.pdfGenerator(response, all);
		return true;
	}
	

}
