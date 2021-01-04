package com.example.androiddemo.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androiddemo.R;
import com.example.androiddemo.view.UpDownBalProportionView;

/**
 * @author: mlsnatalie
 * @date: 2020/12/21 4:28 PM
 * @UpdateDate: 2020/12/21 4:28 PM
 * email：mlsnatalie@163.com
 * description：
 */
public class UpDownBalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_line);
        UpDownBalProportionView view = findViewById(R.id.cp_proportion);
        view.setData(30, 20, 10);
    }
}
