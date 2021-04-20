package com.example.a108590031_hw6_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CheckBox ck1,ck2,ck3,ck4,ck5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ck1 = (CheckBox)findViewById(R.id.checkBox);
        ck2 = (CheckBox)findViewById(R.id.checkBox2);
        ck3 = (CheckBox)findViewById(R.id.checkBox3);
        ck4 = (CheckBox)findViewById(R.id.checkBox4);
        ck5 = (CheckBox)findViewById(R.id.checkBox5);
    }

    public void onSubmit(View view){
        String s="Topping: ";
        if(ck1.isChecked()==true){
            s = s + ck1.getText() + ' ';
        }
        if(ck2.isChecked()==true){
            s = s + ck2.getText() + ' ';
        }
        if(ck3.isChecked()==true){
            s = s + ck3.getText() + ' ';
        }
        if(ck4.isChecked()==true){
            s = s + ck4.getText() + ' ';
        }
        if(ck5.isChecked()==true) {
            s = s + ck5.getText() + ' ';
        }
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }
}