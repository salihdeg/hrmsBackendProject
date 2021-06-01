package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	
	DataResult<List<JobAdvertisement>> getAll();
	
	Result add(JobAdvertisement jobAdvertisement);
	
	Result update(JobAdvertisement jobAdvertisement);
	
	DataResult<List<JobAdvertisement>> findByIsActiveTrue();
	
	DataResult<List<JobAdvertisement>> findByIsActiveTrueOrderByCreationDate();
	
	DataResult<List<JobAdvertisement>> findByEmployer_IdAndIsActiveTrue(int id);
}
