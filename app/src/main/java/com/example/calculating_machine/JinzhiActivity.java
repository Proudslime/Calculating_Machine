package com.example.calculating_machine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class JinzhiActivity extends AppCompatActivity {

    Spinner spinnerInput, spinnerOutput;
    String selected1 = "", selected2 = "";
    EditText editInput, editOutput;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jinzhi);

        spinnerInput = findViewById(R.id.jinzhiInput);
        spinnerOutput = findViewById(R.id.jinzhiOutput);
        editInput = findViewById(R.id.input);
        editOutput = findViewById(R.id.output);
        button = findViewById(R.id.submit);

        spinnerInput.setOnItemSelectedListener(new spinnerListener1());
        spinnerOutput.setOnItemSelectedListener(new spinnerListener2());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!editInput.getText().toString().equals("")){
                    editOutput.setText(getChangeResult(editInput.getText().toString()));
                    Toast.makeText(JinzhiActivity.this,"正确",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(JinzhiActivity.this,"错误",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private String getChangeResult(String str) {
        int temp;
        if(selected1.equals("二进制")){
            temp = Integer.parseInt(str,2);
            if(selected2.equals("二进制")){
                return Integer.toBinaryString(temp);
            }
            else if(selected2.equals("十进制")){
                return temp + "";
            }
            else if(selected2.equals("八进制")){
                return Integer.toOctalString(temp);
            }
            else if(selected2.equals("十六进制")){
                return Integer.toHexString(temp);
            }
            else{
                return "error";
            }
        }
        else if(selected1.equals("十进制")){
            temp = Integer.parseInt(str,10);
            if(selected2.equals("二进制")){
                return Integer.toBinaryString(temp);
            }
            else if(selected2.equals("十进制")){
                return temp + "";
            }
            else if(selected2.equals("八进制")){
                return Integer.toOctalString(temp);
            }
            else if(selected2.equals("十六进制")){
                return Integer.toHexString(temp);
            }
            else{
                return "error";
            }
        }
        else if(selected1.equals("八进制")){
            temp = Integer.parseInt(str,8);
            if(selected2.equals("二进制")){
                return Integer.toBinaryString(temp);
            }
            else if(selected2.equals("十进制")){
                return temp + "";
            }
            else if(selected2.equals("八进制")){
                return Integer.toOctalString(temp);
            }
            else if(selected2.equals("十六进制")){
                return Integer.toHexString(temp);
            }
            else{
                return "error";
            }
        }
        else if(selected1.equals("十六进制")){
            temp = Integer.parseInt(str,16);
            if(selected2.equals("二进制")){
                return Integer.toBinaryString(temp);
            }
            else if(selected2.equals("十进制")){
                return temp + "";
            }
            else if(selected2.equals("八进制")){
                return Integer.toOctalString(temp);
            }
            else if(selected2.equals("十六进制")){
                return Integer.toHexString(temp);
            }
            else{
                return "error";
            }
        }
        else {
            return "error";
        }
    }

    private class spinnerListener1 implements android.widget.AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> adapterView,
                                   View view, int i, long l) {
            selected1 = adapterView.getItemAtPosition(i).toString();
            Toast.makeText(JinzhiActivity.this,selected1,Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
            System.out.println("nothingSelect");
        }
    }

    private class spinnerListener2 implements android.widget.AdapterView.OnItemSelectedListener  {

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            selected2 = adapterView.getItemAtPosition(i).toString();
            Toast.makeText(JinzhiActivity.this,selected2,Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
            System.out.println("nothingSelect");
        }
    }

}