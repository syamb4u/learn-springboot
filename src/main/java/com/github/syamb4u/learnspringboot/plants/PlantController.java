package com.github.syamb4u.learnspringboot.plants;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.HttpStatus;

import com.github.syamb4u.learnspringboot.config.patch.json.Patch;
import com.github.syamb4u.learnspringboot.config.patch.json.PatchRequestBody;

/**
 * @author Syam
 *
 * Date Oct 22, 2018
 *
 * learn-springboot
 *
 */

@RestController
@RequestMapping("/api/v1/plants")
public class PlantController {
	
	@Autowired
	PlantService plantService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Plant> list() {
		System.out.println(" Entered Controller Method");
		return plantService.getAllPlants();

	}
	/*
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> create(@RequestBody Plant plant) {
		System.out.println(" Entered Controller Method");
		Plant savedPlant = plantService.save(plant);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedPlant.getSpecimanId()).toUri();

		return ResponseEntity.created(location).build();
	}
	*/
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Plant> create(@RequestBody List<Plant> plants) {
		System.out.println(" Entered Controller Method");
		List<Plant> savedPlants = plantService.saveAll(plants);
		
		return savedPlants;
	}

	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Plant update(@RequestBody Plant plant, @PathVariable int id) {
		Plant savedPlant = null;
		URI location = null;
		ResponseEntity<Object> response = null;
		Optional<Plant> plantOptional = plantService.fetchById(id);
		if( plantOptional.isPresent()) {
			plant.setSpecimanId(id);
			savedPlant = plantService.save(plant);
			
			//location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			//		.buildAndExpand(savedPlant.getSpecimanId()).toUri();
			
			//response = ResponseEntity.created(location).build();
		}		
		return savedPlant;
	}
	
	
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
    @Patch(service = PlantService.class, id = String.class)
    public Plant patch(@PathVariable String id,
                       @PatchRequestBody Plant plant) {

        plant.setPlantId(id);
        return plantService.save(plant);
    }
	
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {

        plantService.delete(id);
    }
}
