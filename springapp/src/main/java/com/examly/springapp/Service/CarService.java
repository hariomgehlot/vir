package com.examly.springapp.Service;

import java.util.List;

import com.examly.springapp.Entity.Car;

public interface CarService{

	List<Car> findAll();
	void insertCar(Car car);
	void updateCar(int id, Car car);
	void deleteCar(int id);
	Car getCar(int id);
}
