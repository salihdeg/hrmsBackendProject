package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Worker;

public interface WorkerDao extends JpaRepository<Worker, Integer> {
	Worker findByEmail(String email);
	Worker findByNationalityId(String nationalityId);
}
