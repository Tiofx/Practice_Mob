package com.example.st_pov.practice;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.st_pov.practice.activities.FeedbackAboutHotelActivity;
import com.example.st_pov.practice.models.Hotel;
import com.example.st_pov.practice.tabs.RoomFragment;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;

/**
 * Created by st_pov on 29.06.2017.
 */

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.MyViewHolder> implements View.OnClickListener {

    private HashMap<Integer, Integer> сrutch = new HashMap<>();
    private Context mContext;

    List<Hotel> hotelList;

    public HotelAdapter(List<Hotel> hotelList) {
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        public TextView titleHotel, address, numberReviews;
        public ImageView photoHotel;
        public RatingBar ratingStar;
        public CheckBox isBreakfast;
        public Button details, mark;


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

            details.setOnClickListener(HotelAdapter.this);
            mark.setOnClickListener(HotelAdapter.this);
        }

    }

    public HotelAdapter(Context mContext, List<Hotel> hotelList) {
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
        Hotel hotel = hotelList.get(position);
        holder.titleHotel.setText(hotel.getTitle());
        holder.address.setText(hotel.getAddress());
        holder.numberReviews.setText(hotel.getReviewsNumber() + " отзывов");
        holder.ratingStar.setNumStars((int) hotel.getStarRating());
        holder.isBreakfast.setEnabled(hotel.getHasBreakfast());

        сrutch.put(holder.mark.hashCode(), hotel.getId());
        // loading album cover using Picasso library
        Picasso.with(mContext).load(hotel.getPhoto()).into(holder.photoHotel);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.detail):
                Fragment fragment = new RoomFragment();
                FragmentTransaction transaction = fragment.getFragmentManager().beginTransaction();
                transaction.replace(R.id.items, fragment);
//                putExtra("hotel_id", сrutch.get(v.hashCode()));
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            case (R.id.mark):
                Intent intent = new Intent(mContext, FeedbackAboutHotelActivity.class);
                intent.putExtra("hotel_id", сrutch.get(v.hashCode()));
                mContext.startActivity(intent);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return hotelList.size();
    }
}