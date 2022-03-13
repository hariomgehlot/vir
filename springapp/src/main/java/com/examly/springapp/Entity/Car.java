package com.examly.springapp.Entity;
public class Car {
	private int carId;
	private String carModel;
	private String carNo;
	private String status;
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Car [carId=" + carId + ", carModel=" + carModel + ", carNo=" + carNo + ", status=" + status + "]";
	}
	public Car(int carId, String carModel, String carNo, String status) {
		super();
		this.carId = carId;
		this.carModel = carModel;
		this.carNo = carNo;
		this.status = status;
	}
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}