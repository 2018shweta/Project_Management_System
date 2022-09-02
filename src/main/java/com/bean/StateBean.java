package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="state")
public class StateBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer stateId;
	
	private String stateName;
	
	
	
	
}
