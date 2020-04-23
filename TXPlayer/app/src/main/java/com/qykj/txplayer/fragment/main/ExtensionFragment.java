package com.qykj.txplayer.fragment.main;

import android.view.View;
import android.widget.Toast;

import com.qykj.txplayer.R;
import com.qykj.txplayer.fragment.BaseFragment;

public class ExtensionFragment extends BaseFragment implements View.OnClickListener {
    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_extension;
    }

    @Override
    protected void initView() {
        super.initView();
        findViewById(R.id.btn_fullscreen).setOnClickListener(this);
        findViewById(R.id.btn_danmu).setOnClickListener(this);
        findViewById(R.id.btn_ad).setOnClickListener(this);
        findViewById(R.id.btn_proxy_cache).setOnClickListener(this);
        findViewById(R.id.btn_play_list).setOnClickListener(this);
        findViewById(R.id.btn_pad).setOnClickListener(this);
        findViewById(R.id.btn_custom_exo_player).setOnClickListener(this);
        findViewById(R.id.btn_custom_ijk_player).setOnClickListener(this);
        findViewById(R.id.btn_definition).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getActivity(), "抄的DK这些直接去DK看", Toast.LENGTH_LONG).show();

    }
}
