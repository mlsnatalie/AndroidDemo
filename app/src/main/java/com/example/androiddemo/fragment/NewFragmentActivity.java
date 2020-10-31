package com.example.androiddemo.fragment;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.androiddemo.R;

/**
 * @author mlsnatalie
 * @date 2019-06-13.
 * email：mlsnatalie@163.com
 * description：
 */
public class NewFragmentActivity extends AppCompatActivity {

    public CountDownTimer countDownTimer;
    private TextView title_bar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_fragment);
        title_bar = findViewById(R.id.title_bar);
        intitTime(676L);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        Fragment destFragment = getActivity().getSupportFragmentManager().findFragmentByTag(fragmentName);
        Fragment destFragment = new TestFragment();
//        if (destFragment == null) {
//            destFragment = Fragment.instantiate(mContext, fragmentName, data);
//        }
        // 当前有展示的Fragment(非首次，先隐藏之)
//        if (mCurrFragment != null && !mCurrFragment.getClass().getName().equals(fragmentName)) {
//            transaction.hide(mCurrFragment);
//        }

        if (destFragment.isAdded()) {
            transaction.show(destFragment);
        } else {
            transaction.add(R.id.fragment_container, destFragment, destFragment.getClass().getName());
        }
        transaction.commit();
    }

    private void intitTime(Long time) {
        countDownTimer = new CountDownTimer(time, 1000) {
            public void onTick(long millisUntilFinished) {
                title_bar.setText(TimeTools.getCountTimeByLong(millisUntilFinished));
            }
            public void onFinish() {
                //倒计时结束
                title_bar.setText("0000");
            }
        }.start();
    }
}
