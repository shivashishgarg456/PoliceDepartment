package com.police.criminalservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.police.criminalservice.model.CriminalDetails;
import com.police.criminalservice.repository.CriminalDao;

@Service
public class CriminalService 
{
	private CriminalDao criminalDao;
	
	public CriminalService(CriminalDao criminalDao)
	{
		this.criminalDao = criminalDao;
	}
	
	public ResponseEntity<List<CriminalDetails>> getAllDetails()
	{
		try 
		{
		return new ResponseEntity<>(criminalDao.findAll(), HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<CriminalDetails> getDetailsById(int criminalId)
	{
		CriminalDetails criminal = criminalDao.findById(criminalId)
	            .orElseThrow(() -> new RuntimeException("Criminal not found"));
		
		return ResponseEntity.ok(criminal);
	}
	
	public ResponseEntity<String> createCriminal(CriminalDetails criminalDetails)
	{
		try
		{
		criminalDao.save(criminalDetails);
		return new ResponseEntity<>("success", HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	public String updateCriminal(CriminalDetails criminalDetails)
	{
		criminalDao.save(criminalDetails);
		return "success";
	}
	
	public String deleteCriminal(int criminalId)
	{
	    criminalDao.deleteById(criminalId);
	    return "deleted";
	}
}