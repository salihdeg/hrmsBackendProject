package kodlamaio.hrms.core.adapters.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Worker;

public interface UserCheckService {
	
	Result checkWorker(Worker worker);
	
}
