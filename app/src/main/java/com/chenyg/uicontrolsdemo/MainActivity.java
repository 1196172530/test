package com.chenyg.uicontrolsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity {
    TextView display;
    Button btnLeft,btnRight,btnOk;
    Switch aSwitch;
    ProgressBar progressBar1,progressBar2;
    EditText editText;
    RadioGroup radioGroup;
    ImageView imageView;
    SeekBar seekBar;

    CheckBox checkBoxYW,checkBoxSX,checkBoxYY;
    RatingBar ratingBar;
    String yw = "";
    String sx = "";
    String yy = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.textTop);
        btnLeft = findViewById(R.id.button);
        btnRight = findViewById(R.id.button2);
        btnOk = findViewById(R.id.button3);
        aSwitch = findViewById(R.id.switch1);
        progressBar1 = findViewById(R.id.progressBar);
        progressBar2 = findViewById(R.id.progressBar2);
        editText = findViewById(R.id.editText);
        radioGroup = findViewById(R.id.radioGroup);
        imageView = findViewById(R.id.imageView);
        seekBar = findViewById(R.id.seekBar);
        checkBoxYW = findViewById(R.id.checkBox);
        checkBoxSX = findViewById(R.id.checkBox2);
        checkBoxYY = findViewById(R.id.checkBox3);
        ratingBar = findViewById(R.id.ratingBar);

        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(R.string.button1);
            }
        });

        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(R.string.button2);
            }
        });


        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    display.setText("开");
                }else{
                    display.setText("关");
                }
            }
        });





        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = editText.getText().toString();
                if(TextUtils.isEmpty(s)){
                    s ="0";
                }
                seekBar.setProgress(Integer.valueOf(s));
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                display.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                if(checkedId == R.id.radioButton){
                    imageView.setImageResource(R.mipmap.ic_launcher);
                }
                if(checkedId == R.id.radioButton2){
                    imageView.setImageResource(R.mipmap.ic_launcher_round);
                }

            }
        });

       checkBoxYW.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if(isChecked){
                   yw = "语文";
               }else{
                   yw = "";
               }
               display.setText(yw+sx+yy);
           }
       });

       checkBoxSX.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if(isChecked){
                   sx = "数学";
               }else{
                   sx = "";
               }
               display.setText(yw+sx+yy);
           }
       });

       checkBoxYY.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked){
                yy = "英语";
            }else{
                yy = "";
            }
            display.setText(yw+sx+yy);
        }
       });

       ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
           @Override
           public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
               Toast.makeText(getApplicationContext(),String.valueOf(rating)+"星评价",Toast.LENGTH_SHORT).show();
           }
       });


    }
}
