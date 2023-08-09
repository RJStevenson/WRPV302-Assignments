package com.wrpv302.a1.assignment1task2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import MVC.MainController;

public class MainActivity extends AppCompatActivity {
MainController Control = null;
public Button[][] buts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      View MainView = this.findViewById(R.id.btn00).getRootView();



       buts =  new Button[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String btnid = "btn"+Integer.toString(i) + Integer.toString(j);
                //int id= getResources().getIdentifier(btnid, "id", getPackageName());
                 int id= getResources().getIdentifier(btnid, "id", getPackageName());
                buts[i][j] = findViewById(id);
                buts[i][j].setText(" ");
            }
        }
        Control = new MainController(MainView, this);
    }



}