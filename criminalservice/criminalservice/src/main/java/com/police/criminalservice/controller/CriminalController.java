package com.police.criminalservice.controller;

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
import com.police.criminalservice.model.CriminalDetails;
import com.police.criminalservice.service.CriminalService;

@RestController
@RequestMapping("criminals")
public class CriminalController 
{
	private CriminalService criminalService;
	
	public CriminalController(CriminalService criminalService)
	{
		this.criminalService = criminalService;
	}
	
	@GetMapping("/allcriminals")
	public ResponseEntity<List<CriminalDetails>> getAllDetails()
	{
		return criminalService.getAllDetails();
	}
	
	@GetMapping("/{criminalId}") //Feign Client inside DepartmentService should exactly match this
	public ResponseEntity<CriminalDetails> getDetailsById(@PathVariable int criminalId)
	{
		return criminalService.getDetailsById(criminalId);
	}
	
	@PostMapping("/createcriminal")
	public ResponseEntity<String> createCriminal(@RequestBody CriminalDetails criminalDetails)
	{
		return criminalService.createCriminal(criminalDetails);
	}
	
	@PutMapping("/updatecriminal")
	public String updateCriminal(@RequestBody CriminalDetails criminalDetails)
	{
		return criminalService.updateCriminal(criminalDetails);
	}
	
	@DeleteMapping("/deletecriminal/{criminalId}")
	public String deleteCriminal(@PathVariable int criminalId)
	{
		return criminalService.deleteCriminal(criminalId);
	}
}
