package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CoverLetterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CoverLetterDao;
import kodlamaio.hrms.entities.concretes.CoverLetter;

@Service
public class CoverLetterManager implements CoverLetterService{

	private CoverLetterDao coverLetterDao;
	
	@Autowired
	public CoverLetterManager(CoverLetterDao coverLetterDao) {
		super();
		this.coverLetterDao = coverLetterDao;
	}

	@Override
	public Result add(CoverLetter coverLetter) {
		this.coverLetterDao.save(coverLetter);
		return new SuccessResult("Cover Letter Added");
	}

	@Override
	public DataResult<List<CoverLetter>> getAll(CoverLetter coverLetter) {
		var result = this.coverLetterDao.findAll();
		return new SuccessDataResult<List<CoverLetter>>(result, "All Cover Letters Listed");
	}

	@Override
	public Result delete(CoverLetter coverLetter) {
		var coverLetterToDelete = this.coverLetterDao.findById(coverLetter.getId());
		if (coverLetterToDelete == null) {
			return new ErrorResult("Cover Letter not found");
		}
		return new SuccessResult("Cover Letter Deleted");
	}
	
}
