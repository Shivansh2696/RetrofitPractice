package com.example.retrofitpractice.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitpractice.R;
import com.example.retrofitpractice.Retrofit.Pojos.Users.UserResponsePojo;

import java.util.List;

public class RecyclerUserAdapter extends RecyclerView.Adapter<RecyclerUserAdapter.MyViewHolder> {
    final private Context context;
    final private List<UserResponsePojo> datalist;

    public RecyclerUserAdapter(Context context, List<UserResponsePojo> datalist) {
        this.context = context;
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.users_recycler_card,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.id.setText("ID :" + datalist.get(position).getId());
        holder.name.setText("Name :" + datalist.get(position).getName());
        holder.userName.setText("UserName :" + datalist.get(position).getUsername());
        holder.email.setText("Email :" + datalist.get(position).getEmail());
        holder.address.setText("Address :  Street : " + datalist.get(position).getAddress().getStreet() + "\n" + "Suite :" + datalist.get(position).getAddress().getSuite()
                                + "\n" + "City :" + datalist.get(position).getAddress().getCity() + "\n" + "ZipCode :" + datalist.get(position).getAddress().getZipcode()
                                + "\n" + "Geo :" + "(" + datalist.get(position).getAddress().getGeo().getLatitude() + ", " +  datalist.get(position).getAddress().getGeo().getLongitude() + ")");

        holder.phone.setText("Phone : " + datalist.get(position).getPhone());
        holder.website.setText("Website :" + datalist.get(position).getWebsite());
        holder.company.setText("Company : CompanyName :" + datalist.get(position).getCompany().getCompanyName() + "\n" + "CatchPhrase :" + datalist.get(position).getCompany().getCatchPhrase() + "\n"
                                + "Business :" + datalist.get(position).getCompany().getBs());
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id,name,userName,email,address,phone,website,company;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            id = (TextView) itemView.findViewById(R.id.UserIDUser);
            name = (TextView) itemView.findViewById(R.id.NameUser);
            userName = (TextView) itemView.findViewById(R.id.UserNameUser);
            email = (TextView) itemView.findViewById(R.id.UserEmailUser);
            address = (TextView) itemView.findViewById(R.id.UserAddressUser);
            phone = (TextView) itemView.findViewById(R.id.UserPhoneUser);
            website = (TextView) itemView.findViewById(R.id.UserWebsiteUser);
            company = (TextView) itemView.findViewById(R.id.UserCompanyUser);
        }
    }
}
