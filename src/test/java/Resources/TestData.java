package Resources;

import pojo.AddPlace;
import pojo.Location;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestData {
    public AddPlace addplacepayload(String name,String Address,String Languge)

    {

        AddPlace ap = new AddPlace();

        ap.setAccuracy(50);

        ap.setAddress(Address);

        ap.setLanguage(Languge);

        ap.setName(name);

        ap.setPhone_number("+919838933937");

        ap.setWebsite("https://rahulshettyacademy.com");

        List<String> myList = new ArrayList<String>();

        myList.add("shoe park");

        myList.add("shop");

        ap.setTypes(myList);

        Location loc = new Location();

        loc.setLat(-35.383494);
       loc.setLng(-39.427362);
        ap.setLocation(loc);
        return ap;

    }
}
