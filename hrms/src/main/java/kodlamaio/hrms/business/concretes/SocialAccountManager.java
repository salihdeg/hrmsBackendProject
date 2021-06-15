package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SocialAccountService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SocialAccountDao;
import kodlamaio.hrms.entities.concretes.SocialAccount;

@Service
public class SocialAccountManager implements SocialAccountService {

	private SocialAccountDao socialAccountDao;

	@Autowired
	public SocialAccountManager(SocialAccountDao socialAccountDao) {
		super();
		this.socialAccountDao = socialAccountDao;
	}

	@Override
	public Result add(SocialAccount socialAccount) {
		this.socialAccountDao.save(socialAccount);
		return new SuccessResult("Social Account added");
	}

	@Override
	public DataResult<List<SocialAccount>> getAll() {
		var result = this.socialAccountDao.findAll();
		return new SuccessDataResult<List<SocialAccount>>(result, "All Social Accounts Listed");
	}

}
