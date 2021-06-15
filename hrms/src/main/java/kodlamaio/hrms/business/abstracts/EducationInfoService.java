package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EducationInfo;

public interface EducationInfoService {
	Result add(EducationInfo educationInfo);
	DataResult<List<EducationInfo>> getAll();
	DataResult<List<EducationInfo>> findAllByOrderByEndDateDesc();
}
