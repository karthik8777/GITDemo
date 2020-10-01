package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlaceApi;
import pojo.Location;

public class TestDataBuild {

	
	public AddPlaceApi addPlacePayLoad() {
		AddPlaceApi p = new AddPlaceApi();
		p.setAccuracy(50);
		p.setAddress("29, side layout, cohen 09");
		p.setName("Frontline house");
		p.setPhone_number("(+91) 983 893 3937");
		p.setWebsite("http://rahulshettyacademy.com/");
		p.setLanguage("French-IN");

		List<String> myList = new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		p.setTypes(myList);

		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		p.setLocation(l);
		
		return p;
	}
}
