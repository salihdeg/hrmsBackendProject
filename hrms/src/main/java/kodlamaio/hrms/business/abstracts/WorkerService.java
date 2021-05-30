package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Worker;

public interface WorkerService {
	DataResult<List<Worker>> getAll();
	Result add(Worker worker);
	Result delete(Worker worker);
}
