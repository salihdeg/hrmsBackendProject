package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService {

	private CityDao cityDao;	
	
	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public Result add(City city) {
		this.cityDao.save(city);
		return new SuccessResult("City Added");
	}

	@Override
	public DataResult<List<City>> getAll() {
		var result = this.cityDao.findAll();
		return new SuccessDataResult<List<City>>(result, "All Cities Listed");
	}

	@Override
	public Result delete(City city) {
		var cityToDelete = this.cityDao.findById(city.getId());
		if (cityToDelete == null) {
			return new ErrorResult("There is no city to delte");
		}
		this.cityDao.deleteById(city.getId());
		return new SuccessResult("City Deleted");
	}


}
