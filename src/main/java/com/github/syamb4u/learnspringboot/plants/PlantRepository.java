package com.github.syamb4u.learnspringboot.plants;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
public interface PlantRepository extends JpaRepository<Plant, Integer> {
	

}
