package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmailVerificationService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerEmailVerificationDao;
import kodlamaio.hrms.dataAccess.abstracts.WorkerEmailVerificationDao;
import kodlamaio.hrms.entities.concretes.EmployerEmailVerification;
import kodlamaio.hrms.entities.concretes.WorkerEmailVerification;

@Service
public class EmailVerificationManager implements EmailVerificationService {
	
	@Autowired
	private EmployerEmailVerificationDao employerEmailVerificationDao;
	
	@Autowired
	private WorkerEmailVerificationDao workerEmailVerificationDao;

	@Override
	public Result add(EmployerEmailVerification employerEmailVerification) {
		this.employerEmailVerificationDao.save(employerEmailVerification);
		return new SuccessResult("Email Verified");
	}

	@Override
	public Result add(WorkerEmailVerification workerEmailVerification) {
		this.workerEmailVerificationDao.save(workerEmailVerification);
		return new SuccessResult("Email Verified");
	}

}
