package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.WorkerPicture;

public interface WorkerPictureDao extends JpaRepository<WorkerPicture, Integer>{

}
