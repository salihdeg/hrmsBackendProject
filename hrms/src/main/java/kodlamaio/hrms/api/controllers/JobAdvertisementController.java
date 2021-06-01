package kodlamaio.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/JobAdvertisements")
public class JobAdvertisementController {
	
	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		var result = this.jobAdvertisementService.getAll();
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody JobAdvertisement jobAdvertisement){
		return ResponseEntity.ok(this.jobAdvertisementService.add(jobAdvertisement));
	}
	
	@GetMapping("/getByIsActiveTrueOrderByCreationDate")
	public ResponseEntity<?> findByIsActiveTrueOrderByCreationDate(){
		var result = this.jobAdvertisementService.findByIsActiveTrueOrderByCreationDate();
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/getByIsActiveTrue")
	public ResponseEntity<?> getByIsActiveTrue(){
		var result = this.jobAdvertisementService.findByIsActiveTrue();
		return ResponseEntity.ok(result);
	}
	
	
	@GetMapping("/findByEmployer_IdAndIsActiveTrue")
	public ResponseEntity<?> findByEmployer_IdAndIsActiveTrue(@RequestParam int id){
		var result = this.jobAdvertisementService.findByEmployer_IdAndIsActiveTrue(id);
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody JobAdvertisement jobAdvertisement){
		return ResponseEntity.ok(this.jobAdvertisementService.update(jobAdvertisement));
	}
	
	
}
