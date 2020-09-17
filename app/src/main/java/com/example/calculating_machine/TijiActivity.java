package com.example.calculating_machine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class TijiActivity extends AppCompatActivity {

    Spinner spinnerInput, spinnerOutput;
    String selected1 = "", selected2 = "";
    EditText editInput, editOutput;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiji);

        spinnerInput = findViewById(R.id.TijiInput);
        spinnerOutput = findViewById(R.id.TijiOutput);
        editInput = findViewById(R.id.input);
        editOutput = findViewById(R.id.output);
        button = findViewById(R.id.submit);

        spinnerInput.setOnItemSelectedListener(new TijiActivity.spinnerListener5());
        spinnerOutput.setOnItemSelectedListener(new TijiActivity.spinnerListener6());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!editInput.getText().toString().equals("")){
                    editOutput.setText(getChangeResult(editInput.getText().toString()));
                    Toast.makeText(TijiActivity.this,"正确",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(TijiActivity.this,"错误",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private String getChangeResult(String str) {
        double temp = Double.parseDouble(str);
        if(selected1.equals("立方厘米")){
            temp = temp / 1000000;
            if(selected2.equals("立方厘米")){
                return temp * 1000000 + "";
            }
            else if(selected2.equals("立方米")){
                return temp + "";
            }
            else if(selected2.equals("立方分米")){
                return temp * 1000 + "";
            }
            else if(selected2.equals("立方毫米")){
                return temp * 1000000000 + "";
            }
            else{
                return "error";
            }
        }
        else if(selected1.equals("立方米")){
            temp = temp;
            if(selected2.equals("立方厘米")){
                return temp * 1000000 + "";
            }
            else if(selected2.equals("立方米")){
                return temp + "";
            }
            else if(selected2.equals("立方分米")){
                return temp * 1000 + "";
            }
            else if(selected2.equals("立方毫米")){
                return temp * 1000000000 + "";
            }
            else{
                return "error";
            }
        }
        else if(selected1.equals("立方分米")){
            temp = temp / 1000;
            if(selected2.equals("立方厘米")){
                return temp * 1000000 + "";
            }
            else if(selected2.equals("立方米")){
                return temp + "";
            }
            else if(selected2.equals("立方分米")){
                return temp * 1000 + "";
            }
            else if(selected2.equals("立方毫米")){
                return temp * 1000000000 + "";
            }
            else{
                return "error";
            }
        }
        else if(selected1.equals("立方毫米")){
            temp = temp / 1000000000;
            if(selected2.equals("立方厘米")){
                return temp * 1000000 + "";
            }
            else if(selected2.equals("立方米")){
                return temp + "";
            }
            else if(selected2.equals("立方分米")){
                return temp * 1000 + "";
            }
            else if(selected2.equals("立方毫米")){
                return temp * 1000000000 + "";
            }
            else{
                return "error";
            }
        }
        else{
            return "error";
        }
    }

    private class spinnerListener5 implements android.widget.AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> adapterView,
                                   View view, int i, long l) {
            selected1 = adapterView.getItemAtPosition(i).toString();
            Toast.makeText(TijiActivity.this,selected1,Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
            System.out.println("nothingSelect");
        }
    }

    private class spinnerListener6 implements android.widget.AdapterView.OnItemSelectedListener  {

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            selected2 = adapterView.getItemAtPosition(i).toString();
            Toast.makeText(TijiActivity.this,selected2,Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
            System.out.println("nothingSelect");
        }
    }
}