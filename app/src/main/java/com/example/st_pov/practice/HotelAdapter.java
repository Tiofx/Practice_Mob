package com.example.st_pov.practice;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.st_pov.practice.Models.ItemHotel;

import java.util.List;

/**
 * Created by st_pov on 29.06.2017.
 */

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.MyViewHolder> {

    private Context mContext;
    private List<ItemHotel> hotelList;
    private static MyClickListener myClickListener;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView titleHotel, address, numberReviews;
        public ImageView photoHotel;
        public RatingBar ratingStar;
        public CheckBox isBreakfast;

        public MyViewHolder(View view) {
            super(view);
            titleHotel = (TextView) view.findViewById(R.id.title);
            address = (TextView) view.findViewById(R.id.addressHotel);
            numberReviews = (TextView) view.findViewById(R.id.numberHotelReviews);
            ratingStar = (RatingBar) view.findViewById(R.id.ratingStarHotel);
            isBreakfast = (CheckBox) view.findViewById(R.id.isBreakfast);
            photoHotel = (ImageView) view.findViewById(R.id.photoHotel);
        }

        @Override
        public void onClick(View view) {

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

        // loading album cover using Glide library
        Glide.with(mContext).load(hotel.getPhotoHotel()).into(holder.photoHotel);

    }


    @Override
    public int getItemCount() {
        return hotelList.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }
}