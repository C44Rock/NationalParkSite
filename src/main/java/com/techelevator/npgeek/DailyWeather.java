package com.techelevator.npgeek;

public class DailyWeather {

	private String parkCode;
	private int fiveDayForecastValue;
	private int lowTemp;
	private int highTemp;
	private String forecast;
	
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public int getFiveDayForecastValue() {
		return fiveDayForecastValue;
	}
	public void setFiveDayForecastValue(int fiveDayForecastValue) {
		this.fiveDayForecastValue = fiveDayForecastValue;
	}
	public int getLowTemp() {
		return lowTemp;
	}
	public void setLowTemp(int lowTemp) {
		this.lowTemp = lowTemp;
	}
	public int getHighTemp() {
		return highTemp;
	}
	public void setHighTemp(int highTemp) {
		this.highTemp = highTemp;
	}
	public String getForecast() {
		return forecast;
	}
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
	
	public String getNewForecast() {
		String newForecast = forecast.replaceAll("\\s", "");
		return newForecast;
	}
	
	public String makeRecommendation() {
		String rec = "";
		
		if (forecast.equals("snow")) {
			rec = "Pack snowshoes. ";
		} else if (forecast.equals("rain")) {
			rec = "Pack rain gear and waterproof shoes. ";
		} else if (forecast.equals("thunderstorms")) {
			rec = "Seek sheltar and avoid hiking on exposed ridges. ";
		} else if (forecast.equals("sunny")) {
			rec = "Pack sunblock. ";
		}
		
		if (highTemp > 75) {
			rec += "Bring an extra gallon of water. ";
		}
		
		if (highTemp - lowTemp > 20) {
			rec += "Wear breathable layers. ";
		}
		
		if (lowTemp < 20) {
			rec += "Exposure to frigid temperatures might cause you to lose your toes.";
		}
		
		return rec;
	}
	
	
}
