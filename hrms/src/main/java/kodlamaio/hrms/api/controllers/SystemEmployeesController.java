package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SystemEmployeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemEmployee;

@RestController
@RequestMapping("/api/systememployees")
public class SystemEmployeesController {

	private SystemEmployeeService systemEmployeeService;
	
	@Autowired
	public SystemEmployeesController(SystemEmployeeService systemEmployeeService) {
		this.systemEmployeeService = systemEmployeeService;
	}
	
	@GetMapping("/getall")
	DataResult<List<SystemEmployee>> getAll(){
		return this.systemEmployeeService.getAll();
	}
	
	@PostMapping("/add")
	Result add(@Valid @RequestBody SystemEmployee systemEmployee) throws Exception {
		return this.systemEmployeeService.add(systemEmployee);
	}
}
