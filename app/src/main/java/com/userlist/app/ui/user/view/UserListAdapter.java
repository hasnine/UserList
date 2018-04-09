package com.userlist.app.ui.user.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;
import com.userlist.app.R;
import com.userlist.app.ui.user.model.User;
import com.userlist.app.ui.user.model.Users;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by has9 on 4/9/18.
 */

public class UserListAdapter  extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {

    private List<User>mUserList;
    Context mContext;

    public UserListAdapter(List<User> mUserList, Context mContext) {
        this.mUserList = mUserList;
        this.mContext = mContext;
    }

    @Override
    public UserListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);
        return new UserListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserListAdapter.ViewHolder holder, int position) {

        holder.tvUserName.setText(mUserList.get(position).firstName + " " + mUserList.get(position).getLastName());
        holder.tvUserMobile.setText(mUserList.get(position).getPhones().getMobile());
        if (mUserList.get(position).getGender().equals("male")){

            Glide.with(mContext)
                    .load("https://randomuser.me/api/portraits/men/"+mUserList.get(position).getPhoto()+".jpg")
                    .into(holder.ivCircle);
        } else {
            Glide.with(mContext)
                    .load("https://randomuser.me/api/portraits/women/"+mUserList.get(position).getPhoto()+".jpg")
                    .into(holder.ivCircle);
        }


    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvUserName)
        TextView tvUserName;

        @BindView(R.id.tvUserMobile)
        TextView tvUserMobile;

        @BindView(R.id.ivCircle)
        CircleImageView ivCircle;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
