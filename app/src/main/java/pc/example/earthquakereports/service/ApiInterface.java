package pc.example.earthquakereports.service;

import pc.example.earthquakereports.pojo.BaseObject;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    String BASE_URL = "https://earthquake.usgs.gov/fdsnws/event/1/";
    @GET("query?format=geojson&limit=100")
    public Call<BaseObject> getData();
}
