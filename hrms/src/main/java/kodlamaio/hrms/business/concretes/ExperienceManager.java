package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ExperienceDao;
import kodlamaio.hrms.entities.concretes.Experience;

@Service
public class ExperienceManager implements ExperienceService{
	
	private ExperienceDao experienceDao; 

	@Autowired
	public ExperienceManager(ExperienceDao experienceDao) {
		super();
		this.experienceDao = experienceDao;
	}

	@Override
	public Result add(Experience experience) {
		this.experienceDao.save(experience);
		return new SuccessResult("Experience Info Saved");
	}

	@Override
	public DataResult<List<Experience>> getAll() {
		var result = this.experienceDao.findAll();
		return new SuccessDataResult<List<Experience>>(result, "All Experience Info's Listed");
	}

	@Override
	public Result delete(Experience experience) {
		var experienceToDelete = this.experienceDao.findById(experience.getId());
		if (experienceToDelete == null) {
			return new ErrorResult("Experience Info Not Found");
		}
		return new SuccessResult("Experience Deleted");
	}

}
