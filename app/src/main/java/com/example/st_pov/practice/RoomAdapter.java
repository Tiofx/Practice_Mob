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
import com.example.st_pov.practice.Models.ItemRoom;

import java.util.List;

/**
 * Created by st_pov on 29.06.2017.
 */

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.MyViewHolder> {

    private Context mContext;
    private List<ItemRoom> roomList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView titleRoom, price, people;
        public ImageView photoRoom;

        public MyViewHolder(View view) {
            super(view);
            titleRoom = (TextView) view.findViewById(R.id.titleRoom);
            price = (TextView) view.findViewById(R.id.price);
            people = (TextView) view.findViewById(R.id.numberPeople);
            photoRoom = (ImageView) view.findViewById(R.id.photoRoom);
        }
    }


    public RoomAdapter(Context mContext, List<ItemRoom> roomList) {
        this.mContext = mContext;
        this.roomList = roomList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_room, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        ItemRoom room = roomList.get(position);
        holder.titleRoom.setText(room.getName());
        holder.price.setText(String.valueOf(room.getPrice()));
        holder.people.setText(String.valueOf(room.getPeople()));

        // loading album cover using Glide library
        Glide.with(mContext).load(room.getPhotoRoom()).into(holder.photoRoom);

    }


    @Override
    public int getItemCount() {
        return roomList.size();
    }
}