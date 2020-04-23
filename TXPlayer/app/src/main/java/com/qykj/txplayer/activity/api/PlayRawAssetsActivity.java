package com.qykj.txplayer.activity.api;

import android.view.View;

import com.dueeeke.videocontroller.StandardVideoController;
import com.qykj.txplayer.R;
import com.qykj.txplayer.activity.BaseActivity;
import com.qykj.txplayer.util.Utils;

/**
 * 播放raw/assets视频
 */

public class PlayRawAssetsActivity extends BaseActivity {

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_play_raw_assets;
    }

    @Override
    protected int getTitleResId() {
        return R.string.str_raw_or_assets;
    }

    @Override
    protected void initView() {
        super.initView();
        mVideoView = findViewById(R.id.player);
        StandardVideoController controller = new StandardVideoController(this);
        controller.addDefaultControlComponent(getString(R.string.str_raw_or_assets), false);
        mVideoView.setVideoController(controller);
    }

    public void onButtonClick(View view) {
        mVideoView.release();
        Object playerFactory = Utils.getCurrentPlayerFactory();



        mVideoView.start();
    }
}
