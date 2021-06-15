package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EducationInfoService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EducationInfoDao;
import kodlamaio.hrms.entities.concretes.EducationInfo;

@Service
public class EducationInfoManager implements EducationInfoService {
	
	private EducationInfoDao educationInfoDao;

	@Autowired
	public EducationInfoManager(EducationInfoDao educationInfoDao) {
		super();
		this.educationInfoDao = educationInfoDao;
	}

	@Override
	public Result add(EducationInfo educationInfo) {
		this.educationInfoDao.save(educationInfo);
		return new SuccessResult("Education Info Saved");
	}

	@Override
	public DataResult<List<EducationInfo>> getAll() {
		var result = this.educationInfoDao.findAll();
		return new SuccessDataResult<List<EducationInfo>>(result, "All Education Info Returned");
	}

	@Override
	public DataResult<List<EducationInfo>> findAllByOrderByEndDateDesc() {
		var result = this.educationInfoDao.findAllByOrderByEndDateDesc();
		return new SuccessDataResult<List<EducationInfo>>(result, "All Education Info Returned By End Date");
	}
	
	
}
