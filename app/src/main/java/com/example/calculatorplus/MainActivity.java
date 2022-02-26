package com.example.calculatorplus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.mariuszgromada.math.mxparser.*;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

        private TextView prevcalulation;
        private EditText display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prevcalulation=findViewById(R.id.prevview);
        display=findViewById(R.id.displaytedittext);
        display.setShowSoftInputOnFocus(false);
    }
    private void updateText(String toadd){
        int cursorPos=display.getSelectionStart();
        if(display.getText().toString().equals("NaN")){
            display.setText(toadd);
            display.setSelection(display.length());
        }
        else{
            String oldStr=display.getText().toString();
            String leftStr=oldStr.substring(0,cursorPos);
            String rightStr=oldStr.substring(cursorPos);
            display.setText(String.format("%s%s%s",leftStr,toadd,rightStr));
            display.setSelection(cursorPos+toadd.length());
        }

    }
    public void zeroBtnPush(View v){
        updateText(getResources().getString(R.string.zeroText));
    }
    public void oneBtnPush(View v){
        updateText(getResources().getString(R.string.oneText));
    }
    public void twoBtnPush(View v){
        updateText(getResources().getString(R.string.TwoText));
    }
    public void threeBtnPush(View v){
        updateText(getResources().getString(R.string.threeText));
    }
    public void fourBtnPush(View v){
        updateText(getResources().getString(R.string.fourText));
    }
    public void fiveBtnPush(View v){
        updateText(getResources().getString(R.string.fiveText));
    }
    public void sixBtnPush(View v){
        updateText(getResources().getString(R.string.sixText));
    }
    public void sevenBtnPush(View v){
        updateText(getResources().getString(R.string.sevenText));
    }
    public void eightBtnPush(View v){
        updateText(getResources().getString(R.string.eightText));
    }
    public void nineBtnPush(View v){
        updateText(getResources().getString(R.string.nineText));
    }
    public void clearBtnPush(View v){
       display.setText("");
       prevcalulation.setText("");
    }
    public void addBtnPush(View v){
        updateText(getResources().getString(R.string.addText));
    }
    public void subBtnPush(View v){
        updateText(getResources().getString(R.string.subtractText));
    }
    public void multBtnPush(View v){
        updateText(getResources().getString(R.string.multiplyText));
    }
    public void divBtnPush(View v){
        updateText(getResources().getString(R.string.divideText));
    }
    public void pointBtnPush(View v){
        updateText(getResources().getString(R.string.pointText));
    }
    public void par1BtnPush(View v){
        updateText(getResources().getString(R.string.paropen));
    }
    public void par2BtnPush(View v){
        updateText(getResources().getString(R.string.parclosed));
    }
    public void equalBtnPush(View v){
        String userExp=display.getText().toString();
        prevcalulation.setText(userExp);
        userExp=userExp.replaceAll(getResources().getString(R.string.divideText),"/");
        userExp=userExp.replaceAll(getResources().getString(R.string.multiplyText),"*");
        Expression exp=new Expression(userExp);
        String result=String.valueOf(exp.calculate());
        display.setText(result);
        display.setSelection(result.length());
        if(display.getText().toString().equals("NaN")){
            Toast toast=Toast.makeText(getApplicationContext(),"Invalid Input",Toast.LENGTH_SHORT);
            toast.show();
            prevcalulation.setText("");
        }
    }
    public void backBtnPush(View v){
        int cursorPos=display.getSelectionStart();
        int textLen=display.getText().length();

        if(cursorPos !=0 && textLen!=0){
            SpannableStringBuilder selection =(SpannableStringBuilder) display.getText();
            selection.replace(cursorPos-1,cursorPos,"");
            display.setText(selection);
            display.setSelection(cursorPos-1);
        }
    }
    public void trigSinBTNpush(View v){
        updateText("sin(");
    }
    public void trigCosBTNpush(View v){
        updateText("cos(");
    }
    public void trigTanBTNpush(View v){
        updateText("tan(");
    }
    public void trigArcSinBTNpush(View v){
        updateText("arcsin(");
    }
    public void trigArcCosBTNpush(View v){
        updateText("arccos(");
    }
    public void trigArcTanBTNpush(View v){
        updateText("arctan(");
    }

    public void logBTNpush(View v){
        updateText("log(");
    }
    public void lnBTNpush(View v){
        updateText("ln(");
    }
    public void radBTNpush(View v){
        updateText("sqrt(");
    }
    public void eBTNpush(View v){
        updateText("e");
    }
    public void piBTNpush(View v){
        updateText("pi");
    }
    public void absBTNpush(View v){
        updateText("abs(");
    }
    public void primeBTNpush(View v){
        updateText("ispr(");
    }
    public void squaredBTNpush(View v){
        updateText("^(2)");
    }
    public void powerBTNpush(View v){
        updateText("^(");
    }
}