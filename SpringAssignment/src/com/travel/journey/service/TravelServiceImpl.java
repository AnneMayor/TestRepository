package com.travel.journey.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.travel.journey.dao.TravelDao;
import com.travel.journey.dto.Travel;

@Component
public class TravelServiceImpl implements TravelService{

	@Autowired
	private TravelDao travelDao;
	@Override
	public void travelWrite(Travel travel) {
		travelDao.travelInsert(travel);
	}

	@Override
	public List<Travel> travelListPage(int pageNo, int rowsPerPage) {
		List<Travel> list = travelDao.travelSelectPage(pageNo, rowsPerPage);
		return list;
	}

	@Override
	public int travelTotalRows() {
		int count = travelDao.travelCountAll();
		return count;
	}

	@Override
	public Travel getTravel(int tnumber) {
		Travel travel = travelDao.travelSelectByTnumber(tnumber);
		return travel;
	}

	@Override
	public void travelUpdate(Travel travel) {
		travelDao.travelUpdate(travel);
	}

	@Override
	public void travelDelete(int tnumber) {
		travelDao.travelDelete(tnumber);
	}
}
