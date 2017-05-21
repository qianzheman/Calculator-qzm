package com.example.jarrem.calculator;

import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private   int peopleNum;
    private   double  howMany;
    private   double  huoniao1;
    private   double  huoniao2;
    private   double  huoniao3;
    private   double  huoniao4;


    private   double  tuoniao1;
    private   double  tuoniao2;
    private   double  tuoniao3;
    private   double  tuoniao4;

    private   double  huxi1;
    private   double  huxi2;
    private   double  huxi3;
    private   double  huxi4;

    private  double ctou;

    private  RadioButton three_radio;
    private  RadioButton four_radio;

    private Button button_calcu;
    private Button button_reset;
    private Button button_exit;

    private TextView jiaJieGuo,yiJieGuo,binJieGuo,dingJieGuo;
    private EditText
            ahuoniao,bhuoniao,chuoniao,dhuoniao,
            aTuoNiao,bTuoNiao,cTuoNiao,dTuoNiao,
            aHuXi,bHuXi,cHuXi,dHuXi,
            caiTuo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取button状态
        button_calcu=(Button) findViewById(R.id.calcu);
        button_reset=(Button) findViewById(R.id.reset);
        button_exit=(Button) findViewById(R.id.exit);
        //Button监听器
        button_calcu.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        init();
                        calculation();
                    }
                });
    }
    public void init(){
        //获取打多大EditText的value
        EditText tv1=(EditText) findViewById(R.id.howMany);
        howMany= Double.parseDouble(tv1.getText().toString());

        //获取活鸟的值
        ahuoniao=(EditText) findViewById(R.id.huoa);
        bhuoniao=(EditText) findViewById(R.id.huob);
        chuoniao=(EditText) findViewById(R.id.huoc);
        dhuoniao=(EditText) findViewById(R.id.huod);
        huoniao1= Double.parseDouble(ahuoniao.getText().toString());
        huoniao2= Double.parseDouble(bhuoniao.getText().toString());
        huoniao3= Double.parseDouble(chuoniao.getText().toString());
        huoniao4= Double.parseDouble(dhuoniao.getText().toString());

        //获取拖鸟的值
        aTuoNiao=(EditText) findViewById(R.id.tuoa);
        bTuoNiao=(EditText) findViewById(R.id.tuob);
        cTuoNiao=(EditText) findViewById(R.id.tuoc);
        dTuoNiao=(EditText) findViewById(R.id.tuod);
        tuoniao1= Double.parseDouble(aTuoNiao.getText().toString());
        tuoniao2= Double.parseDouble(bTuoNiao.getText().toString());
        tuoniao3= Double.parseDouble(cTuoNiao.getText().toString());
        tuoniao4= Double.parseDouble(dTuoNiao.getText().toString());

        //获取胡息值
        aHuXi=((EditText) findViewById(R.id.hua));
        bHuXi=((EditText) findViewById(R.id.hub));
        cHuXi=((EditText) findViewById(R.id.huc));
        dHuXi=((EditText) findViewById(R.id.hud));
        huxi1= Double.parseDouble(aHuXi.getText().toString());
        huxi2= Double.parseDouble(bHuXi.getText().toString());
        huxi3= Double.parseDouble(cHuXi.getText().toString());
        huxi4= Double.parseDouble(dHuXi.getText().toString());
        //彩头
        caiTuo=(EditText)findViewById(R.id.howMany);
        ctou=Double.parseDouble(caiTuo.getText().toString());
        //定义结果
        jiaJieGuo = (TextView) findViewById(R.id.aResult);
        yiJieGuo = (TextView) findViewById(R.id.bResult);
        binJieGuo = (TextView) findViewById(R.id.cResult);
        dingJieGuo = (TextView) findViewById(R.id.dResult);
    }

    private void  calculation(){


        double[] Rtn = {0,0,0,0};

        double[] hz = {huxi1, huxi2, huxi3,huxi4};
        double[] tn = {tuoniao1, tuoniao2, tuoniao3,tuoniao4};
        int rs = 0;
        for (int i = 0; i < tn.length; i++) {
            for (int j = 0; j < tn.length; j++) {
                if (i != j) {
                    if (hz[i] - hz[j] > 0) {
                        rs += tn[i] + tn[j];
                    } else if(hz[i] - hz[j]==0){
                        rs+=0;
                    }else{
                        rs += (-tn[i] - tn[j]);
                    }
                }
            }

            Rtn[i]=rs;
            rs = 0;
        }

        huxi1 =  Mathrint(huxi1);
        huxi2 =  Mathrint(huxi2);
        huxi3 = Mathrint(huxi3);
        huxi4 =  Mathrint(huxi4);

       // 胡子的重新赋值
        hz[0] = huxi1;
        hz[1] = huxi2;
        hz[2] = huxi3;
        hz[3] = huxi4;

        double[] hn = {huoniao1, huoniao2, huoniao3,huoniao4};
        //活鸟结果值
        double[] Rhn = {0,0,0,0};
        rs = 0;
        for (int i = 0; i < tn.length; i++) {
            for (int j = 0; j < tn.length; j++) {
                if (i != j) {
                    rs += ((hz[i] - hz[j]) * ctou * (hn[i] + 1) * (hn[j] + 1));
                }

            }
            Rhn[i]=rs;
            rs = 0;
        }

        double Rrs11=Rhn[0] + Rtn[0];
        String Rrs1 =""+Rrs11;
        jiaJieGuo.setText(Rrs1);
        double Rrs22=Rhn[1] + Rtn[1];
        String Rrs2 = ""+Rrs22;
        yiJieGuo.setText(Rrs2);
        double Rrs33=Rhn[2] + Rtn[2];
        String Rrs3 = ""+Rrs33;
        binJieGuo.setText(Rrs3);
        double Rrs44=Rhn[3] + Rtn[3];
        String Rrs4 =""+Rrs44;
        dingJieGuo.setText(Rrs4);
    }
    public double Mathrint(double x){
        double temp=((int)x)%10>4?(x/10*10+10):(x/10*10);
        return x>0?temp:-1*temp;
    }
}
