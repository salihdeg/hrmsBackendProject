package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Department;

public interface DeparmentService {
	Result add(Department department);
	DataResult<List<Department>> getAll();
	Result delete(Department department);
}
