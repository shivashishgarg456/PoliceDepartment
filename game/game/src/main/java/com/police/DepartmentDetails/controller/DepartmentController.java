package com.police.DepartmentDetails.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.police.CriminalDetails.DTO.CriminalDetailsDTO;
import com.police.DepartmentDetails.model.DepartmentDetails;
import com.police.DepartmentDetails.service.DepartmentService;

@RestController
@RequestMapping("home")
public class DepartmentController 
{
	private DepartmentService departmentService;
	
	public DepartmentController(DepartmentService departmentService)
	{
		this.departmentService = departmentService;
	}
	
	@GetMapping("/health")
	public String health()
	{
		return "Aplication is running";
	}
	
	@GetMapping("/allplayers")
	public ResponseEntity<List<DepartmentDetails>> getAllDetails()
	{
		return departmentService.getAllDetails();
	}
	
	@GetMapping("/players/{level}")
	public ResponseEntity<List<DepartmentDetails>> getPlayersByLevel(@PathVariable int level)
	{
		return departmentService.getDepartmentDetailsByLevel(level);
	}
	
	@PostMapping("/players/create")
	public ResponseEntity<String> addPlayer(@RequestBody DepartmentDetails departmentDetails)
	{											
		return departmentService.addNewDepartment(departmentDetails);
	}
	
	@PutMapping("/players/update")
	public String updatePlayer(@RequestBody DepartmentDetails departmentDetails)
	{
		return departmentService.updateDepartment(departmentDetails);
	}
	
	@DeleteMapping("/delete/{level}")
	public String deletePlayer(@PathVariable int level)
	{
		return departmentService.deleteDepartment(level);
	}
	
	@GetMapping("/crime/{criminalId}")
	public CriminalDetailsDTO getCriminal(@PathVariable int criminalId)
	{
		return departmentService.getCriminal(criminalId);
	}
}