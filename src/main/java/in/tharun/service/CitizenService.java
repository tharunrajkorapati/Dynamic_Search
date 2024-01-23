package in.tharun.service;

import java.util.List;

import in.tharun.entity.CitizenPlan;
import jakarta.servlet.http.HttpServletResponse;

public interface CitizenService 
{
		public List<String> getPlanName();
		public List<String> getPlanStatus();
		public List<CitizenPlan> getDynamic(CitizenDynamic search);
		public boolean exportExcel(HttpServletResponse response) throws Exception;
		public boolean exportPdf(HttpServletResponse response) throws Exception;
		
}
