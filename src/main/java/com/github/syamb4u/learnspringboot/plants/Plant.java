package com.github.syamb4u.learnspringboot.plants;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "plants")
public class Plant {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    //@GeneratedValue(generator = "system-uuid")
    //@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private int specimanId;
	private String latitude;
	private String longitude;
	private String description;
	private String plantId;	

}
