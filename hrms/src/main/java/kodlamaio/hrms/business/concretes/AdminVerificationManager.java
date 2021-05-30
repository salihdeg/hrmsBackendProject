package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AdminVerificationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.AdminVerificationDao;
import kodlamaio.hrms.entities.concretes.AdminVerification;

@Service
public class AdminVerificationManager implements AdminVerificationService{

	@Autowired
	private AdminVerificationDao adminVerificationDao;
	
	
	@Override
	public DataResult<List<AdminVerification>> getAll() {
		var result = this.adminVerificationDao.findAll();
		return new SuccessDataResult<List<AdminVerification>>(result,"Admin Verifications Listed");
	}

	@Override
	public Result add(AdminVerification adminVerification) {
		this.adminVerificationDao.save(adminVerification);
		return new SuccessResult("Verified");
	}

}
