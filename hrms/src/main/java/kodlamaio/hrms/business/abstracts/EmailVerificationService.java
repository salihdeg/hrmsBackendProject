package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmployerEmailVerification;
import kodlamaio.hrms.entities.concretes.WorkerEmailVerification;

public interface EmailVerificationService {
	Result add(EmployerEmailVerification employerEmailVerification);
	Result add(WorkerEmailVerification workerEmailVerification);
}
