package in.tharun.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.tharun.entity.CitizenPlan;

public interface CitizenRepo extends JpaRepository<CitizenPlan,Integer>
{
	@Query("select distinct(PLAN_NAME) from CitizenPlan")
	public List<String> getPlanNames();
	
	@Query("select distinct(PLAN_STATUS) from CitizenPlan")
	public List<String> getPlanStatus();
}
