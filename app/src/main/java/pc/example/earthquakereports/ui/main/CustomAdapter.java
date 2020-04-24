package pc.example.earthquakereports.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import pc.example.earthquakereports.R;
import pc.example.earthquakereports.pojo.featuresArrays.Features;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private ArrayList<Features> mArrayList = new ArrayList<>();

    public void setmArrayList(ArrayList<Features> mArrayList) {
        this.mArrayList = mArrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        // TODO mag
        String mag = String.valueOf(mArrayList.get(position).getProperties().getMag());
        holder.mMag.setText(mag);

        // TODO place
        String place = mArrayList.get(position).getProperties().getPlace();
        holder.mPlace.setText(place);

        // TODO date
        long getTime = mArrayList.get(position).getProperties().getTime();
        Date date = new Date(getTime);
        String FormatDate = formatDate(date);
        holder.mDate.setText(FormatDate );
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    public class CustomViewHolder  extends RecyclerView.ViewHolder {
        private TextView mMag ;
        private TextView mPlace ;
        private TextView mDate ;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            mMag = itemView.findViewById(R.id.mag);
            mPlace = itemView.findViewById(R.id.place);
            mDate = itemView.findViewById(R.id.date);
        }
    }

    private String formatDate (Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }

    private String formatTime (Date time){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("h:mm a");
        return simpleDateFormat.format(time);
    }
}
