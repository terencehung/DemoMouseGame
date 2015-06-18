package com.terence.DemoGame.gameargs;


import com.terence.DemoGame.R;

import com.terence.DemoGame.musicTools.VolumsPlayer;

import android.R.integer;

public class Epicture {

    // 此類用來存儲每個方塊的動態信息
    public Epicture() {
        // TODO Auto-generated constructor stub
    }

    private int Empty = 0; // 代表此方塊為空洞
    private int Top = 1; // 代表此方塊地鼠開始鑽出
    private int Hited = -9; // 代表此方塊地鼠已被打擊

    private int Currenty = Empty; // 代表此刻方塊的狀態

    // 獲取現在的方塊狀態
    public int GetCurrenty() {
        return Currenty;
    }

    // 這個洞開始出地鼠
    public void ToShow() {
        Currenty = Top;
    }

    // 設置這個方塊的下一個狀態
    public void ToNext() {
        // 當Currenty=0時沒有下一個狀態，不予以處理
        if (Currenty > 0) {
            Currenty--;
            if (Currenty == 0) { // 如果再地鼠回到洞裡之前沒打掉就扣血
                //GameAgrs.HP--;
            }
        } else if (Currenty < 0) {
            Currenty++;
        }
    }

    // 觸發此方塊地鼠被打擊事件
    public void BeHited() {
        if (Currenty > 0) {
            Currenty = Hited;
            GameAgrs.Grade += GameAgrs.gradeUp;
            VolumsPlayer.playit(R.raw.hit1);
        }
    }
}
