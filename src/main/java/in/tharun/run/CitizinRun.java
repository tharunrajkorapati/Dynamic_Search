package in.tharun.run;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.tharun.entity.CitizenPlan;
import in.tharun.repo.CitizenRepo;

@Component
public class CitizinRun implements ApplicationRunner
{
	@Autowired
	private CitizenRepo repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		repo.deleteAll();
		
		
		//cash plane
		CitizenPlan c1=new CitizenPlan();
		c1.setCITIZEN_NAME("hari");
		c1.setGENDER("male");
		c1.setPLAN_NAME("cash");
		c1.setPLAN_STATUS("approved");
		c1.setPLAN_START_DATE(LocalDate.now());
		c1.setPLAN_END_DATE(LocalDate.now().plusMonths(6));
		c1.setBENEFIT_AMOUNT(5000.00);
		
		CitizenPlan c2=new CitizenPlan();
		c2.setCITIZEN_NAME("saleem");
		c2.setGENDER("male");
		c2.setPLAN_NAME("cash");
		c2.setPLAN_STATUS("denied");
		c2.setDENIAL_REASON("rental income");
		
		CitizenPlan c3=new CitizenPlan();
		c3.setCITIZEN_NAME("poojitha");
		c3.setGENDER("female");
		c3.setPLAN_NAME("cash");
		c3.setPLAN_STATUS("terminated");
		c3.setPLAN_START_DATE(LocalDate.now().minusMonths(4));
		c3.setPLAN_END_DATE(LocalDate.now().plusMonths(6));
		c3.setBENEFIT_AMOUNT(5000.00);
		c3.setTERMINATED_DATE(LocalDate.now());
		c3.setTERMINATION_REASON("employeed");
		
		
		
		
		//food plane
				CitizenPlan c4=new CitizenPlan();
				c4.setCITIZEN_NAME("joel");
				c4.setGENDER("male");
				c4.setPLAN_NAME("food");
				c4.setPLAN_STATUS("approved");
				c4.setPLAN_START_DATE(LocalDate.now());
				c4.setPLAN_END_DATE(LocalDate.now().plusMonths(6));
				c4.setBENEFIT_AMOUNT(5000.00);
				
				CitizenPlan c5=new CitizenPlan();
				c5.setCITIZEN_NAME("avadhani");
				c5.setGENDER("male");
				c5.setPLAN_NAME("food");
				c5.setPLAN_STATUS("denied");
				c5.setDENIAL_REASON("property income");
				
				CitizenPlan c6=new CitizenPlan();
				c6.setCITIZEN_NAME("jahnavi");
				c6.setGENDER("female");
				c6.setPLAN_NAME("food");
				c6.setPLAN_STATUS("terminated");
				c6.setPLAN_START_DATE(LocalDate.now().minusMonths(4));
				c6.setPLAN_END_DATE(LocalDate.now().plusMonths(6));
				c6.setBENEFIT_AMOUNT(5000.00);
				c6.setTERMINATED_DATE(LocalDate.now());
				c6.setTERMINATION_REASON("employeed");
				
				
				
				

				//medical plane
						CitizenPlan c7=new CitizenPlan();
						c7.setCITIZEN_NAME("tarak");
						c7.setGENDER("male");
						c7.setPLAN_NAME("medical");
						c7.setPLAN_STATUS("approved");
						c7.setPLAN_START_DATE(LocalDate.now());
						c7.setPLAN_END_DATE(LocalDate.now().plusMonths(6));
						c7.setBENEFIT_AMOUNT(5000.00);
						
						CitizenPlan c8=new CitizenPlan();
						c8.setCITIZEN_NAME("sandeep");
						c8.setGENDER("male");
						c8.setPLAN_NAME("medical");
						c8.setPLAN_STATUS("denied");
						c8.setDENIAL_REASON("property income");
						
						CitizenPlan c9=new CitizenPlan();
						c9.setCITIZEN_NAME("yashu");
						c9.setGENDER("female");
						c9.setPLAN_NAME("medical");
						c9.setPLAN_STATUS("terminated");
						c9.setPLAN_START_DATE(LocalDate.now().minusMonths(4));
						c9.setPLAN_END_DATE(LocalDate.now().plusMonths(6));
						c9.setBENEFIT_AMOUNT(5000.00);
						c9.setTERMINATED_DATE(LocalDate.now());
						c9.setTERMINATION_REASON("govt job");
						
						
						
						
						
			//employement plane
						CitizenPlan c10=new CitizenPlan();
						c10.setCITIZEN_NAME("neeraj");
						c10.setGENDER("male");
						c10.setPLAN_NAME("employement");
						c10.setPLAN_STATUS("approved");
						c10.setPLAN_START_DATE(LocalDate.now());
						c10.setPLAN_END_DATE(LocalDate.now().plusMonths(6));
						c10.setBENEFIT_AMOUNT(5000.00);
						
						CitizenPlan c11=new CitizenPlan();
						c11.setCITIZEN_NAME("gopi");
						c11.setGENDER("male");
						c11.setPLAN_NAME("employement");
						c11.setPLAN_STATUS("denied");
						c11.setDENIAL_REASON("property income");
						
						CitizenPlan c12=new CitizenPlan();
						c12.setCITIZEN_NAME("subani");
						c12.setGENDER("female");
						c12.setPLAN_NAME("employement");
						c12.setPLAN_STATUS("terminated");
						c12.setPLAN_START_DATE(LocalDate.now().minusMonths(4));
						c12.setPLAN_END_DATE(LocalDate.now().plusMonths(6));
						c12.setBENEFIT_AMOUNT(5000.00);
						c12.setTERMINATED_DATE(LocalDate.now());
						c12.setTERMINATION_REASON("govt job");		
						
						
				
						
				List<CitizenPlan> list = Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12);	
				repo.saveAll(list);
	}

}
