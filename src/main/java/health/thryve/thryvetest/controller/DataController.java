package health.thryve.thryvetest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import health.thryve.thryvetest.entity.Data;
import health.thryve.thryvetest.entity.Datasource;
import health.thryve.thryvetest.entity.Feed;
import health.thryve.thryvetest.repository.DataRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class DataController {

	@Autowired
	private DataRepository dataRepository;
	
	@PostMapping("/feedJson")
	public ResponseEntity<List<Data>> recordDataFeed (@RequestBody List<Feed> feed){
		try {
			List<Data> recordedData = new ArrayList<Data>();
			for(Feed f: feed) {
				for(Datasource ds:f.getDataSources()) {
					for(Data d: ds.getData()) {
						Data toPersist = new Data(d.getStartTimestampUnix(),
								d.getEndTimestampUnix(),d.getCreatedAtUnix(),
								d.getDynamicValueType(),d.getValue(),
								d.getValueType(),ds.getDataSource(), f.getAuthenticationToken());
						dataRepository.save(toPersist);
						recordedData.add(toPersist);
					}
				}
			}
			return new ResponseEntity<>(recordedData,HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/averageHeartRate")
	public ResponseEntity<List<Double>> averageHeartRates(@RequestParam(required = false) Long userId){
		List<Double> heartRates = new ArrayList<Double>();
		try {
			if(userId == null) return new ResponseEntity<>(dataRepository.averageHeartRates(), HttpStatus.OK);
			else heartRates.add(dataRepository.averageHeartRateByUser(userId));
					
			return new ResponseEntity<>(heartRates,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/DEV")
	public ResponseEntity<List<Data>> recordedDataFeed(@RequestParam (required=false)Long userId){
		if (userId == null) return new ResponseEntity<>(dataRepository.findAll(),HttpStatus.OK);
		else return new ResponseEntity<>(dataRepository.findByUserId(userId),HttpStatus.OK);
	}
	
	/*private void checkAuthentication(String authenticationToken) throws Exception {
		if (authenticationToken== null || !authenticationToken.equals("123456"))
			throw new Exception("Authentication failed");
	}*/
	
}
