package com.luizmirel.loginuseradmin;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.luizmirel.loginuseradmin.UserModelClass;

import java.util.List;

public class UserAdapterClass extends RecyclerView.Adapter<UserAdapterClass.ViewHolder> {

    List<UserModelClass> employee;
    Context context;
    DatabaseHelperClass databaseHelperClass;

    public UserAdapterClass(List<UserModelClass> employee, Context context) {
        this.employee = employee;
        this.context = context;
        databaseHelperClass = new DatabaseHelperClass(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.user_item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final UserModelClass employeeModelClass = employee.get(position);

        holder.textViewID.setText(Integer.toString(employeeModelClass.getId()));
        holder.editText_Name.setText(employeeModelClass.getName());
        holder.editText_Email.setText(employeeModelClass.getEmail());
        holder.editText_Pass.setText(employeeModelClass.getPass());
        holder.editText_Username.setText(employeeModelClass.getUsername());
        holder.editText_Jk.setText(employeeModelClass.getJk());
        holder.editText_Ttl.setText(employeeModelClass.getTtl());
        holder.editText_Alamat.setText(employeeModelClass.getAlamat());
    }

    @Override
    public int getItemCount() {
        return employee.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewID;
        EditText editText_Name;
        EditText editText_Email;
        EditText editText_Pass;
        EditText editText_Username;
        EditText editText_Jk;
        EditText editText_Ttl;
        EditText editText_Alamat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewID = itemView.findViewById(R.id.text_id);
            editText_Name = itemView.findViewById(R.id.edittext_name);
            editText_Email = itemView.findViewById(R.id.edittext_email);
            editText_Pass = itemView.findViewById(R.id.edittext_pass);
            editText_Username = itemView.findViewById(R.id.edittext_username);
            editText_Jk = itemView.findViewById(R.id.edittext_jk);
            editText_Ttl = itemView.findViewById(R.id.edittext_ttl);
            editText_Alamat = itemView.findViewById(R.id.edittext_alamat);

        }
    }
}
