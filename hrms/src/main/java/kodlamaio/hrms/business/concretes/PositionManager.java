package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.PositionService;
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
	public List<Position> getAll() {

		return this.postitonDao.findAll();
	}

}
