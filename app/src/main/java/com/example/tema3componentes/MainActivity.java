package com.example.tema3componentes;

import android.app.ActionBar;
import android.icu.text.ListFormatter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.Console;

public class MainActivity extends AppCompatActivity {
    Button btn;
    ToggleButton tb;
    CheckBox cb;
    SeekBar sb;
    TextView txv;

    RadioButton rb1;
    RadioButton rb2;

    Switch sw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //Incializo variables
        btn = findViewById(R.id.button);
        tb = findViewById(R.id.toggleButton);
        cb = findViewById(R.id.checkBox3);
        sb = findViewById(R.id.seekBar);
        txv = findViewById(R.id.textView4);
        sw = findViewById(R.id.switch1);
        rb1 = findViewById(R.id.radioButton);
        rb2 = findViewById(R.id.radioButton2);

        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cb.setChecked(tb.isChecked());
            }
        });

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txv.setText(sb.getProgress() + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    sw.setText("Activado");
                } else {
                    sw.setText("Desactivado");
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tb.setChecked(false);
                rb1.setChecked(false);
                rb2.setChecked(false);
            }
        });

         /*Al pulsar el botón superior el valor se
        reinicien los valores de los elementos: el
        toogle button, los checkboxes, los radio
        button y el switch pasen a estar no
        marcados.

        El seekbar pase a tener un
        valor de 0. El rating bar pase a tener 0
        estrellas seleccionadas y se borre el
        texto que pueda tener el editText.
·       Al pulsar el botón con imagen el texto
        adyacente se sustituye por un contador
        cuyo valor se incrementa cada vez que
        se pulsa el botón.
·       Si el segundo checkbox está marcado al
        pulsar el botón el valor del contador decrece.
·       Al pulsar un RadioButton se muestre un Toast informando del
        RadioButton pulsado*/
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}