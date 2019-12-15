package com.example.androiddemo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.androiddemo.R;

/**
 * @author mlsnatalie
 * @date 2019-06-13.
 * email：mlsnatalie@163.com
 * description：
 */
public class TestFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return View.inflate(getContext(), R.layout.fragment_test, null);

    }

    private void initView() {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
//        Fragment destFragment = getActivity().getSupportFragmentManager().findFragmentByTag(fragmentName);
        Fragment destFragment = new TestTwoFragment();

        if (destFragment.isAdded()) {
            transaction.show(destFragment);
        } else {
            transaction.add(R.id.fragment_container, destFragment, destFragment.getClass().getName());
        }
        transaction.commit();
    }
}
