package com.github.syamb4u.learnspringboot.plants;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Syam
 *
 * Date Oct 22, 2018
 *
 * learn-springboot
 *
 */
@Component
public class PlantServiceImpl implements PlantService {

	@Autowired
	PlantRepository plantRepository;
	
	public Optional<Plant> fetchById(int id) {
		return plantRepository.findById(id);
	}

	@Override
	public Plant save(Plant plant) {
		return plantRepository.save(plant);
	}

	@Override
	public List<Plant> getAllPlants() {
		return (List<Plant>) plantRepository.findAll();
	}

	@Override
	public void save(Map<String, Object> updates, String id) {
		
	}

	@Override
	public void delete(int id) {
		plantRepository.deleteById(id);
		
	}

	@Override
	public List<Plant> saveAll(List<Plant> plants) {
		return plantRepository.saveAll(plants);
	}

}
