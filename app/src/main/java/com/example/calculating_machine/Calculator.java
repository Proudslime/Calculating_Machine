package com.example.calculating_machine;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.math.*;
import java.util.ArrayList;
import java.util.Stack;

public class Calculator {

    public String getStr(String str){
        return getCalResult(str);
    }

    public static String getCalResult(String postfixExp) {
        Stack s = new Stack();
        String temp = "";
        int i = 0;
        double num, top;
        String ts = convert(postfixExp);
        char[] PostfixExp = ts.toCharArray();

        while(PostfixExp[i] != '#') {
            if(isNumber(PostfixExp[i]) || PostfixExp[i] == '.') {
                temp += PostfixExp[i];
            }
            else if(PostfixExp[i] == ' ' && !temp.equals("") && !isOper(PostfixExp[i])) {
                num = Double.parseDouble(temp);
                s.push(num);
                temp = "";
            }
            else if(isOper(PostfixExp[i])){
                double result = 0, num1, num2;
                num1 = (double) s.pop();
                num2 = (double) s.pop();
                switch(PostfixExp[i]) {
                    case '+':
                        result = num2 + num1;
                        break;
                    case '-':
                        result = num2 - num1;
                        break;
                    case '*':
                        result = num2 * num1;
                        break;
                    case '/':
                        result = num2 / num1;
                        break;
                }
                s.push(result);
            }
            i++;
        }
        return s.peek() + "";
    }

    public static boolean isNumber(char ch) {
        if(ch >= '0' && ch <= '9') {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean isOper(char ch) {
        char[] oper = {'+' , '-' , '*' , '/' , ')', 's', 'c', 't'};

        for(int i = 0; i < oper.length; ++i) {
            if(ch == oper[i])
                return true;
        }
        return false;
    }

    public static int priority(char ch) {

        if(ch >= '0' && ch <= '9') {
            return 5;
        }
        else if(ch == '.') {
            return 6;
        }
        else {
            switch(ch){
                case '+':
                case '-':
                    return 1;
                case '*':
                case '/':
                    return 2;
                case '(':
                    return 4;
                case ')':
                    return 3;
                default:
                    return 0;
            }
        }

    }

    public static String format(String str) {
        char[] ch = str.toCharArray();
        double result = 0;
        int index = 0;
        String s = "";

        for(int i = 0; i < ch.length; i++) {
            if(ch[i] == '-') {
                if(i == 0) {
                    ch = insert(0,'0',ch);
                }
                else if(ch[i-1] == '(') {
                    ch = insert(i,'0',ch);
                }
            }
            else if(isMathS(ch[i])){
                String[] temp = MathCal(i, ch);
                if(ch[i] == 's') {
                    result = Math.sin(Math.toRadians(Double.parseDouble(getCalResult(temp[0]))));
                }
                else if(ch[i] == 'c') {
                    result = Math.cos(Math.toRadians(Double.parseDouble(getCalResult(temp[0]))));
                }
                else if(ch[i] == 't') {
                    result = Math.tan(Math.toRadians(Double.parseDouble(getCalResult(temp[0]))));
                }
                StringBuilder sb = new StringBuilder(String.valueOf(ch));
                sb.replace(i, Integer.parseInt(temp[1]) + 1, result + "");
                ch = (sb + "").toCharArray();
            }
            else if(ch[i] == '%'){
                index = i - 1;
                while(true){
                    if(isOper(ch[index]) || index == -1){
                        break;
                    }
                    else{
                        index--;
                        continue;
                    }
                }
                for(int j = index + 1; j < i; j++) {
                    s += ch[j] + "";
                }
                StringBuilder sb = new StringBuilder(String.valueOf(ch));
                sb.replace(index+1, i+1, (Double.parseDouble(s)/100) + "");
                ch = (sb + "").toCharArray();
            }
        }
        return s.valueOf(ch);
    }

    public static String[] MathCal(int StartIndex, char[] ch) {
        // TODO Auto-generated method stub
        int i = StartIndex;
        ArrayList<String> temp = new ArrayList<String>();
        while(true) {
            i++;

            if(ch[i] == ')') {
                temp.add(")");
                break;
            }
            else {
                temp.add(ch[i] + "");
                continue;
            }
        }
        String[] t = new String[2];
        t[0] = String.join("", temp);
        t[1] = i + "";
        return t;
    }

    public static boolean isMathS(char ch) {
        // TODO Auto-generated method stub
        if(ch == 's' || ch == 'c' || ch == 't' ||
                ch == 'q' || ch == 'p') {
            //s = sin, c = cos, t = tan, p = pow, q = sqrt
            return true;
        }
        else {
            return false;
        }
    }

    public static char[] insert(int index, char insertch, char[] ch) {
        char[] c = new char[ch.length + 1];
        int i = ch.length - 1;
        for(; i >= index; i--) {
            c[i+1] = ch[i];
        }
        for(int j = 0; j < index; j++) {
            c[j] = ch[j];
        }
        c[index] = insertch;
        return c;
    }


    public static String convert(String infixExp) {
        ArrayList<String> PostfixExp = new ArrayList<String>();
        Stack s = new Stack();
        char[] InfixExp = (format(infixExp)).toCharArray();
        int i;
        s.push('#');
        String temp = "";

        for(i = 0; i < InfixExp.length; i++) {
            switch(priority(InfixExp[i])) {
                case 6:
                case 5:
                    PostfixExp.add(temp.valueOf(InfixExp[i]));
                    if(!(i == InfixExp.length - 1)) {
                        if(isOper(InfixExp[i + 1])) {
                            PostfixExp.add(" ");
                        }
                    }
                    break;
                case 4:
                    s.push('(');break;
                case 3:
                    if(s.isEmpty()) {
                        //空值判断
                    }
                    else {
                        char temp1 = (char) s.peek();
                        while(temp1 != '(' && !s.isEmpty()) {
                            PostfixExp.add(temp.valueOf(temp1));
                            PostfixExp.add(" ");
                            s.pop();
                            temp1 = (char) s.peek();
                        }
                    }
                    s.pop();break;
                case 2:
                case 1:
                    char temp2 = (char) s.peek();
                    while(!s.isEmpty() && temp2 != '(' && (priority(temp2) >= priority(InfixExp[i]))) {
                        PostfixExp.add(temp.valueOf(temp2));
                        PostfixExp.add(" ");
                        s.pop();
                        temp2 = (char) s.peek();
                    }
                    s.push(InfixExp[i]);break;
            }
        }

        while(!s.isEmpty()) {
            char temp3 = (char) s.pop();
            PostfixExp.add(" ");
            PostfixExp.add(temp.valueOf(temp3));
        }

        String p = String.join("", PostfixExp);
        return p;
    }
}
