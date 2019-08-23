package com.hlub.dev.chatfirebasedemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hlub.dev.chatfirebasedemo.MessageActivity;
import com.hlub.dev.chatfirebasedemo.R;
import com.hlub.dev.chatfirebasedemo.model.User;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class FriendsAdapter extends BaseAdapter {
    Context context;
    private List<User> users;
    private boolean isChat;

    public FriendsAdapter(Context context, List<User> users,boolean isChat) {
        this.context = context;
        this.users = users;
        this.isChat = isChat;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.item_user, null);

        CircleImageView imgItemUser = (CircleImageView) convertView.findViewById(R.id.imgItemUser);
        TextView tvItemUser = (TextView) convertView.findViewById(R.id.tvItemUser);
        CircleImageView imgOn = (CircleImageView) convertView.findViewById(R.id.img_on);
        CircleImageView imgOff = (CircleImageView) convertView.findViewById(R.id.img_off);
        LinearLayout itemFriends = (LinearLayout) convertView.findViewById(R.id.itemFriends);


        //username
        tvItemUser.setText(users.get(position).getUsername());

        //status
        if (isChat) {
            if (users.get(position).getStatus().equals("online")) {
                imgOn.setVisibility(View.VISIBLE);
                imgOff.setVisibility(View.GONE);
            } else {
                imgOn.setVisibility(View.GONE);
                imgOff.setVisibility(View.VISIBLE);
            }
        } else {
            imgOn.setVisibility(View.GONE);
            imgOff.setVisibility(View.GONE);
        }

        //image
        if (users.get(position).getImageUrl().equals("default")) {
            imgItemUser.setImageResource(R.mipmap.ic_launcher);
        } else {
            Glide.with(context).load(users.get(position).getImageUrl()).into(imgItemUser);
        }

        //
        itemFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MessageActivity.class);
                intent.putExtra("userId", users.get(position).getId());
                context.startActivity(intent);
            }
        });
        return convertView;
    }
}
