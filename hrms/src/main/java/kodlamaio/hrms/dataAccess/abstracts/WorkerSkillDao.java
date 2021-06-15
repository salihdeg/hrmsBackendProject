package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.WorkerSkill;

public interface WorkerSkillDao extends JpaRepository<WorkerSkill, Integer>{

}
