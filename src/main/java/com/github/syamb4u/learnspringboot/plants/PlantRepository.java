package com.github.syamb4u.learnspringboot.plants;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Syam
 *
 * Date Oct 22, 2018
 *
 * learn-springboot
 *
 */
public interface PlantRepository extends JpaRepository<Plant, Integer> {
	

}
