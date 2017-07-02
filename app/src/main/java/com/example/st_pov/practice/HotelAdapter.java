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

import com.example.st_pov.practice.models.ItemHotel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by st_pov on 29.06.2017.
 */

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.MyViewHolder> {

    private Context mContext;
    private static MyClickListener myClickListener;
    final List<ItemHotel> hotelList;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        public TextView titleHotel, address, numberReviews;
        public ImageView photoHotel;
        public RatingBar ratingStar;
        public CheckBox isBreakfast;


        public MyViewHolder(View view) {
            super(view);
            titleHotel = view.findViewById(R.id.titleHotel);
            address = view.findViewById(R.id.addressHotel);
            numberReviews = view.findViewById(R.id.numberHotelReviews);
            ratingStar = view.findViewById(R.id.ratingStarHotel);
            isBreakfast = view.findViewById(R.id.isBreakfast);
            photoHotel = view.findViewById(R.id.photoHotel);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getAdapterPosition(), v);
        }
    }

    public HotelAdapter(Context mContext, List<ItemHotel> hotelList) {
        this.mContext = mContext;
        this.hotelList = hotelList;
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
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

        // loading album cover using Picasso library
        Picasso.with(mContext).load(hotel.getPhotoHotel()).into(holder.photoHotel);

    }


    @Override
    public int getItemCount() {
        return hotelList.size();
    }

    public interface MyClickListener {
        void onItemClick(int position, View v);
    }
}