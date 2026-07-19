package com.police.DepartmentDetails.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.police.CriminalDetails.DTO.CriminalDetailsDTO;
import com.police.DepartmentDetails.feignClient.CriminalClient;
import com.police.DepartmentDetails.model.DepartmentDetails;
import com.police.DepartmentDetails.repo.DepartmentDao;

@Service
public class DepartmentService 
{
	private final DepartmentDao departmentDao;
	private final CriminalClient criminalClient;
	
	public DepartmentService(DepartmentDao departmentDao, CriminalClient criminalClient)
	{
		this.departmentDao = departmentDao;
		this.criminalClient = criminalClient;
	}
	
	public ResponseEntity<List<DepartmentDetails>> getAllDetails()
	{
		try
		{
			return new ResponseEntity<>(departmentDao.findAll(), HttpStatus.OK);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<DepartmentDetails>> getDepartmentDetailsByLevel(int level) 
	{
		try 
		{
		return new ResponseEntity<>(departmentDao.findByLevel(level), HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<String> addNewDepartment(DepartmentDetails departmentDetails)
	{
		try
		{
		departmentDao.save(departmentDetails);
		return new ResponseEntity<>("sucess", HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	public String updateDepartment(DepartmentDetails departmentDetails)
	{
		departmentDao.save(departmentDetails);
		return "success";
	}
	
	public String deleteDepartment(int level)
	{
		departmentDao.deleteById(level);
		return "deleted";
	}

	public CriminalDetailsDTO getCriminal(int criminalId) 
	{
		ResponseEntity<CriminalDetailsDTO> response = criminalClient.getCriminalById(criminalId);
		
		return response.getBody();
	}
	
	/*  criminalClient.getCriminalById(...) → makes an HTTP call

        CriminalDetailsDTO → receives the returned data   */
}
