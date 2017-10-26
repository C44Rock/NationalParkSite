package com.techelevator.npgeek;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("degreeUnit")
public class ParkGeekController {
	
	@Autowired
	private ParksJDBC dao;
	
	@RequestMapping(path ="/", method = RequestMethod.GET)
	public String displayHomePage(HttpServletRequest request, ModelMap model) {
		request.setAttribute("parkList", dao.getAllParks());
		
		if (!model.containsKey("degreeUnit")) {
			model.addAttribute("degreeUnit", "F");
		}
		return "homePage";
	}
	
	@RequestMapping(path ="/", method = RequestMethod.POST)
	public String displayHomePage(ModelMap model, @RequestParam String degreeUnit) {
		
		model.replace("degreeUnit", degreeUnit);
		return "redirect:/";
	}
	
	@RequestMapping(path = "/parkDetail", method = RequestMethod.GET)
	public String displayDetailPage(@RequestParam String parkCode, HttpServletRequest request, ModelMap model) {
		Park thePark = dao.getParkByParkCode(parkCode);
		List<DailyWeather> weeklyForecast = dao.getWeatherByParkCode(parkCode);
		
		if(model.get("degreeUnit").equals("C")) {
			for(DailyWeather dailyForecast : weeklyForecast) {
				dailyForecast.setHighTemp((dailyForecast.getHighTemp() - 32) * 5 / 9);
				dailyForecast.setLowTemp((dailyForecast.getLowTemp() - 32) * 5 / 9);
			}
		}
		
		request.setAttribute("thisPark", dao.getParkByParkCode(parkCode));
		request.setAttribute("weeklyForecast", dao.getWeatherByParkCode(parkCode));
		
		return "parkDetail";
	}
	
	@RequestMapping(path ="/surveyInput", method = RequestMethod.GET)
	public String displaySurveyPage() {
		
		return "surveyInput";
	}
	
	@RequestMapping(path ="/surveyOutput", method = RequestMethod.POST)
	public String surveyInfoPage(@RequestParam String parkCode,
								@RequestParam String email,
								@RequestParam String state,
								@RequestParam String activity) {
		
		dao.saveSurveyResults(parkCode, email, state, activity);
		return "redirect:/surveyResults";
	}
	
	@RequestMapping(path ="/surveyResults", method = RequestMethod.GET)
	public String displaySurveyResultsPage(HttpServletRequest request) {
		
		request.setAttribute("popularParks", dao.getSurveyCountByPark());
		
		return "surveyResults";
	}

}
