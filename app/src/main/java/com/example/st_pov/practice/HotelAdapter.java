package com.example.st_pov.practice;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.st_pov.practice.models.ItemHotel;
import com.example.st_pov.practice.tabs.RoomFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by st_pov on 29.06.2017.
 */

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.MyViewHolder> implements View.OnClickListener {

    private Context mContext;
    List<ItemHotel> hotelList;

    public HotelAdapter(List<ItemHotel> hotelList) {
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case(R.id.detail):
                Fragment fragment=new RoomFragment();
                FragmentManager manager = ((AppCompatActivity)mContext).getSupportFragmentManager();
                FragmentTransaction transaction=manager.beginTransaction();
                transaction.replace(R.id.itemsHotels, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            case (R.id.mark):
                break;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        public TextView titleHotel, address, numberReviews;
        public ImageView photoHotel;
        public RatingBar ratingStar;
        public CheckBox isBreakfast;
        public Button details, mark;
        private ItemClickListener clickListener;


        public MyViewHolder(View view) {
            super(view);
            titleHotel = view.findViewById(R.id.titleHotel);
            address = view.findViewById(R.id.addressHotel);
            numberReviews = view.findViewById(R.id.numberHotelReviews);
            ratingStar = view.findViewById(R.id.ratingStarHotel);
            isBreakfast = view.findViewById(R.id.isBreakfast);
            photoHotel = view.findViewById(R.id.photoHotel);
            details = view.findViewById(R.id.detail);
            mark = view.findViewById(R.id.mark);
            details.setOnClickListener(this);
            mark.setOnClickListener(this);

        }
        public void setClickListener(ItemClickListener itemClickListener) {
            this.clickListener = itemClickListener;
        }
        @Override
        public void onClick(View view) {
            clickListener.onClick(view);
        }

    }

    public HotelAdapter(Context mContext, List<ItemHotel> hotelList) {
        this.mContext = mContext;
        this.hotelList = hotelList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_hotel, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        ItemHotel hotel = hotelList.get(position);
        holder.titleHotel.setText(hotel.getName());
        holder.address.setText(hotel.getAddress());
        holder.numberReviews.setText(hotel.getNumberReviews() + " отзывов");
        holder.ratingStar.setNumStars((int) hotel.getNumberStars());
        holder.isBreakfast.setEnabled(hotel.isBreakfast());
        Picasso.with(mContext).load(hotel.getPhotoHotel()).into(holder.photoHotel);
        holder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case(R.id.detail):
                        Fragment fragment=new RoomFragment();
                        FragmentManager manager = ((AppCompatActivity)mContext).getSupportFragmentManager();
                        FragmentTransaction transaction=manager.beginTransaction();
                        transaction.replace(R.id.itemsHotels, fragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
                        break;
                    case (R.id.mark):
                        break;
                }

            }
        });

    }



    @Override
    public int getItemCount() {
        return hotelList.size();
    }
    public interface OnItemClickListener {
        public void onClick(View view, int position);
    }

}