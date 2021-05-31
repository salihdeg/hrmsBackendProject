package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AdminVerificationService;
import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.EmailService;
import kodlamaio.hrms.business.abstracts.EmailVerificationService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.AdminVerification;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.EmployerEmailVerification;
import kodlamaio.hrms.entities.concretes.Worker;
import net.bytebuddy.utility.RandomString;

@Service
public class AuthManager implements AuthService{

	private EmailVerificationService emailVerificationService;
	private EmployerService employerService;
	private AdminVerificationService adminVerificationService;
	private EmailService emailService;
	
	@Autowired
	public AuthManager(EmailVerificationService emailVerificationService, EmployerService employerService,
			AdminVerificationService adminVerificationService, EmailService emailService) {
		super();
		this.emailVerificationService = emailVerificationService;
		this.employerService = employerService;
		this.adminVerificationService = adminVerificationService;
		this.emailService = emailService;
	}

	@Override
	public Result employerRegister(Employer employer) {
		
		var employerServiceReturn = this.employerService.add(employer);
		if (!employerServiceReturn.isSuccess()) {
			return employerServiceReturn;
		}
		//adminVerify False
		AdminVerification adminVerification = new AdminVerification();
		adminVerification.setEmployer(employer);
		var adminVerifyReturn = this.adminVerificationService.add(adminVerification);
		if (!adminVerifyReturn.isSuccess()) {
			return adminVerifyReturn;
		}
		
		//emailVerify False
		EmployerEmailVerification employerEmailVerification = new EmployerEmailVerification();
		employerEmailVerification.setEmployer(employer);
		var emailVerifyReturn = this.emailVerificationService.add(employerEmailVerification);
		if (!emailVerifyReturn.isSuccess()) {
			return emailVerifyReturn;
		}
		
		//email service - email gönderim
		String verificationToken = RandomString.make(64);
		var emailServiceReturn = this.emailService.sendVerificationMail(employer, verificationToken);
		if (!emailServiceReturn.isSuccess()) {
			return emailServiceReturn;
		}
		
		return new SuccessResult("Employer Saved, Waiting for admin and email Verification! " + emailServiceReturn.getMessage());
	}

	@Override
	public Result employerVerification(Employer employer) {
		// TODO Bunu yaparsın bir ara
		return new ErrorResult("Development process continues");
	}
	
	@Override
	public Result workerRegister(Worker worker) {
		// TODO Bunu da yaparsın bir ara
		return new ErrorResult("Development process continues");
	}

	

}
