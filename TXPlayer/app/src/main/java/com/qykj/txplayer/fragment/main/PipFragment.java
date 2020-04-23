package com.qykj.txplayer.fragment.main;

import android.view.View;
import android.widget.Toast;

import com.qykj.txplayer.R;
import com.qykj.txplayer.fragment.BaseFragment;

public class PipFragment extends BaseFragment implements View.OnClickListener {

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_pip;
    }

    @Override
    protected void initView() {
        super.initView();
        findViewById(R.id.btn_pip).setOnClickListener(this);
        findViewById(R.id.btn_pip_in_list).setOnClickListener(this);
        findViewById(R.id.btn_pip_android_o).setOnClickListener(this);
        findViewById(R.id.btn_tiny_screen).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getActivity(), "抄的DK这些直接去DK看", Toast.LENGTH_LONG).show();

    }
}
