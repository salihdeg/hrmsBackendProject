package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Worker;

@RestController
@RequestMapping("/api/workers")
public class WorkersController {

	private WorkerService workerService;
	
	@Autowired
	public WorkersController(WorkerService workerService) {
		this.workerService = workerService;
	}
	
	@GetMapping("/getall")
	DataResult<List<Worker>> getAll() {
		return this.workerService.getAll();
	}
	
	@PostMapping("/add")
	Result add(@Valid @RequestBody Worker worker) throws Exception {
		return this.workerService.add(worker);
	}
	
	@PostMapping("/delete")
	Result delete(@Valid @RequestBody Worker worker) throws Exception {
		return this.workerService.delete(worker);
	}
}
