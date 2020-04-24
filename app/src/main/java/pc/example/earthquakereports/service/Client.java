package pc.example.earthquakereports.service;

import pc.example.earthquakereports.pojo.BaseObject;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {

    private static Client Instance ;
    private ApiInterface apiInterface ;

    public Client() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiInterface = retrofit.create(ApiInterface.class);
    }


    public static Client getInstance() {

        if (Instance == null){
            Instance = new Client();
        }
        return Instance;
    }

    public Call<BaseObject> getData(){
        return apiInterface.getData();
    }
}
