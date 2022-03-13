package com.examly.springapp.Dao;

import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import com.examly.springapp.Entity.Car;
import com.examly.springapp.Mapper.CarMapper;;

@Repository
public class CarDaoImpl implements CarDao {

	public CarDaoImpl(NamedParameterJdbcTemplate template, JdbcTemplate temp) {
		this.template = template;
		this.temp = temp;
	}


	NamedParameterJdbcTemplate template;
	JdbcTemplate temp;
	@Override
	public List<Car> findAll() {
		
		return template.query("select * from car",new CarMapper());
	}

	
	public void insertCar(Car car) {
		
		final String sql = "insert into car(id,carmodel,carno,status) values(:id,:carmodel,:carno,:status)";
		//Car car = new Car(123,"hello","1234","Not");
		System.out.println(car.getCarId());
		System.out.println(car.getCarModel());
		System.out.println(car.getCarNo());
		System.out.println(car.getStatus());
		
		KeyHolder holder = new GeneratedKeyHolder();
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", car.getCarId())
				.addValue("carmodel",car.getCarModel()).addValue("carno",car.getCarNo())
				.addValue("status", car.getStatus());

		template.update(sql, param, holder);
  }


	@Override
	public void updateCar(int id, Car car) {
				
		final String sql = "update car set carmodel=:carmodel,carno=:carno,status=:status where id=:id";
		KeyHolder holder = new GeneratedKeyHolder();
		SqlParameterSource param = new MapSqlParameterSource().addValue("id",id).addValue("carmodel",car.getCarModel()).addValue("carno",car.getCarNo()).addValue("status", car.getStatus());
		
		template.update(sql, param, holder);
	}

	@Override
	public void deleteCar(int id) {
		
		final String sql = "delete from car where id=:id";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);

		template.execute(sql, map, new PreparedStatementCallback<Object>() {
			@Override
			public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				return ps.executeUpdate();
			}
		});
	}


	@Override
	public Car getCar(int id) {
		
	 return template.query("select * from car where id  ="+id,new CarMapper()).get(0);
	}

//	/*
//	 * @Override public String getName(String id, String password) {
//	 * 
//	 * String sql = "SELECT * FROM employee WHERE id=" + id + " and password=" +
//	 * password; return this.temp.query(sql, new ResultSetExtractor<String>() {
//	 * public String extractData(ResultSet resultSetObj) throws SQLException,
//	 * DataAccessException { String s = ""; if (resultSetObj.next()) { s =
//	 * resultSetObj.getString("name");// column name return s; } else { return s =
//	 * "Not Found"; } } }); }
//	 */
}