package com.github.syamb4u.learnspringboot.plants;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PlantService {
	public Optional<Plant> fetchById(int id);

	public Plant save(Plant plant);
	
	public List<Plant> getAllPlants();

	public void save(Map<String, Object> updates, String id);

	public void delete(int id);

	public List<Plant> saveAll(List<Plant> plants);

}
