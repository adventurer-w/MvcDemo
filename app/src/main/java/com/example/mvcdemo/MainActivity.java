package com.example.mvcdemo;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mvcdemo.controller.MoneyControler;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    private Button add;
    private Button one;
    private Button ten;
    private ImageView imageView;
    private TextView textView2;
    private MoneyControler moneyControler;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainlayout);
        initView();

        moneyControler = new MoneyControler();
    }

    private  void initView(){
        text=(TextView)findViewById(R.id.textView9);
        text.setText("1");
        add=(Button)findViewById(R.id.button3);
        one=(Button)findViewById(R.id.button);
        ten=(Button)findViewById(R.id.button2);
        imageView=(ImageView)findViewById(R.id.imageView3);
        textView2 =findViewById(R.id.textView2);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moneyControler.addNumber(new MoneyControler.addListener(){
                    @Override
                    public void addOK(String str) {
                        text.setText(str);
                    }
                });
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (moneyControler.nowMoney() >= 1) {
                    moneyControler.reduceNumber(new MoneyControler.reduceListener() {
                        @Override
                        public void reduceOK(String str,String tx,int id) {
                            showProgressDialog("提示", "加载中......");
                            new Thread(new Runnable() {
                                @Override
                                public void run() {

                                    try {
                                        Thread.sleep(1000); // 休眠1秒
                                        hideProgressDialog();
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }).start();
                            if(tx=="没中，再来一次吧！"){
                                Toast.makeText(MainActivity.this, "未抽中五星角色！", Toast.LENGTH_SHORT).show();
                            }
                            text.setText(str);
                            imageView.setImageDrawable(getResources().getDrawable(id));
                            textView2.setText(tx);
                        }
                    }, 2);
                }else {
                    Toast.makeText(MainActivity.this, "您的纠缠之缘不足，请充值！", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (moneyControler.nowMoney() >= 10) {
                    moneyControler.reduceNumber(new MoneyControler.reduceListener() {
                        @Override
                        public void reduceOK(String str,String tx,int id) {
                            showProgressDialog("提示", "加载中......");
                            new Thread(new Runnable() {
                                @Override
                                public void run() {

                                    try {
                                        Thread.sleep(1000); // 休眠1秒
                                        hideProgressDialog();
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }).start();
                            if(tx=="没中，再来一次吧！"){
                                Toast.makeText(MainActivity.this, "未抽中五星角色！", Toast.LENGTH_SHORT).show();
                            }
                            Log.d("mone",tx+id);
                            text.setText(str);
                            imageView.setImageDrawable(getResources().getDrawable(id));
                            textView2.setText(tx);
                        }
                    }, 3);
                }else {
                    Toast.makeText(MainActivity.this, "您的纠缠之缘不足，请充值！", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void showProgressDialog(String title, String message) {
        if (progressDialog == null) {

            progressDialog = ProgressDialog.show(MainActivity.this, title,
                    message, true, false);
        } else if (progressDialog.isShowing()) {
            progressDialog.setTitle(title);
            progressDialog.setMessage(message);
        }
        progressDialog.show();
    }
    public void hideProgressDialog() {

        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }

    }


}
