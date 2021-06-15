package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkerSkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkerSkillDao;
import kodlamaio.hrms.entities.concretes.WorkerSkill;

@Service
public class WorkerSkillManager implements WorkerSkillService {

	private WorkerSkillDao workerSkillDao;

	@Autowired
	public WorkerSkillManager(WorkerSkillDao workerSkillDao) {
		super();
		this.workerSkillDao = workerSkillDao;
	}

	@Override
	public Result add(WorkerSkill workerSkill) {
		this.workerSkillDao.save(workerSkill);
		return new SuccessResult("Worker Skill added");
	}

	@Override
	public DataResult<List<WorkerSkill>> getAll() {
		var result = this.workerSkillDao.findAll();
		return new SuccessDataResult<List<WorkerSkill>>(result, "All Worker Skills Listed");
	};
}
