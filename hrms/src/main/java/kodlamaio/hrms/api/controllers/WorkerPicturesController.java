package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.WorkerPictureService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.WorkerPicture;

@RestController
@RequestMapping("/api/workerpictures")
public class WorkerPicturesController {

	private WorkerPictureService workerPictureService;

	@Autowired
	public WorkerPicturesController(WorkerPictureService workerPictureService) {
		super();
		this.workerPictureService = workerPictureService;
	}

	@GetMapping("/getall")
	public DataResult<List<WorkerPicture>> getAll() {
		return this.workerPictureService.getAll();
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody WorkerPicture workerPicture, MultipartFile image) throws Exception {
		return this.workerPictureService.add(image, workerPicture);
	}

}
