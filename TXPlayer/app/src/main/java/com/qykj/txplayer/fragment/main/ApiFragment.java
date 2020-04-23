package com.qykj.txplayer.fragment.main;

import android.view.View;
import android.widget.Toast;

import com.qykj.txplayer.R;
import com.qykj.txplayer.fragment.BaseFragment;
import com.qykj.txplayer.util.DataUtil;

public class ApiFragment extends BaseFragment implements View.OnClickListener {

    private static final String VOD_URL = DataUtil.SAMPLE_URL;
    private static final String LIVE_URL = "http://ivi.bupt.edu.cn/hls/cctv6hd.m3u8";

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_api;
    }

    @Override
    protected void initView() {
        super.initView();
        findViewById(R.id.btn_vod).setOnClickListener(this);
        findViewById(R.id.btn_live).setOnClickListener(this);
        findViewById(R.id.btn_raw_assets).setOnClickListener(this);
        findViewById(R.id.btn_parallel_play).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_vod:
            case R.id.btn_live:
            case R.id.btn_raw_assets:
            case R.id.btn_parallel_play:
                Toast.makeText(getActivity(), "抄的DK这些直接去DK看", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
