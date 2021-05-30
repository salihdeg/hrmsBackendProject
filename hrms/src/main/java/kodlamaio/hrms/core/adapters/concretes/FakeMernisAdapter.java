package kodlamaio.hrms.core.adapters.concretes;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.adapters.abstracts.UserCheckService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Worker;
import kodlamaio.hrms.services.FakeMernis;

@Service
@Qualifier("MernisFake")
public class FakeMernisAdapter implements UserCheckService {

	@Override
	public Result checkWorker(Worker worker) {
		
		FakeMernis fakeMernis = new FakeMernis();
		var checkResult = fakeMernis.checkPerson(Long.parseLong(worker.getNationalityId()), worker.getFirstName(), worker.getLastName(), worker.getYearOfBirth());
		if (!checkResult) {
			return new ErrorResult("This Person Not Exist");
		}
		
		return new SuccessResult();
	}
	
	
	
}
