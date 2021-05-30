package kodlamaio.hrms.core.utilities.business;

import kodlamaio.hrms.core.utilities.results.Result;

public class BusinessRules {
	
	public static Result Run(Result... logics ) {
		
		for (Result logic : logics) {
			if (logic.isSuccess() == false) {
				return logic;
			}
		}
		
		return null;
	}

}
