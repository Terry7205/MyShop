package com.example.myshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class InfoActivity extends AppCompatActivity {

    int no = 0 ; //그릠번호 : 0 1 2 3 4 0 1 2 3 4
    int imgs[] = {R.drawable.info1, R.drawable.info2, R.drawable.info3,
            R.drawable.info4, R.drawable.info5} ;

    String txts[] = {"1번 그림 설명","2번 그림 설명","3번 그림 설명",
            "4번 그림 설명","5번 그림 설명"} ;
    ImageView img_info ;
    TextView txt_info ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

    findViewById(R.id.backbtn).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    });

    //이미지 처리 - 초기화
        img_info = findViewById(R.id.image_info) ;
        img_info.setImageResource(imgs[0]);
        txt_info = findViewById(R.id.txt_info) ;
        txt_info.setText(txts[0]);

        img_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(InfoActivity.this, "이미지 클릭", Toast.LENGTH_SHORT).show();

                no = ++no % 5 ;
                img_info.setImageResource(imgs[no]);
                txt_info.setText(txts[no]);
            }
        });
    }
}
