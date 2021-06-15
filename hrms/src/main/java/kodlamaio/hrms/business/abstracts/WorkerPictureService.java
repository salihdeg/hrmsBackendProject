package kodlamaio.hrms.business.abstracts;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.WorkerPicture;

public interface WorkerPictureService {
	Result add(MultipartFile image,WorkerPicture workerPicture) throws IOException;
	DataResult<List<WorkerPicture>> getAll();
	DataResult<WorkerPicture> getById(int id);
}