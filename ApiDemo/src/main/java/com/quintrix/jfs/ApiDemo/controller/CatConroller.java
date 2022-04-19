package com.quintrix.jfs.ApiDemo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quintrix.jfs.ApiDemo.models.Cat;


@RestController
public class CatConroller {

	List<Cat> catsList = new ArrayList<>(Arrays.asList(new Cat(1, "Callie", 11, "Callico"),
			new Cat(2, "Einstien", 9, "Spotted"), new Cat(3, "Maxwell", 5, "Brown")));
	
	@RequestMapping(method = RequestMethod.GET, value = "/cats")
	List<Cat> getCats(@RequestParam(name = "name", required = false) String name) {		
	
		if (name != null) {
			return catsList.stream().filter(c -> c.getName().equals(name)).collect(Collectors.toList());
		} else {
			return catsList;
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/cats/{id}")
    Cat getCarDetails(@PathVariable("id") Integer id) {
		
		Optional<Cat> cat =
				catsList.stream().filter(c -> c.getId().intValue() == id.intValue()).findAny();
		if (cat.isPresent()) {
			return cat.get();
		} else {
			return new Cat();
		}
	}
	
	 @RequestMapping(method = RequestMethod.POST, value = "/cats")
	    Cat addCars(@RequestBody Cat cat) {     	
	    	
	    	catsList.add(cat);
	    	
	    	return cat;
	    }
}
