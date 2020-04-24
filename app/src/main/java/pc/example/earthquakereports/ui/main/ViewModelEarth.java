package pc.example.earthquakereports.ui.main;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import pc.example.earthquakereports.pojo.BaseObject;
import pc.example.earthquakereports.pojo.featuresArrays.Features;
import pc.example.earthquakereports.service.Client;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModelEarth extends ViewModel {

    private final static String LOG_CAT = ViewModelEarth.class.getSimpleName();
    MutableLiveData<ArrayList<Features>> mutableLiveData = new MutableLiveData<>();

    public void setValueMutables(){
        Client.getInstance().getData().enqueue(new Callback<BaseObject>() {
            @Override
            public void onResponse(Call<BaseObject> call, Response<BaseObject> response) {
                ArrayList<Features> arrayList = response.body().getFeatures();
                mutableLiveData.setValue(arrayList);
            }

            @Override
            public void onFailure(Call<BaseObject> call, Throwable t) {
                Log.i(LOG_CAT,"onFailure: " +t.getMessage());
            }
        });
    }
}
