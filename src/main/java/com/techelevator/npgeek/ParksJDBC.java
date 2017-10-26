package com.techelevator.npgeek;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class ParksJDBC {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public ParksJDBC(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Park> getAllParks() {
		List<Park> allParks = new ArrayList<>();
		
		String sqlSelectAllParks = "SELECT * FROM park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllParks);
		
		while(results.next()) {
			Park park = new Park();
			park.setParkCode(results.getString("parkCode"));
			park.setName(results.getString("parkName"));
			park.setLocation(results.getString("state"));
			park.setSummary(results.getString("parkDescription"));
			
			allParks.add(park);
		}
		return allParks;
	}
	
	public Park getParkByParkCode(String parkCode) {
		String sqlSelectParkByCode = "SELECT * FROM park " +
									"WHERE parkCode = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectParkByCode, parkCode);
		
		Park park = new Park();
		if(results.next()) {
			park.setParkCode(results.getString("parkCode"));
			park.setName(results.getString("parkName"));
			park.setLocation(results.getString("state"));
			park.setSummary(results.getString("parkDescription"));
			park.setSize(results.getString("acreage"));
			park.setElevation(results.getString("elevationInFeet"));
			park.setTrailLength(results.getString("milesOfTrail"));
			park.setCampsiteNumber(results.getString("numberOfCampsites"));
			park.setClimate(results.getString("climate"));
			park.setYearFounded(results.getString("yearFounded"));
			park.setVisitorCount(results.getString("annualVisitorCount"));
			park.setQuote(results.getString("inspirationalQuote"));
			park.setQuoteSource(results.getString("inspirationalQuoteSource"));
			park.setEntryFee(results.getString("entryFee"));
			park.setSpeciesCount(results.getString("numberOfAnimalSpecies"));
		}
		return park;
	}
	
	public List<DailyWeather> getWeatherByParkCode(String parkCode) {
		List<DailyWeather> weeklyForecast = new ArrayList<>();
		String sqlSelectWeatherByCode = "SELECT * FROM weather " +
										"WHERE parkCode = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectWeatherByCode, parkCode);
		
		while (results.next()) {
			DailyWeather dailyForecast = new DailyWeather();
			dailyForecast.setParkCode(results.getString("parkCode"));
			dailyForecast.setFiveDayForecastValue(results.getInt("fiveDayForecastValue"));
			dailyForecast.setLowTemp(results.getInt("low"));
			dailyForecast.setHighTemp(results.getInt("high"));
			dailyForecast.setForecast(results.getString("forecast"));
			
			weeklyForecast.add(dailyForecast);
		}
		return weeklyForecast;
		
	}
	
	public void saveSurveyResults(String parkCode, String email, String state, String activity) {
		String sqlInsertSurvey = "INSERT INTO survey_result (surveyId, parkCode, emailAddress, state, activityLevel)" +
								"VALUES (?, ?, ?, ?, ?)";
		
		jdbcTemplate.update(sqlInsertSurvey, getNextSurveyId(), parkCode, email, state, activity);
		
	}

	private int getNextSurveyId() {
		SqlRowSet nextId = jdbcTemplate.queryForRowSet("SELECT nextval('seq_surveyId')");
		if(nextId.next()) {
			return nextId.getInt(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new survey");
		}
	}
	
	public List<Park> getSurveyCountByPark() {
		List<Park> popularParks = new ArrayList<>();
		
		String sqlCountSurveys = "SELECT survey_result.parkCode, park.parkName, COUNT(*) AS surveyCount " +
								"FROM survey_result JOIN park ON survey_result.parkCode = park.parkCode " +
								"GROUP BY survey_result.parkCode, park.parkName " +
								"ORDER BY COUNT(*) DESC, survey_result.parkCode ";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlCountSurveys);
		
		while (results.next()) {
			Park park = new Park();
			
			park.setParkCode(results.getString("parkCode"));
			park.setName(results.getString("parkName"));
			park.setSurveyCount(results.getInt("surveyCount"));
			popularParks.add(park);
		}
		return popularParks;
	}
	
}
