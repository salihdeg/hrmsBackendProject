package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.EmployerEmailVerification;

public interface EmployerEmailVerificationDao extends JpaRepository<EmployerEmailVerification, Integer> {
	

}
