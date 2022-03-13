package com.examly.springapp.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import com.examly.springapp.Entity.Car;
public class CarMapper implements RowMapper<Car> {

	public Car mapRow(ResultSet rs, int arg1) throws SQLException {	 
		
		Car car = new Car();
		car.setCarId(rs.getInt(1));
		car.setCarModel(rs.getString(2));
		car.setCarNo(rs.getString(3));
		car.setStatus(rs.getString(4));
        return car;
	}
}
