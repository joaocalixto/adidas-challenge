package com.example.itenerarysearch.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.itenerarysearch.domain.SearchResult;
import com.example.itenerarysearch.domain.webclient.City;
import com.example.itenerarysearch.domain.webclient.Connection;
import com.example.itenerarysearch.domain.webclient.FullCity;
import com.example.itenerarysearch.eureka.ServiceWebClient;

@Service
public class ItinerarySeachImpl implements IItinerartySeach {

	@Autowired
	ServiceWebClient serviveWebClient;

	private SearchResult ret;
	private List<SearchResult> listRet;
	
	@Override
	public List<SearchResult> listTravels(String from, String to, String sortBy) {
		ret = new SearchResult();
		listRet = new ArrayList<SearchResult>();
		
		buildItinerary(from, to, 0);
		
		if(sortBy == null) sortBy = "";

		switch (sortBy) {
		case "duration":
			Collections.sort(listRet, (s1, s2) -> { return  s1.getDuration() < s2.getDuration() ? -1 : 1;});
			break;
		case "connection":
			Collections.sort(listRet, (s1, s2) -> { return  s1.getCitiesVisited().size() < s2.getCitiesVisited().size() ? -1 : 1;});
			break;
		default:
			Collections.sort(listRet, (s1, s2) -> { return  sortByDurationAndConnections(s1,s2); });
			break;
			}

			return listRet;
		}

		private int sortByDurationAndConnections(SearchResult s1, SearchResult s2) {

			if(s1.getDuration() < s2.getDuration()) {
				return -1;
			}else if(s1.getDuration() == s2.getDuration()) {	
				if(s1.getCitiesVisited().size() < s2.getCitiesVisited().size()) {
					return -1;
				}
			}else {
				return 1;
			}
			return 0;
		}
		public void buildItinerary(String from, String to, double sum){

			ret.setDuration(ret.getDuration()+ sum);

			if(to.equals(from)) {
				ret.setRoutes(ret.getRoutes() + from);
				listRet.add(ret);
				stepBack(from, sum);
				return;
			}

			ret.setRoutes(ret.getRoutes() + from +" -> ");

			FullCity fullCity = serviveWebClient.getFullCity(from);

			if(fullCity != null) {
				List<Connection> connectionList = fullCity.getConn();

				for (Connection connection : connectionList) {

					double duration = connection.getDuration();
					City end = connection.getEnd();
					ret.getCitiesVisited().add(end.getName());

					buildItinerary(end.getName(), to, duration);
				}
				stepBack(from, sum);
			}


		}

		private void stepBack(String from, double sum) {
			String r = ret.getRoutes();
			r = r.replaceAll(from+"[ ->}]*", "");
			double dur = ret.getDuration()- sum;
			ret = new SearchResult();
			ret.setDuration(dur);
			ret.setRoutes(r);
		}
	}
