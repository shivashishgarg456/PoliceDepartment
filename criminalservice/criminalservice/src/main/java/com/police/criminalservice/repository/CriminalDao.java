package com.police.criminalservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.police.criminalservice.model.CriminalDetails;

public interface CriminalDao extends JpaRepository<CriminalDetails, Integer> 
{
	List<CriminalDetails> findByCriminalId(int criminalId);
}
