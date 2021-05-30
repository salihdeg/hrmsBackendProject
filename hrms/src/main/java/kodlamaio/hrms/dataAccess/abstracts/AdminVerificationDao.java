package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.AdminVerification;

public interface AdminVerificationDao extends JpaRepository<AdminVerification, Integer>{

}
