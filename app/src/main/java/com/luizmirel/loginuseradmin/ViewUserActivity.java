package com.luizmirel.loginuseradmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.luizmirel.loginuseradmin.UserModelClass;

import java.util.List;

public class ViewUserActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_user);

        recyclerView = findViewById(R.id.recyclerView2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(this);
        List<UserModelClass> UserModelClass = databaseHelperClass.getUserList();

        if (UserModelClass.size() > 0){
            UserAdapterClass useradapterclass = new UserAdapterClass(UserModelClass,ViewUserActivity.this);
            recyclerView.setAdapter(useradapterclass);
        }else {
            Toast.makeText(this, "There is no employee in the database", Toast.LENGTH_SHORT).show();
        }

    }
}
