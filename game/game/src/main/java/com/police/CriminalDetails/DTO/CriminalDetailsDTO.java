package com.police.CriminalDetails.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CriminalDetailsDTO
{
	private int criminalId;
	private String criminalName;
	private String crime;
	private int DOB;
	private int height;
	private String birthMark;
	private String department;
}

/*This class simply holds the response.

It doesn't make HTTP calls.

It doesn't access the database.

It just receives the JSON returned by the Criminal Service. */