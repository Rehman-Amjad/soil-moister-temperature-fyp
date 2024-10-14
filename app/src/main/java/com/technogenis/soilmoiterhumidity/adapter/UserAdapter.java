package com.technogenis.soilmoiterhumidity.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.technogenis.soilmoiterhumidity.R;
import com.technogenis.soilmoiterhumidity.model.User;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder>{

    private Context context;
    private List<User> mDatalist;

    public UserAdapter(Context context, List<User> mDatalist) {
        this.context = context;
        this.mDatalist = mDatalist;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myview= LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);


        return new MyViewHolder(myview);

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        User user=mDatalist.get(position);


        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] imageBytes = baos.toByteArray();
        imageBytes = Base64.decode(user.getImg(), Base64.DEFAULT);
        Bitmap decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);

        holder.imageView.setImageBitmap(decodedImage);

        holder.tvId.setText("ID: "+user.getId());
        holder.tvMoisture.setText("Moisture: "+user.getMoistures() +" C");
        holder.tv_humidity.setText("Humidity: "+user.getAirHumidity() +" %");
        holder.tv_air.setText("Air Temperature: "+user.getAirTemps() +" C");
        holder.tv_soil.setText("Soil Temperature: "+user.getSoilTemps() +" C");
        holder.tv_date.setText("Date/Time: "+user.getDatedTime());

        holder.tv_soilNitro.setText("Soil Nitrogen: "+user.getSoilNitrogen());
        holder.tv_soilPot.setText("Soil Potassium: "+user.getSoilPotassium());
        holder.tv_soilPhos.setText("Soil Phosphorous: "+user.getSoilPhosphorous());


    }

    @Override
    public int getItemCount() {
        return mDatalist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvId,tvMoisture,tv_humidity,tv_air,tv_soil,tv_date,tv_soilNitro,tv_soilPhos,tv_soilPot;
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.card_image);
            tvId=itemView.findViewById(R.id.tvId);
            tvMoisture=itemView.findViewById(R.id.tvMoisture);
            tv_humidity=itemView.findViewById(R.id.tv_humidity);
            tv_air=itemView.findViewById(R.id.tv_air);
            tv_soil=itemView.findViewById(R.id.tv_soil);
            tv_date=itemView.findViewById(R.id.tv_date);
            tv_soilNitro=itemView.findViewById(R.id.tv_soilNitro);
            tv_soilPhos=itemView.findViewById(R.id.tv_soilPhos);
            tv_soilPot=itemView.findViewById(R.id.tv_soilPot);




        }
    }
}




