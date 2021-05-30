package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.Worker;

public interface AuthService {
	
	Result employerRegister(Employer employer);
	
	Result employerVerification(Employer employer);
	
	Result workerRegister(Worker worker);
	
}
