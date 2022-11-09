package health.thryve.thryvetest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import health.thryve.thryvetest.entity.Data;
import health.thryve.thryvetest.repository.DataRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class JPAUnitTest {

//	@Autowired
//	private TestEntityManager entityManager;
//	
	@Autowired
	private DataRepository dataRepository;
	
	@Test
    public void should_find_no_data_if_repository_is_empty() {
      List<Data> data = dataRepository.findAll();

      assertThat(data).isEmpty();
    }
	
	@Test
	public void should_store_a_data() {
		Data data = dataRepository.save(new Data(1605595355000L,1605595394000L,1605597330067L,
				3000L,78L,"LONG",8L, 1234L));
		
		assertThat(data).hasFieldOrPropertyWithValue("startTimestampUnix",1605595355000L);
		assertThat(data).hasFieldOrPropertyWithValue("endTimestampUnix",1605595394000L);
		assertThat(data).hasFieldOrPropertyWithValue("createdAtUnix",1605597330067L);
		assertThat(data).hasFieldOrPropertyWithValue("dynamicValueType",3000L);
		assertThat(data).hasFieldOrPropertyWithValue("value",78L);
		assertThat(data).hasFieldOrPropertyWithValue("valueType","LONG");
		assertThat(data).hasFieldOrPropertyWithValue("dataSource",8L);
		assertThat(data).hasFieldOrPropertyWithValue("userId",1234L);
	}
	
	@Test
	public void should_find_all_data() {
		Data d1 = dataRepository.save(new Data(10L,11L,12L,13L,14L,"LONG",1L,2L));
		Data d2 = dataRepository.save(new Data(20L,21L,22L,23L,24L,"LONG",1L,2L));
		Data d3 = dataRepository.save(new Data(30L,31L,32L,33L,34L,"LONG",1L,2L));
		
		List<Data> datas = dataRepository.findAll();
		
		assertThat(datas).hasSize(3).contains(d1,d2,d3);

	}
	
	@Test
	public void should_find_by_userId() {
		Data d1 = dataRepository.save(new Data(10L,11L,12L,13L,14L,"LONG",1L,1L));
		Data d2 = dataRepository.save(new Data(20L,21L,22L,23L,24L,"LONG",1L,2L));
		Data d3 = dataRepository.save(new Data(30L,31L,32L,33L,34L,"LONG",1L,3L));
		
		List<Data> datas = dataRepository.findByUserId(2L);
		
		assertThat(datas).hasSize(1).contains(d2);
		
	}
	
	@Test
	public void should_contain_avg_heart_rates() {
		Data d1 = dataRepository.save(new Data(10L,11L,12L,13L,10L,"LONG",1L,1L));
		Data d2 = dataRepository.save(new Data(20L,21L,22L,23L,24L,"LONG",1L,2L));
		Data d3 = dataRepository.save(new Data(30L,31L,32L,33L,30L,"LONG",1L,1L));
		
		List<Double> avgs = dataRepository.averageHeartRates();
		
		assertThat(avgs).hasSize(2).contains(20.0,24.0);
	}
	
	@Test
	public void should_contain_avg_single_user() {
		Data d1 = dataRepository.save(new Data(10L,11L,12L,13L,10L,"LONG",1L,1L));
		Data d2 = dataRepository.save(new Data(20L,21L,22L,23L,24L,"LONG",1L,2L));
		Data d3 = dataRepository.save(new Data(30L,31L,32L,33L,30L,"LONG",1L,1L));
		
		Double avg = dataRepository.averageHeartRateByUser(1L);
		
		assertThat(avg).isEqualTo(20.0);
	}
}


/*
"startTimestampUnix": 1605595355000,
"endTimestampUnix": 1605595394000,
"createdAtUnix": 1605597330067,
"dynamicValueType": 3000,
"value": "78",
"valueType": "LONG"
*/