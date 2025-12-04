package com.dkhiruntsev.homework1.project1;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.ContentView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private int[] RGB = new int[3];
    private Button buttonPreview;
    private TextView colorRGBDisplayFormat;
    private String convertToColorString(int[] RGB){
        String colorString = "#";
        for(int item : RGB){
            if(item < 16){
                colorString += "0" + Integer.toHexString(item);
            } else {
                colorString += Integer.toHexString(item);
            }
        }
        return colorString;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        SeekBar seekBarRed = findViewById(R.id.seekBarRed);
        SeekBar seekBarGreen = findViewById(R.id.seekBarGreen);
        SeekBar seekBarBlue = findViewById(R.id.seekBarBlue);
        buttonPreview = findViewById(R.id.buttonPreview);
        colorRGBDisplayFormat = findViewById(R.id.colorDisplayRGBFormat);

        seekBarRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                RGB[0] = progress;
                colorRGBDisplayFormat.setText(Arrays.toString(RGB).replace("[", "").replace("]", ""));
                buttonPreview.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(convertToColorString(RGB))));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //empty
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //empty
            }
        });

        seekBarGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                RGB[1] = progress;
                colorRGBDisplayFormat.setText(Arrays.toString(RGB).replace("[", "").replace("]", ""));
                buttonPreview.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(convertToColorString(RGB))));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //empty
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //empty
            }
        });

        seekBarBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                RGB[2] = progress;
                colorRGBDisplayFormat.setText(Arrays.toString(RGB).replace("[", "").replace("]", ""));
                buttonPreview.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(convertToColorString(RGB))));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //empty
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //empty
            }
        });
    }
    public void apply(android.view.View view){
        setContentView(R.layout.result_screen);
        TextView colorDisplay = findViewById(R.id.colorDisplayRGBFormat);
        colorDisplay.setText(Arrays.toString(RGB).replace("[", "").replace("]", ""));
        ConstraintLayout currentLayout = (ConstraintLayout) findViewById(R.id.result_screen_id);
        currentLayout.setBackgroundColor((Color.rgb(RGB[0], RGB[1], RGB[2])));
    }

    public void exit() {
        finish();
    }
}