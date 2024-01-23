package in.tharun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.tharun.entity.CitizenPlan;
import in.tharun.service.CitizenDynamic;
import in.tharun.service.CitizenService;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class CitizenController 
{
	@Autowired
	private CitizenService service;
	
	@GetMapping("/excel")
	public void excel(HttpServletResponse response)throws Exception
	{
		response.setContentType("application/octet-stream");
		response.setHeader("Content-disposition","attachment;filename=plans.xls");
		service.exportExcel(response);
	}
	@GetMapping("/pdf")
	public void pdf(HttpServletResponse response)throws Exception
	{
		response.setContentType("application/pdf");
		response.setHeader("Content-disposition","attachment;filename=plans.pdf");
		service.exportPdf(response);
	}
	
	@PostMapping("/search")
	public String dynamicSearch(@ModelAttribute("search") CitizenDynamic search,Model model)
	{
		System.out.println(search);
		List<CitizenPlan> list = service.getDynamic(search);
		model.addAttribute("plns",list);
		init(model);
		return "abc";
	}
	
	@GetMapping("/")
	public String get(Model model)
	{
		model.addAttribute("search",new CitizenDynamic());	
		init(model);
		return "abc";
	}
	private void init(Model model) {
		
		//model.addAttribute("search",new CitizenDynamic());
		model.addAttribute("plans",service.getPlanName());
		model.addAttribute("status",service.getPlanStatus());
	}
	
}
