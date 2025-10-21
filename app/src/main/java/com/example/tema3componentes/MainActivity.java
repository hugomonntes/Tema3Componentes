package com.example.tema3componentes;

import android.content.Intent;
import android.hardware.biometrics.PromptContentItemPlainText;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText ett;
    Button btt;
    Button btt2;
    ImageButton ibtt;
    ToggleButton tb;
    CheckBox ch1;
    CheckBox ch2;
    CheckBox ch3;
    SeekBar sb;
    RatingBar rt;
    TextView tv;
    TextView tv2;
    Switch sw;

    RadioButton rb1;
    RadioButton rb2;
    Toolbar toolbar;
    MenuItem nuevo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tb=findViewById(R.id.toggleButton);
        ch1=findViewById(R.id.checkBox);
        ch2=findViewById(R.id.checkBox2);
        ch3=findViewById(R.id.checkBox3);
        sb=findViewById(R.id.seekBar);
        tv=findViewById(R.id.textView4);
        tv2=findViewById(R.id.textView2);
        sw=findViewById(R.id.switch1);
        btt=findViewById(R.id.button);
        btt2=findViewById(R.id.button2);
        rt=findViewById(R.id.ratingBar);
        ett=findViewById(R.id.editTextText);
        ibtt=findViewById(R.id.imageButton);
        rb1=findViewById(R.id.radioButton);
        rb2=findViewById(R.id.radioButton2);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);
        nuevo = findViewById(R.id.nuevo);
        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ch1.setChecked(tb.isChecked());
                ch3.setEnabled(tb.isChecked());
            }
        });
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv.setText(sb.getProgress()+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sw.isChecked()){
                    sw.setText("activo");
                }else{
                    sw.setText("desactivo");
                }
            }
        });

        btt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    tb.setChecked(false);
                    ch1.setChecked(false);
                    ch2.setChecked(false);
                    ch3.setChecked(false);
                    rb1.setChecked(false);
                    rb2.setChecked(false);
                    tv2.setText("");
                if (sb.getProgress()!=0){
                    sb.setProgress(0);
                }
                if(rt.getProgress()!=0){
                    rt.setProgress(0);
                }
                if(!ett.getText().equals("")){
                    ett.setText("");
                }
                btt2.setText("Button");

                if (actionBar.isShowing()){
                    actionBar.hide();
                } else {
                    actionBar.show();
                }
            }
        });

        ibtt.setOnClickListener(new View.OnClickListener() {
            int contador=0;

            @Override
            public void onClick(View v) {
                if (ch2.isChecked()){
                    contador--;
                    tv2.setText(contador+"");
                }else{
                    contador++;
                    tv2.setText(contador+"");
                }

                ActivityResultLauncher<Intent> launcher = registerForActivityResult(new
                        ActivityResultContracts.StartActivityForResult(),new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {

                    }
                });

                Intent throwActivity = new Intent(MainActivity.this, Secundaria.class);
                throwActivity.putExtra("Rating", rt.getRating());
                startActivity(throwActivity);
                rt.setRating(throwActivity.getFloatExtra("Rating", 3));
            }
        });

        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "radioButton 1", Toast.LENGTH_SHORT).show();
            }
        });

        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "radioButton 2", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menuprincipal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if (id==R.id.nuevo){
            if (ch1.isChecked()){
                Log.i("Ch1 is checked", "Ch1 is checked");
            } else if (ch2.isChecked()){
                Log.i("Ch2 is checked", "Ch2 is checked");
            }  else if (ch3.isChecked()){
                Log.i("Ch3 is checked", "Ch3 is checked");
            }
            Toast.makeText(this, "Nuevo", Toast.LENGTH_SHORT).show();
            return true;
        }else if (id==R.id.editar){
            Toast.makeText(this, "Editar", Toast.LENGTH_SHORT).show();
            return true;
        }else if (id==R.id.borrar){
            Toast.makeText(this, "Borrar", Toast.LENGTH_SHORT).show();
            return true;
        }else if (id==R.id.sub){
            Toast.makeText(this, "Sub", Toast.LENGTH_SHORT).show();
            return true;
        }else if(id == android.R.id.home){
            onBackPressed();
            return true;
        };
        return super.onOptionsItemSelected(item);
    }

}