package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmailService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class EmailManager implements EmailService {

	@Override
	public Result sendVerificationMail(User user, String verificationToken) {
		// Real Mail Service Codes
		
		
		return new SuccessResult("Mail Sent");
	}

}
