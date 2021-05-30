package kodlamaio.hrms.business.concretes;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkerService;
import kodlamaio.hrms.core.adapters.abstracts.UserCheckService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkerDao;
import kodlamaio.hrms.entities.concretes.Worker;

@Service
public class WorkerManager implements WorkerService{
	
	@Autowired
	private WorkerDao workerDao;
	
	@Autowired
	@Qualifier("MernisFake")
	private UserCheckService userCheckService;
	

	@Override
	public DataResult<List<Worker>> getAll() {
		var result = this.workerDao.findAll();
		return new SuccessDataResult<List<Worker>>(result, "Listed");
	}

	@Override
	public Result add(Worker worker) {
		
		var errors = BusinessRules.Run(IsEmailExist(worker),IsNationalityIdExist(worker),this.userCheckService.checkWorker(worker));
		if (errors != null) {
			return errors;
		}
		
		this.workerDao.save(worker);
		return new SuccessResult("Worker Added");
	}
	
	@Override
	public Result delete(Worker worker) {
		this.workerDao.delete(worker);
		return new SuccessResult("Worker Deleted");
	}
	
	private Result IsEmailExist(Worker worker) {
		var email = this.workerDao.findByEmail(worker.getEmail());
		if (email != null) {
			return new ErrorResult("Email Exist!");
		}
		return new SuccessResult();
	}
	
	private Result IsNationalityIdExist(Worker worker) {
		var email = this.workerDao.findByNationalityId(worker.getNationalityId());
		if (email != null) {
			return new ErrorResult("Nationality Id Exist!");
		}
		return new SuccessResult();
	}

	
	
	
	
	
	


}
