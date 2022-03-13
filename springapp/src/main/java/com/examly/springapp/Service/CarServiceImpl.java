package com.examly.springapp.Service;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.examly.springapp.Dao.CarDao;
import com.examly.springapp.Entity.Car;

@Component
public class CarServiceImpl implements CarService {

	@Resource 
	CarDao employeeDao;
	
	@Override
	public List<Car> findAll() {
		return employeeDao.findAll();
	}

	@Override
	public void insertCar(Car car) {
		// TODO Auto-generated method stub
		employeeDao.insertCar(car);
	}

	@Override
	public void updateCar(int id, Car car) {
		// TODO Auto-generated method stub
	   employeeDao.updateCar(id, car);	
	}

	@Override
	public void deleteCar(int id) {
		// TODO Auto-generated method stub
		employeeDao.deleteCar(id);
	}

	@Override
	public Car getCar(int id ) {
		// TODO Auto-generated method stub
		return employeeDao.getCar(id);
	}


	/*
	 * public String getName(String id,String password) {
	 * 
	 * return employeeDao.getName(id,password); }
	 */
	
}
