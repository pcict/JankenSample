package com.websarva.wings.android.jankensample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view){

        // ラジオグループのオブジェクトを取得
        RadioGroup rg = (RadioGroup)findViewById(R.id.rgJanken);
        // チェックされているラジオボタンの ID を取得
        int id = rg.getCheckedRadioButtonId();

        //ユーザのじゃんけんの手を格納
        int user = 0;

        if(id == R.id.rbGu){
            user = 1;
        } else if (id == R.id.rbCyoki) {
            user = 2;
        } else if (id == R.id.rbPa) {
            user = 3;
        }

        //コンピュータのじゃんけんの手を格納
        int pc = (int)(Math.random() * 3 ) + 1;
        String pcTe = "";

        if(pc == 1){
            pcTe = "グー";
        } else if (pc == 2) {
            pcTe = "チョキ";
        } else if (pc == 3) {
            pcTe = "パー";
        }

        //結果を格納
        String kekka;

        switch (user) {
            case 1:	//グー
                switch(pc) {
                    case 1:
                        kekka = "あいこ";
                        break;
                    case 2:
                        kekka = "勝ち";
                        break;
                    default:
                        kekka = "負け";
                        break;
                }
                break;
            case 2:	//チョキ
                switch(pc) {
                    case 1:
                        kekka = "負け";
                        break;
                    case 2:
                        kekka = "あいこ";
                        break;
                    default:
                        kekka = "勝ち";
                        break;
                }
                break;
            default:	//パー
                switch(pc) {
                    case 1:
                        kekka = "勝ち";
                        break;
                    case 2:
                        kekka = "負け";
                        break;
                    default:
                        kekka = "あいこ";
                        break;
                }
        }

        TextView tvComputer = findViewById(R.id.tvComputer);
        TextView tvSyouhai = findViewById(R.id.tvSyouhai);

        tvComputer.setText("コンピュータの手は「 " + pcTe + " 」です");
        tvSyouhai.setText("あなたの「" + kekka + "」です");

    }
}