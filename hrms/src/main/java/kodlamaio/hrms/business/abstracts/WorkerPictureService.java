package kodlamaio.hrms.business.abstracts;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.WorkerPicture;

public interface WorkerPictureService {

	Result add(MultipartFile image,WorkerPicture workerPicture) throws IOException;
}