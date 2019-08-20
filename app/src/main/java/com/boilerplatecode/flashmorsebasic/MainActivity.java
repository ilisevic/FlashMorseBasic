package com.boilerplatecode.flashmorsebasic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

 private    TextView textView;
     private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = findViewById(R.id.tvOutput);
        editText= findViewById(R.id.etInputAlpha);
        button = findViewById(R.id.btnTranslate);


          button.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {

                try {


                 textView.setText(MorseCode.alphaToMorse(  editText.getText().toString()))   ;
                }
                catch (Exception e)
                {
                    Toast.makeText(MainActivity.this
                            , "Pogrešan unos", Toast.LENGTH_LONG).show();

                }
              }
          });


    }
}
