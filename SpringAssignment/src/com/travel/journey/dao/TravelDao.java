package com.travel.journey.dao;

import java.util.List;

import com.travel.journey.dto.Travel;

public interface TravelDao {
	public long travelInsert(Travel travel);
	public List<Travel> travelSelectPage(int pageNo, int rowsPerPage);
	public int travelCountAll();
	public Travel travelSelectByTnumber(int tnumber);
	public void travelUpdate(Travel travel);
	public void travelDelete(int tnumber);
}
