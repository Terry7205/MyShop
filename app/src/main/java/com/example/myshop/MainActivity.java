package com.example.myshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText userid, passwd;
    Button btn_login, btn_info, btn_guid, btn_call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userid = findViewById(R.id.userid);
        passwd = findViewById(R.id.passwd);
        btn_login = findViewById(R.id.btn_login);
        btn_guid = findViewById(R.id.btn_guide);
        btn_info = findViewById(R.id.btn_info);
        btn_call = findViewById(R.id.btn_call);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "버튼 클릭", Toast.LENGTH_SHORT).show();
                Log.d("TEST", "클릭");
                //아이디 5글자 비번 8글자 규칙
                String strId, strPw;
                strId = userid.getText().toString();
                strPw = passwd.getText().toString();

                if (strId.length() < 5 || strPw.length() <= 8) {
                    Toast.makeText(MainActivity.this, "아이디는 5글자 이상, 비밀번호는 8글자 이상입니다.", Toast.LENGTH_SHORT).show();
                } else {
                    //아이디는 학번, 비번은 "123456789" 면 정상
                    if (strId.equals("30509") && strPw.equals("123456789"))
                        Toast.makeText(MainActivity.this, strId + "님 환영합니다.", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(MainActivity.this, "아이디와 패스워드를 확인하세요", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_info.setOnClickListener(this);
        btn_guid.setOnClickListener(this);
        btn_call.setOnClickListener(this);
        
    }

    @Override
    public void onClick(View view) {
        Intent intent = null ;
        switch (view.getId()){
            case R.id.btn_info:
                intent = new Intent(MainActivity.this, InfoActivity.class) ;
                Toast.makeText(this, "샵 정보화면으로 이동", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_guide:
                intent = new Intent(MainActivity.this, GuideActivity.class) ;
                Toast.makeText(this, "운영시간 화면으로 이동", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_call:
                intent = new Intent(MainActivity.this, CallActivity.class) ;
                Toast.makeText(this, "예약하기 화면으로 이동", Toast.LENGTH_SHORT).show();
                break;
        }
        startActivity(intent);
            
    }
}
