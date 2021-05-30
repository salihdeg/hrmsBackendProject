package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SystemEmployeeService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SystemEmployeeDao;
import kodlamaio.hrms.entities.concretes.SystemEmployee;

@Service
public class SystemEmployeeManager implements SystemEmployeeService {

	private SystemEmployeeDao systemEmployeeDao;

	@Autowired
	public SystemEmployeeManager(SystemEmployeeDao systemEmployeeDao) {
		this.systemEmployeeDao = systemEmployeeDao;
	}

	@Override
	public DataResult<List<SystemEmployee>> getAll() {
		var result = this.systemEmployeeDao.findAll();
		return new SuccessDataResult<List<SystemEmployee>>(result, "All Data Listed");
	}

	@Override
	public Result add(SystemEmployee systemEmployee) {
		var errors = BusinessRules.Run(IsEmailExist(systemEmployee));
		if(errors != null) {
			return errors;
		}
		
		this.systemEmployeeDao.save(systemEmployee);

		return new SuccessResult("Sistem Çalışanı Eklendi");

	}

	private Result IsEmailExist(SystemEmployee systemEmployee) {
		var email = this.systemEmployeeDao.findByEmail(systemEmployee.getEmail());
		if (email != null) {
			return new ErrorResult("Email Mevcut");
		}
		return new SuccessResult();
	}

}
