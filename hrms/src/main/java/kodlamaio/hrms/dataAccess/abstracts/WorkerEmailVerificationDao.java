package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.WorkerEmailVerification;

public interface WorkerEmailVerificationDao extends JpaRepository<WorkerEmailVerification, Integer> {

}
