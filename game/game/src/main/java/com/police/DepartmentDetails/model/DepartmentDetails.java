package com.police.DepartmentDetails.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name = "\"DepartmentDetails\"")
public class DepartmentDetails 
{
	@Id
	private int level; //1
	private String officerName; //Sam
	private String departmentName; //Patrolling
	private double salary; //$10000
	private List<String> vehicleAssigned; //Honda Bike, Ford SUV
}