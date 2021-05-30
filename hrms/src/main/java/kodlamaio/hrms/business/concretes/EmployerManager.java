package kodlamaio.hrms.business.concretes;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		var result = this.employerDao.findAll();
		return new SuccessDataResult<List<Employer>>(result, "All Data Listed");
	}

	@Override
	public Result add(Employer employer) {
		
		var errors = BusinessRules.Run(isEmailExist(employer), checkEmail(employer));
		if (errors!=null) {
			return errors;
		}
		
		this.employerDao.save(employer);
		return new SuccessResult("Employer Added");
	}
	
	
	private Result isEmailExist(Employer employer) {
		
		var email = this.employerDao.findByEmail(employer.getEmail());
		if (email != null) {
			return new ErrorResult("Email Exist!");
		}
		return new SuccessResult();
		
	}
	
	private Result checkEmail(Employer employer) {
		String domain = "";
		String webSite = employer.getWebSite();
		for(int i = 1; i < webSite.split("\\.").length; i++) {
			domain+= webSite.split("\\.")[i];
			if (i!= webSite.split("\\.").length -1 ) {
				domain+=".";
			}
		}
		String regex = "^(.+)@"+ domain + "$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(employer.getEmail());
		if (!matcher.matches()) {
			return new ErrorResult("This email is not mathes with domain");
		}
		
		return new SuccessResult();
	}
}
