package pc.example.earthquakereports.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import pc.example.earthquakereports.R;
import pc.example.earthquakereports.pojo.featuresArrays.Features;

public class MainActivity extends AppCompatActivity {

    ViewModelEarth viewModelEarth ;
    private final static String LOG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModelEarth = new ViewModelEarth();
        viewModelEarth = ViewModelProviders.of(this).get(ViewModelEarth.class);
        viewModelEarth.setValueMutables();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        CustomAdapter customAdapter = new CustomAdapter();
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewModelEarth.mutableLiveData.observe(this,
                new Observer<ArrayList<Features>>() {
                    @Override
                    public void onChanged(ArrayList<Features> features) {
                       customAdapter.setmArrayList(features);
                    }
                });
    }
}
