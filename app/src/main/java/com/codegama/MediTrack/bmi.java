package com.codegama.MediTrack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class bmi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        EditText weight,height;
        TextView txtres,txtinter;
        Button btnn;

        weight=(EditText) findViewById(R.id.weight);
        height=(EditText) findViewById(R.id.height);

        txtinter=(TextView) findViewById(R.id.txtinter);
        txtres=(TextView) findViewById(R.id.txtres);

        btnn=(Button) findViewById(R.id.btnn);

        btnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strweight = weight.getText().toString();
                String strheight = height.getText().toString();

                if(strweight.equals("")){
                    weight.setError("Please Enter your Weight");
                    weight.requestFocus();
                    return;

                }
                if(strheight.equals("")){
                    height.setError("Please Enter your Height");
                    height.requestFocus();
                    return;
                }
                float wei = Float.parseFloat(strweight)/100;
                float hei = Float.parseFloat(strheight)/100;

                float bmivalue = BmIcalculate(wei,hei);

                txtinter.setText(interpreterBMI(bmivalue));
                txtres.setText("BMI="+bmivalue);

            }
        });

    }
    public float BmIcalculate(float weight,float height){
        return weight / (height*height);

    }
    public String interpreterBMI(float bmiValue){
        if(bmiValue<16){
            return "Servely Underweight";
        }
        else if (bmiValue<18.5){
            return "Underweight";
        }
        else if(bmiValue<25){
            return "Normal";
        }
        else if(bmiValue<30){
            return "OverWeight";
        }
        else
            return "Obese";



    }


}