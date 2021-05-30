package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.SystemEmployee;

public interface SystemEmployeeDao extends JpaRepository<SystemEmployee, Integer> {
	SystemEmployee findByEmail(String email);
}
