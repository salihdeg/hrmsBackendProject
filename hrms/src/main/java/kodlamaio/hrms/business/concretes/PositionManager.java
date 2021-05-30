package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.PositionService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.PositionDao;
import kodlamaio.hrms.entities.concretes.Position;

@Service
public class PositionManager implements PositionService {

	private PositionDao postitonDao;

	@Autowired
	public PositionManager(PositionDao postitonDao) {
		this.postitonDao = postitonDao;
	}

	@Override
	public DataResult<List<Position>> getAll() {
		//TODO Business rules!!
		return new SuccessDataResult<List<Position>>(this.postitonDao.findAll(), "All Data Listed");
	}

	@Override
	public Result add(Position position) {
		
		var errors = BusinessRules.Run(checkPositionExist(position));
		if (errors!=null) {
			return errors;
		}
		
		this.postitonDao.save(position);
		return new SuccessResult("Position Saved");
	}
	
	private Result checkPositionExist(Position position) {
		var result = this.postitonDao.findByName(position.getName().trim());
		if (result != null) {
			return new ErrorResult("Position Exist!");
		}
		return new SuccessResult();
	}


}
