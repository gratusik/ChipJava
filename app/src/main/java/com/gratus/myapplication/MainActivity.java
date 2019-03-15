package com.gratus.myapplication;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;



import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


public class MainActivity extends AppCompatActivity {

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ChipGroup chipGroup = findViewById(R.id.chipGroup);
        Chip chip = null;
        List<Integer> colorCollection = new ArrayList<Integer>();
        colorCollection.add(R.color.colorPrimary);
        colorCollection.add(R.color.colorPrimaryDark);
        colorCollection.add(R.color.colorAccent);
        int j=0;
        for (int i = 0; i < 5; i++) {
            chip = new Chip(MainActivity.this);
            chip.setText("Chip No : " + i);
            chip.setCheckable(true);
            chip.setChipBackgroundColorResource(colorCollection.get(j));
            if (j == 2) {
                j=0;
            }
            else{
                j++;
            }


            chipGroup.addView(chip);
            chipGroup.setSingleSelection(true);
            chip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if(b==true)

                    Toast.makeText(getApplicationContext(),  compoundButton.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }

}
}