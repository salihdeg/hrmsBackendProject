package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.DeparmentService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.DepartmentDao;
import kodlamaio.hrms.entities.concretes.Department;

@Service
public class DeparmentManager implements DeparmentService{

	private DepartmentDao departmentDao;
	
	
	public DeparmentManager(DepartmentDao departmentDao) {
		super();
		this.departmentDao = departmentDao;
	}

	@Override
	public Result add(Department department) {
		this.departmentDao.save(department);
		return new SuccessResult("Deparment Saved");
	}

	@Override
	public DataResult<List<Department>> getAll() {
		var result = this.departmentDao.findAll();
		return new SuccessDataResult<List<Department>>(result, "All Departments Listed");
	}

	@Override
	public Result delete(Department department) {
		var departmentToDelete = this.departmentDao.findById(department.getId());
		if (departmentToDelete == null) {
			new ErrorResult("Department not found");
		}
		return new SuccessResult("Department Deleted");
	}

}
