package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.FacultyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.FacultyDao;
import kodlamaio.hrms.entities.concretes.Faculty;

@Service
public class FaulctyManager implements FacultyService {

	private FacultyDao facultyDao;

	@Autowired
	public FaulctyManager(FacultyDao facultyDao) {
		super();
		this.facultyDao = facultyDao;
	}

	@Override
	public Result add(Faculty faculty) {
		this.facultyDao.save(faculty);
		return new SuccessResult("Faculty Added");
	}

	@Override
	public DataResult<List<Faculty>> getAll() {
		var result = this.facultyDao.findAll();
		return new SuccessDataResult<List<Faculty>>(result, "All Faculties Listed");
	}

	@Override
	public Result delete(Faculty faculty) {
		var faultyToDelete = this.facultyDao.findById(faculty.getId());
		if (faultyToDelete == null) {
			return new ErrorResult("Faculty Not Found");
		}
		return new SuccessResult("Faculty Deleted");
	}

}
