package kodlamaio.hrms.business.concretes;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.WorkerPictureService;
import kodlamaio.hrms.core.adapters.abstracts.ImageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkerPictureDao;
import kodlamaio.hrms.entities.concretes.WorkerPicture;

@Service
public class WorkerImageManager implements WorkerPictureService {

	private WorkerPictureDao workerPictureDao;
	private ImageService imageService;
	
	@Autowired
	public WorkerImageManager(WorkerPictureDao workerPictureDao, ImageService imageService) {
		super();
		this.workerPictureDao = workerPictureDao;
		this.imageService = imageService;
	}

	@Override
	public Result add(MultipartFile image, WorkerPicture workerPicture) throws IOException {
		var checkServer = this.saveToServer(image);
		if(!checkServer.isSuccess()) return checkServer;
		
		workerPicture.setPictureUrl(checkServer.getData());
		
		this.workerPictureDao.save(workerPicture);
		return new SuccessResult("Picture Saved!");
	}

	private DataResult<String> saveToServer(MultipartFile image) throws IOException {
		var result = imageService.uploadImage(image);
		return result;
	}

}
