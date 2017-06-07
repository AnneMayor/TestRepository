package com.travel.journey.service;

import java.util.List;

import com.travel.journey.dto.Travel;

public interface TravelService {
	public void travelWrite(Travel travel);
	public List<Travel> travelListPage(int pageNo, int rowsPerPage);
	public int travelTotalRows();
	public Travel getTravel(int tnumber);
	public void travelUpdate(Travel travel);
	public void travelDelete(int tnumber);
}