package com.luizmirel.loginuseradmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.luizmirel.loginuseradmin.DatabaseHelperClass;
import com.luizmirel.loginuseradmin.EmployeeModelClass;
import com.luizmirel.loginuseradmin.R;
import com.luizmirel.loginuseradmin.ViewEmployeeActivity;

public class MainActivity extends AppCompatActivity {

    EditText editText_name,editText_email,editText_pass,editText_username,editText_Jk,editText_Ttl,editText_Alamat;
    Button button_add,button_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_name = findViewById(R.id.edittext_name);
        editText_email = findViewById(R.id.edittext_email);
        editText_pass = findViewById(R.id.edittext_pass);
        editText_username = findViewById(R.id.edittext_username);
        editText_Jk = findViewById(R.id.edittext_jk);
        editText_Ttl = findViewById(R.id.edittext_ttl);
        editText_Alamat = findViewById(R.id.edittext_alamat);
        button_add = findViewById(R.id.button_add);
        button_view = findViewById(R.id.button_view);


        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringName = editText_name.getText().toString();
                String stringEmail = editText_email.getText().toString();
                String stringPass = editText_pass.getText().toString();
                String stringUsername = editText_username.getText().toString();
                String stringJk = editText_Jk.getText().toString();
                String stringTtl = editText_Ttl.getText().toString();
                String stringAlamat = editText_Alamat.getText().toString();

                if (stringName.length() <=0 || stringEmail.length() <=0 || stringPass.length() <=0 || stringUsername.length() <=0 || stringJk.length() <=0 || stringTtl.length() <=0 || stringAlamat.length() <=0){
                    Toast.makeText(MainActivity.this, "Enter All Data", Toast.LENGTH_SHORT).show();
                }else {
                    DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(MainActivity.this);
                    EmployeeModelClass employeeModelClass = new EmployeeModelClass(stringName,stringEmail,stringPass,stringUsername,stringJk,stringTtl,stringAlamat);
                    databaseHelperClass.addEmployee(employeeModelClass);
                    Toast.makeText(MainActivity.this, "Add Employee Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }
            }
        });


        button_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewEmployeeActivity.class);
                startActivity(intent);
            }
        });


    }
}
