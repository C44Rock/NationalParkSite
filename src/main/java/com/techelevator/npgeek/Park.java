package com.techelevator.npgeek;

public class Park {

	private String parkCode;
	private String name;
	private String location;
	private String summary;
	private String size;
	private String elevation;
	private String trailLength;
	private String campsiteNumber;
	private String climate;
	private String yearFounded;
	private String visitorCount;
	private String quote;
	private String quoteSource;
	private String entryFee;
	private String speciesCount;
	
	
	public String getImage() {
		return parkCode.toLowerCase();
	}
	
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getElevation() {
		return elevation;
	}

	public void setElevation(String elevation) {
		this.elevation = elevation;
	}

	public String getTrailLength() {
		return trailLength;
	}

	public void setTrailLength(String trailLength) {
		this.trailLength = trailLength;
	}

	public String getCampsiteNumber() {
		return campsiteNumber;
	}

	public void setCampsiteNumber(String campsiteNumber) {
		this.campsiteNumber = campsiteNumber;
	}

	public String getClimate() {
		return climate;
	}

	public void setClimate(String climate) {
		this.climate = climate;
	}

	public String getYearFounded() {
		return yearFounded;
	}

	public void setYearFounded(String yearFounded) {
		this.yearFounded = yearFounded;
	}

	public String getVisitorCount() {
		return visitorCount;
	}

	public void setVisitorCount(String visitorCount) {
		this.visitorCount = visitorCount;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public String getQuoteSource() {
		return quoteSource;
	}

	public void setQuoteSource(String quoteSource) {
		this.quoteSource = quoteSource;
	}

	public String getEntryFee() {
		return entryFee;
	}

	public void setEntryFee(String entryFee) {
		this.entryFee = entryFee;
	}

	public String getSpeciesCount() {
		return speciesCount;
	}

	public void setSpeciesCount(String speciesCount) {
		this.speciesCount = speciesCount;
	}
	
}
