package com.example.calculating_machine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ChangduActivity extends AppCompatActivity {

    Spinner spinnerInput, spinnerOutput;
    String selected1 = "", selected2 = "";
    EditText editInput, editOutput;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changdu);

        spinnerInput = findViewById(R.id.ChangduInput);
        spinnerOutput = findViewById(R.id.ChangduOutput);
        editInput = findViewById(R.id.input);
        editOutput = findViewById(R.id.output);
        button = findViewById(R.id.submit);

        spinnerInput.setOnItemSelectedListener(new ChangduActivity.spinnerListener3());
        spinnerOutput.setOnItemSelectedListener(new ChangduActivity.spinnerListener4());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!editInput.getText().toString().equals("")){
                    editOutput.setText(getChangeResult(editInput.getText().toString()));
                    Toast.makeText(ChangduActivity.this,"正确",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(ChangduActivity.this,"错误",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private String getChangeResult(String str) {
        double temp = Double.parseDouble(str);
        if(selected1.equals("厘米")){
            temp = temp / 100;
            if(selected2.equals("厘米")){
                return temp * 100 + "";
            }
            else if(selected2.equals("米")){
                return temp + "";
            }
            else if(selected2.equals("分米")){
                return temp * 10 + "";
            }
            else if(selected2.equals("千米")){
                return temp * 0.001 + "";
            }
            else if(selected2.equals("毫米")){
                return temp * 1000 + "";
            }
            else{
                return "error";
            }
        }
        else if(selected1.equals("米")){
            temp = temp;
            if(selected2.equals("厘米")){
                return temp * 100 + "";
            }
            else if(selected2.equals("米")){
                return temp + "";
            }
            else if(selected2.equals("分米")){
                return temp * 10 + "";
            }
            else if(selected2.equals("千米")){
                return temp * 0.001 + "";
            }
            else if(selected2.equals("毫米")){
                return temp * 1000 + "";
            }
            else{
                return "error";
            }
        }
        else if(selected1.equals("千米")){
            temp = temp / 0.001;
            if(selected2.equals("厘米")){
                return temp * 100 + "";
            }
            else if(selected2.equals("米")){
                return temp + "";
            }
            else if(selected2.equals("分米")){
                return temp * 10 + "";
            }
            else if(selected2.equals("千米")){
                return temp * 0.001 + "";
            }
            else if(selected2.equals("毫米")){
                return temp * 1000 + "";
            }
            else{
                return "error";
            }
        }
        else if(selected1.equals("分米")){
            temp = temp / 10;
            if(selected2.equals("厘米")){
                return temp * 100 + "";
            }
            else if(selected2.equals("米")){
                return temp + "";
            }
            else if(selected2.equals("分米")){
                return temp * 10 + "";
            }
            else if(selected2.equals("千米")){
                return temp * 0.001 + "";
            }
            else if(selected2.equals("毫米")){
                return temp * 1000 + "";
            }
            else{
                return "error";
            }
        }
        else if(selected1.equals("毫米")){
            temp = temp / 1000;
            if(selected2.equals("厘米")){
                return temp * 100 + "";
            }
            else if(selected2.equals("米")){
                return temp + "";
            }
            else if(selected2.equals("分米")){
                return temp * 10 + "";
            }
            else if(selected2.equals("千米")){
                return temp * 0.001 + "";
            }
            else if(selected2.equals("毫米")){
                return temp * 1000 + "";
            }
            else{
                return "error";
            }
        }
        else{
            return "error";
        }
    }

    private class spinnerListener3 implements android.widget.AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> adapterView,
                                   View view, int i, long l) {
            selected1 = adapterView.getItemAtPosition(i).toString();
            Toast.makeText(ChangduActivity.this,selected1,Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
            System.out.println("nothingSelect");
        }
    }

    private class spinnerListener4 implements android.widget.AdapterView.OnItemSelectedListener  {

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            selected2 = adapterView.getItemAtPosition(i).toString();
            Toast.makeText(ChangduActivity.this,selected2,Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
            System.out.println("nothingSelect");
        }
    }
}