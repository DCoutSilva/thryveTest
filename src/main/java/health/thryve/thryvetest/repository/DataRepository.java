package health.thryve.thryvetest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import health.thryve.thryvetest.entity.Data;

public interface DataRepository extends JpaRepository<Data, Long> {

	@Query("SELECT d FROM Data d WHERE userId = ?1")
	public List<Data> findByUserId(Long userId);
	
	@Query(value = "SELECT AVG(value)  FROM Data group by userId")
	public List<Double> averageHeartRates();
	
	@Query(value = "SELECT AVG(value) FROM Data where userId = ?1 group by userId")
	public Double averageHeartRateByUser(Long userId);
}
