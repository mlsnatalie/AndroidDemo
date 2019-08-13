package com.example.androiddemo.sp;

import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.example.androiddemo.R;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author Menglingshuai
 * @date 2019-07-29.
 * email：mlsnatalie@163.com
 * description：
 */
public class SpActivity extends AppCompatActivity implements View.OnClickListener {

    Context mContext;
    ListDataSave dataSave;
    private ArrayList<Userbean> listBean;
    private ArrayList<String> listString;
    private ArrayList<Map<String, Object>> listMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp);
        initView();

    }

    private void initView() {
        findViewById(R.id.btn_addString).setOnClickListener(this);
        findViewById(R.id.btn_addJavaBean).setOnClickListener(this);
        findViewById(R.id.btn_addMap).setOnClickListener(this);
        findViewById(R.id.btn_getString).setOnClickListener(this);
        findViewById(R.id.btn_getJavaBean).setOnClickListener(this);
        findViewById(R.id.btn_getMap).setOnClickListener(this);
        mContext = getApplicationContext();
        dataSave = new ListDataSave(mContext, "baiyu");
        listString = new ArrayList<String>();
        listBean = new ArrayList<Userbean>();
        listMap = new ArrayList<Map<String, Object>>();
    }






    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_addString:
                String s = "小名";
                listString.add(s);
                dataSave.setDataList("string", listString);
                Log.e("aaaddd", "11111" + listString.toString());

                break;
            case R.id.btn_getString:
                Toast.makeText(mContext, dataSave.getDataList("string").toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_addJavaBean:
                Userbean user = new Userbean();
                user.setName("");
                user.setAge(16);
                listBean.add(user);
                dataSave.setDataList("javaBean", listBean);
                Log.e("aaaddd", "22222" + listBean.toString());
                break;
            case R.id.btn_getJavaBean:

                Toast.makeText(mContext, dataSave.getDataList("javaBean").toString(), Toast.LENGTH_SHORT).show();
                Log.e("aaaddd", "22222" + dataSave.getDataList("javaBean").toString());
                Log.e("aaaddd","44444" + dataSave.getDataList("javaBean").get(0).toString());

                break;
//            case R.id.btn_addMap:
//                Map<String, Object> map=new HashMap<String, Object>();
//                map.put("name","大白");
//                map.put("age", 18);
//                listMap.add(map);
//                dataSave.setDataList("listMap", listMap);
//                Log.e("aaaddd", "333333" + listMap.toString());
//                break;
//            case R.id.btn_getMap:
//                Toast.makeText(mContext, dataSave.getDataList("listMap").toString(), Toast.LENGTH_SHORT).show();
//                break;
        }

    }
}
