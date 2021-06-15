package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Faculty;

public interface FacultyService {

	Result add(Faculty faculty);
	DataResult<List<Faculty>> getAll();
	Result delete(Faculty faculty);
}
