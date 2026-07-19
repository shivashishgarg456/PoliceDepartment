package com.police.DepartmentDetails.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.police.CriminalDetails.DTO.CriminalDetailsDTO;

//Its only job is to make an HTTP request - "Go to the Criminal Service, call /criminals/{id}, and bring me the response." - It does not store any data.

@FeignClient(name = "CRIMINALSERVICE")
public interface CriminalClient 
{
	@GetMapping("/criminals/{criminalId}")	//It should be exact same as CriminalServiceController 
	ResponseEntity<CriminalDetailsDTO> getCriminalById(@PathVariable int criminalId);
}