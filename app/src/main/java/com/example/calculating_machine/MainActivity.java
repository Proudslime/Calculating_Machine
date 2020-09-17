package com.example.calculating_machine;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_0;
    Button btn_plus, btn_subt, btn_multipy, btn_divide,btn_lingling;
    Button btn_clear, btn_back, btn_equal, btn_sin, btn_cos, btn_tan;
    Button btn_jinzhi, btn_changdu, btn_tiji, btn_zuokuohao, btn_youkuohao;
    Button btn_baifenhao;
    TextView et_input;
    boolean clear_point;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        btn_0 = findViewById(R.id.ling);    btn_lingling = findViewById(R.id.shuangling);
        btn_1 = findViewById(R.id.yi);      btn_2 = findViewById(R.id.er);
        btn_3 = findViewById(R.id.san);     btn_4 = findViewById(R.id.si);
        btn_5 = findViewById(R.id.wu);      btn_6 = findViewById(R.id.liu);
        btn_7 = findViewById(R.id.qi);      btn_8 = findViewById(R.id.ba);
        btn_9 = findViewById(R.id.jiu);     btn_back = findViewById(R.id.back);
        btn_plus = findViewById(R.id.jia);  btn_subt = findViewById(R.id.jian);
        btn_multipy = findViewById(R.id.cheng);btn_divide = findViewById(R.id.chuyi);
        btn_clear = findViewById(R.id.C);   btn_equal = findViewById(R.id.dengyu);
        btn_baifenhao = findViewById(R.id.baifenhao);


        et_input = findViewById(R.id.xianshiqi);

        btn_0.setOnClickListener(this);  btn_lingling.setOnClickListener(this);
        btn_1.setOnClickListener(this);  btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);  btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);  btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);  btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);  btn_back.setOnClickListener(this);
        btn_clear.setOnClickListener(this);btn_equal.setOnClickListener(this);
        btn_plus.setOnClickListener(this);btn_subt.setOnClickListener(this);
        btn_divide.setOnClickListener(this);btn_multipy.setOnClickListener(this);
        btn_baifenhao.setOnClickListener(this);


        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // 加入横屏要处理的代码
            btn_sin = findViewById(R.id.sin);
            btn_cos = findViewById(R.id.cos);
            btn_tan = findViewById(R.id.tan);
            btn_jinzhi = findViewById(R.id.jinzhi);
            btn_changdu = findViewById(R.id.changdu);
            btn_tiji = findViewById(R.id.tiji);
            btn_zuokuohao = findViewById(R.id.zuokuohao);
            btn_youkuohao = findViewById(R.id.youkuohao);

            btn_sin.setOnClickListener(this);
            btn_cos.setOnClickListener(this);
            btn_tan.setOnClickListener(this);
            btn_zuokuohao.setOnClickListener(this);
            btn_youkuohao.setOnClickListener(this);

            btn_jinzhi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this,JinzhiActivity.class);
                    startActivity(intent);
                }
            });

            btn_changdu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this,ChangduActivity.class);
                    startActivity(intent);
                }
            });

            btn_tiji.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this,TijiActivity.class);
                    startActivity(intent);
                }
            });
        } else if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            // 加入竖屏要处理的代码
        }

    }

    @Override
    public void onClick(View view){
        String str = et_input.getText().toString();
        String result = "";
        switch (view.getId()){
            case R.id.yi:
            case R.id.er:
            case R.id.san:
            case R.id.si:
            case R.id.wu:
            case R.id.liu:
            case R.id.qi:
            case R.id.ba:
            case R.id.jiu:
            case R.id.ling:
            case R.id.shuangling:
            case R.id.jia:
            case R.id.jian:
            case R.id.cheng:
            case R.id.chuyi:
            case R.id.zuokuohao:
            case R.id.youkuohao:
            case R.id.baifenhao:
                if(clear_point){
                    clear_point = false;
                    str = "";
                    et_input.setText("");
                }

                et_input.setText(str + ((Button) view).getText());
                break;

            case R.id.C:
                if(clear_point){
                    clear_point = false;
                    str = "";
                    et_input.setText("");
                }

                et_input.setText("");break;
            case R.id.back:
                if(clear_point){
                    clear_point = false;
                    str = "";
                    et_input.setText("");
                }
                if(str != null && !str.equals("")){
                    et_input.setText(str.substring(0, str.length() - 1));
                }
                break;
            case R.id.dengyu:
                result = getResult(str);
                System.out.println(result);
                et_input.setText(result);
                break;
            case R.id.sin:
                if(clear_point){
                    clear_point = false;
                    str = "";
                    et_input.setText("");
                }
                et_input.setText(str + "s(");
                break;
            case R.id.cos:
                if(clear_point){
                    clear_point = false;
                    str = "";
                    et_input.setText("");
                }
                et_input.setText(str + "c(");
                break;
            case R.id.tan:
                if(clear_point){
                    clear_point = false;
                    str = "";
                    et_input.setText("");
                }
                et_input.setText(str + "t(");
                break;


        }
        System.out.println(str);
    }

    private String getResult(String str) {
        Calculator calculator = new Calculator();
        str = calculator.getStr(str);
        return str;
    }
}