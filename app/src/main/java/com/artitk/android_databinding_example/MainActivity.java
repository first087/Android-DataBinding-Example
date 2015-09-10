package com.artitk.android_databinding_example;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.artitk.android_databinding_example.databinding.MainActivityBinding;

public class MainActivity extends AppCompatActivity {

    private Employee emp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // Sample Data
        emp = new Employee("Ethan Matthew M", 18, Employee.GenderEnum.MALE);

        binding.setEmp(emp);

        binding.btnAddAge1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emp.setAge(emp.getAge() + 1);
            }
        });

        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showEmployeeDialog();
            }
        });
    }

    private void showEmployeeDialog() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.employee)
                .setMessage(emp.toString())
                .create()
        .show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
