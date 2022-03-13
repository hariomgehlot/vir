package com.examly.springapp.Controller;
import java.util.List;
import javax.annotation.Resource;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.examly.springapp.Service.CarService;
import com.examly.springapp.Entity.Car;


@RestController


public class ApplicationController {
	
	@Resource
	CarService carService;
	
	@GetMapping("/getcars")
	public List<Car> getCars() {

		return carService.findAll();
	}
	
	@GetMapping("/getcar")
	public Car getCar(@RequestParam (value="id", required =true) int id) {

		return carService.getCar(id );
	}
	@PostMapping("/savecar")
	public Car insertCar(@RequestBody Car employee) {
		carService.insertCar(employee);
		return employee;
	}	
	
	@PutMapping(value = "/editcar")
	public void updateCar(@RequestParam(value ="id",required =true)int id,@RequestBody Car employee) {
		carService.updateCar(id,employee);
	}
	
	@DeleteMapping(value = "/deletecar")
	public void deleteCar(@RequestParam(value ="id",required =true)int id) {
		carService.deleteCar(id);
	}



}
	