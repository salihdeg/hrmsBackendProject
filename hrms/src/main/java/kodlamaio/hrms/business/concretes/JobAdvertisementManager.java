package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		var result = this.jobAdvertisementDao.findAll();
		return new SuccessDataResult<List<JobAdvertisement>>(result, "All Advertisement");
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		
		if (checkSalaryExist(jobAdvertisement).isSuccess()) {
			jobAdvertisement.getSalary().setJobAdvertisement(jobAdvertisement);
		}
		
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Job Advertisement Added");
	}
	
	@Override
	public Result update(JobAdvertisement jobAdvertisement) {
		var errors = BusinessRules.Run(checkAdvertisementExist(jobAdvertisement));
		if (errors != null) {
			return errors;
		}
		var uptadeAdver = this.jobAdvertisementDao.findById(jobAdvertisement.getId()).get();
		
		uptadeAdver.setEmployer(jobAdvertisement.getEmployer());
		uptadeAdver.setCity(jobAdvertisement.getCity());
		uptadeAdver.setDescription(jobAdvertisement.getDescription());
		uptadeAdver.setDeadlineDate(jobAdvertisement.getDeadlineDate());
		uptadeAdver.setActive(jobAdvertisement.isActive());
		uptadeAdver.setCreationDate(jobAdvertisement.getCreationDate());
		uptadeAdver.setPosition(jobAdvertisement.getPosition());
		uptadeAdver.setQuota(jobAdvertisement.getQuota());
		
		if (checkSalaryExist(jobAdvertisement).isSuccess()) {
			uptadeAdver.setSalary(jobAdvertisement.getSalary());
			uptadeAdver.getSalary().setJobAdvertisement(uptadeAdver);
		}
		
		this.jobAdvertisementDao.save(uptadeAdver);
		return new SuccessResult("Job Advertisement Uptaded");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveTrueOrderByCreationDate() {
		var result = this.jobAdvertisementDao.findByIsActiveTrueOrderByCreationDate();
		return new SuccessDataResult<List<JobAdvertisement>>(result, "Active Advertisement Listed By Creation Date");
	}


	@Override
	public DataResult<List<JobAdvertisement>> findByEmployer_IdAndIsActiveTrue(int id) {
		var result = this.jobAdvertisementDao.findByEmployer_IdAndIsActiveTrue(id);
		return new SuccessDataResult<List<JobAdvertisement>>(result, "All active advertisements Listed by Emloyer");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveTrue() {
		var result = this.jobAdvertisementDao.findByIsActiveTrue();
		return new SuccessDataResult<List<JobAdvertisement>>(result, "All active advertisements listed");
	}
	
	private Result checkAdvertisementExist(JobAdvertisement jobAdvertisement) {
		var result = this.jobAdvertisementDao.findById(jobAdvertisement.getId()).get();
		if (result == null) {
			return new ErrorResult("Job Advertisement Not Exist");
		}
		return new SuccessResult();
	}
	
	private Result checkSalaryExist(JobAdvertisement jobAdvertisement) {
		if (jobAdvertisement.getSalary() != null) {
			return new SuccessResult();
		}
		return new ErrorResult();
	}
	

}
