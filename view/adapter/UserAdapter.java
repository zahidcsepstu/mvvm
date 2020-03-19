package com.example.mvvm.view.adapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.mvvm.R;
import com.example.mvvm.model.UserRepo;


import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private List<UserRepo> users;
    public UserAdapter(List<UserRepo> repos) {
        users = repos;

    }


    @NonNull
    int ii;
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.user_list,viewGroup,false);
        Log.d("onCreate", ""+ii+++"");
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int i) {
        Log.d("onBind", ""+i+"");
        holder.name.setText(users.get(i).getLogin());
        holder.name.setText(users.get(i).getLogin());
        holder.id.setText(String.valueOf(users.get(i).getId()));
        holder.reposUrl.setText(users.get(i).getRepos_url());
        Glide.with(holder.avatarImg.getContext()).load(users.get(i).getAvatar_url()).into(holder.avatarImg);

    }

    @Override
    public int getItemCount() {
        if(users==null)
            return 0;
        return users.size();
    }


    public class UserViewHolder extends RecyclerView.ViewHolder {
        ImageView avatarImg;
        TextView name,id,reposUrl;


        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            avatarImg=itemView.findViewById(R.id.avatarImg);
            name= itemView.findViewById(R.id.login);
            id= itemView.findViewById(R.id.id);
            reposUrl= itemView.findViewById(R.id.reposUrl);

        }
    }
}
