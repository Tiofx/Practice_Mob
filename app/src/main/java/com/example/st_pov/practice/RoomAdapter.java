package com.example.st_pov.practice;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.st_pov.practice.models.ItemRoom;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by st_pov on 29.06.2017.
 */

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.MyViewHolder> {

    private Context mContext;
    private List<ItemRoom> roomList;
//    private static MyClickListener myClickListener;
    public RoomAdapter(List<ItemRoom> hotelList) {
    }


    public class MyViewHolder extends RecyclerView.ViewHolder
//            implements View.OnClickListener
    {
        public TextView titleRoom, price, people;
        public ImageView photoRoom;

        public MyViewHolder(View view) {
            super(view);
            titleRoom = view.findViewById(R.id.titleRoom);
            price = view.findViewById(R.id.price);
            people = view.findViewById(R.id.numberPeople);
            photoRoom = view.findViewById(R.id.photoRoom);
        }

//        @Override
//        public void onClick(View view) {
//            myClickListener.onItemClick(getAdapterPosition(), view);
//        }
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

        Picasso.with(mContext).load(room.getPhotoRoom()).into(holder.photoRoom);

    }

//    public void setOnItemClickListener(MyClickListener myClickListener) {
//        this.myClickListener = myClickListener;
//    }


    @Override
    public int getItemCount() {
        return roomList.size();
    }

//    public interface MyClickListener {
//        void onItemClick(int position, View v);
//    }
}