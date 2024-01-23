package in.tharun.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "CITIZEN_PLANS_INFO")
public class CitizenPlan {
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer CITIZEN_ID;
	   private String CITIZEN_NAME;
	   private String GENDER;
	   private String PLAN_NAME;
	   private String PLAN_STATUS;
	   private LocalDate PLAN_START_DATE;
	   private LocalDate PLAN_END_DATE;
	   private Double BENEFIT_AMOUNT;
	   private String DENIAL_REASON;
	   private LocalDate TERMINATED_DATE;
	   private String TERMINATION_REASON;
	   
	   
	   
}
