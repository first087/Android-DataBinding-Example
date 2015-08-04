package com.artitk.android_databinding_example;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Employee emp;

    private TextView lblFullName;
    private EditText txtAge;
    private RadioButton rdoUnknown, rdoMale, rdoFemale;
    private Button btnAddAge1, btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Sample Data
        emp = new Employee("Ethan Matthew M", 18, Employee.GenderEnum.UNKNOWN);

        lblFullName = (TextView) findViewById(R.id.lbl_fullname);
        txtAge      = (EditText) findViewById(R.id.txt_age);
        rdoUnknown  = (RadioButton) findViewById(R.id.rdo_unknown);
        rdoMale     = (RadioButton) findViewById(R.id.rdo_male);
        rdoFemale   = (RadioButton) findViewById(R.id.rdo_female);
        btnAddAge1  = (Button) findViewById(R.id.btn_add_age1);
        btnSave     = (Button) findViewById(R.id.btn_save);

        lblFullName.setText(emp.getName());
        txtAge.setText(String.valueOf(emp.getAge()));

        switch (emp.getGender()) {
            case UNKNOWN:   rdoUnknown.setChecked(true);    break;
            case MALE:      rdoMale.setChecked(true);       break;
            case FEMALE:    rdoFemale.setChecked(true);     break;
        }

        txtAge.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                emp.setAge(s.length() > 0 ? Integer.parseInt(s.toString()) : 0);
            }
        });

        btnAddAge1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emp.setAge(emp.getAge() + 1);
                txtAge.setText(String.valueOf(emp.getAge()));
            }
        });

        rdoUnknown.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) emp.setGender(Employee.GenderEnum.UNKNOWN);
            }
        });

        rdoMale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) emp.setGender(Employee.GenderEnum.MALE);
            }
        });

        rdoFemale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) emp.setGender(Employee.GenderEnum.FEMALE);
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
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
