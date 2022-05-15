package com.example.eduupcdsacalculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    //declaració botons numeros
    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    //declaració botons operacions
    Button btn_igual;
    Button btn_sumar;
    Button btn_restar;
    Button btn_mult;
    Button btn_div;
    Button btn_clear;
    Button btn_cos;
    Button btn_sin;
    Button btn_tan;

    //string per registrar operacio
    private String actual;      //al final no ho he utilitzat
    private String operacio;    //al final no ho he utilitzat
    //string dels TextView
    private TextView t2; //resultat
    private TextView t1; //entrada

    //boleans per activar segons operació i tractar en la tecla de btn_igual
    boolean suma = false;
    boolean resta = false;
    boolean mult = false;
    boolean div = false;
    Double[] numero = new Double[3]; //per sumar,restar,mult i div
    Double res;

    @Override
    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //capturar botons en var
        //nums
        btn0 = (Button)findViewById(R.id.btn0);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn6 = (Button)findViewById(R.id.btn6);
        btn7 = (Button)findViewById(R.id.btn7);
        btn8 = (Button)findViewById(R.id.btn8);
        btn9 = (Button)findViewById(R.id.btn9);
        //operacions
        btn_igual= (Button)findViewById(R.id.btn_igual);
        btn_sumar= (Button)findViewById(R.id.btn_sumar);
        btn_restar= (Button)findViewById(R.id.btn_restar);
        btn_mult= (Button)findViewById(R.id.btn_mult);
        btn_div = (Button)findViewById(R.id.btn_div2);
        btn_clear= (Button)findViewById(R.id.btn_clear);
        btn_cos = (Button)findViewById(R.id.btn_cos);
        btn_sin = (Button)findViewById(R.id.btn_sin);
        btn_tan = (Button)findViewById(R.id.btn_tan);
        //string
        t1=(TextView)findViewById(R.id.display1);
        t2=(TextView)findViewById(R.id.display2);
    }
    public void onClick(View view) {
    //afegeix al string la entrada segons el botó apretat (btn)
        int btn = view.getId();
        String string = t1.getText().toString();
        //switch case amb cada botó i el que provoca
        switch (btn){
            //numeros
            case R.id.btn0:     t2.setText(string+0);     break;
            case R.id.btn1:     t2.setText(string+1);     break;
            case R.id.btn2:     t2.setText(string+2);     break;
            case R.id.btn3:     t2.setText(string+3);     break;
            case R.id.btn4:     t2.setText(string+4);     break;
            case R.id.btn5:     t2.setText(string+5);     break;
            case R.id.btn6:     t2.setText(string+6);     break;
            case R.id.btn7:     t2.setText(string+7);     break;
            case R.id.btn8:     t2.setText(string+8);     break;
            case R.id.btn9:     t2.setText(string+9);     break;
            //operacions. Posem a true el boolean per després tractar cada cas
            case R.id.btn_sumar:
                suma=true;
                numero[0]=Double.parseDouble(string);
                t2.setText(string+"+");
                break;
            case R.id.btn_restar:
                resta=true;
                numero[0]=Double.parseDouble(string);
                t2.setText(string+"-");
                break;
            case R.id.btn_mult:
                mult=true;
                numero[0]=Double.parseDouble(string);
                t2.setText(string+"*");
                break;
            case R.id.btn_div2:
                div=true;
                numero[0]=Double.parseDouble(string);
                t2.setText(string+"/");
                break;
            //signe igual
            case R.id.btn_igual:
                //aqui tractem cada cas (sumar, restar, mult, div)
                if(suma=true){
                    t2.setText(String.valueOf(numero[0]+numero[1]));
                    res = numero[0] + numero[1];
                    t1.setText(String.valueOf(res));
                }
                else if (resta=true) {
                t2.setText(String.valueOf(numero[0] + numero[1]));
                res = numero[0] - numero[1];
                t1.setText(String.valueOf(res));
                }
                else if(suma=mult) {
                    t2.setText(String.valueOf(numero[0] + numero[1]));
                    res = numero[0] * numero[1];
                    t1.setText(String.valueOf(res));
                }
                if(suma=div) {
                    t2.setText(String.valueOf(numero[0] + numero[1]));
                    res = numero[0] / numero[1];
                    t1.setText(String.valueOf(res));
                }

            //trigometria
            case R.id.btn_cos:
                numero[0]=Double.parseDouble(string);
                t2.setText(String.valueOf("cos " + numero[0]));
                res=Math.cos(numero[0]*Math.PI/180);
                break;
            case R.id.btn_sin:
                numero[0]=Double.parseDouble(string);
                t2.setText(String.valueOf("sin " + numero[0]));
                res=Math.sin(numero[0]*Math.PI/180);
                break;
            case R.id.btn_tan:
                t2.setText(String.valueOf("tan " + numero[0]));
                numero[0]=Double.parseDouble(string);
                res=Math.tan(numero[0]*Math.PI/180);
                break;

        }
        //tornem a posar boleans a false per seguir operant
        boolean suma = false;
        boolean resta = false;
        boolean mult = false;
        boolean div = false;
    }

}