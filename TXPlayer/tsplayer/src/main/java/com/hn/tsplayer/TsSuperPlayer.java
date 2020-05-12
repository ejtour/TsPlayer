package com.hn.tsplayer;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.widget.Toast;

import com.dueeeke.videoplayer.player.AbstractPlayer;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.rtmp.ITXVodPlayListener;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXVodPlayConfig;
import com.tencent.rtmp.TXVodPlayer;

import java.util.Map;

public class TsSuperPlayer extends AbstractPlayer implements ITXVodPlayListener {


    private Context mAppContext;

    private TXVodPlayer mVodPlayer;
    private TXVodPlayConfig mVodPlayConfig;
    private String mPlayUrl, mFileId;
    private boolean mVideoPlay = false;

    public TsSuperPlayer(Context context) {
        mAppContext = context;
    }

    @Override
    public void initPlayer() {
        if (this.mVodPlayer == null) {
            this.mVodPlayer = new TXVodPlayer(mAppContext);
            this.mVodPlayConfig = new TXVodPlayConfig();
            this.mVodPlayConfig.setMaxCacheItems(10);
            this.mVodPlayer.setConfig(this.mVodPlayConfig);
            this.mVodPlayer.setRenderMode(1);
            this.mVodPlayer.setVodListener(this);
            this.mVodPlayer.enableHardwareDecode(false);
        }
        mVideoPlay = false;

    }

    @Override
    public void setDataSource(String path, Map<String, String> headers) {
        if (!TextUtils.isEmpty(path)) {
            mPlayUrl = path;
        } else {
            if (headers != null && headers.size() > 0) {
                mFileId = headers.get("fileId");
            }
        }
    }

    @Override
    public void setDataSource(AssetFileDescriptor fd) {
    }

    @Override
    public void start() {

        Log.e("==>>", "ts==>>start()");

        resume();

    }

    private void resume() {
        if (this.mVodPlayer != null) {
            this.mVodPlayer.resume();
        }
    }


    @Override
    public void pause() {

        Log.e("==>>", "tsPlayer pause()");

        if (this.mVodPlayer != null) {
            this.mVodPlayer.pause();
        }
    }

    @Override
    public void stop() {
        try {
            mVodPlayer.stopPlay(false);
            mVideoPlay = false;
        } catch (IllegalStateException e) {
            mPlayerEventListener.onError();
        }
    }

    @Override
    public void prepareAsync() {

        playVodURL(mPlayUrl);
    }


    @Override
    public void reset() {
    }

    @Override
    public boolean isPlaying() {
        if (this.mVodPlayer != null) {
            return this.mVodPlayer.isPlaying();
        }
        return false;
    }

    @Override
    public void seekTo(long time) {

        if (mVodPlayer != null) {
            mVodPlayer.seek(time / 1000);
        }
    }

    @Override
    public void release() {

        if (this.mVodPlayer != null) {
            this.mVodPlayer.setVodListener(null);
            this.mVodPlayer.stopPlay(false);
        }

    }

    @Override
    public long getCurrentPosition() {
        if (this.mVodPlayer != null) {
            return (long) (this.mVodPlayer.getCurrentPlaybackTime() * 1000);
        }
        return 0;
    }

    @Override
    public long getDuration() {
        //超级播放器返回的单位是s  dk 用的是ms
        if (this.mVodPlayer != null) {
            return (long) this.mVodPlayer.getDuration() * 1000;
        }
        return 0;
    }

    @Override
    public int getBufferedPercentage() {
        TXCLog.d("SuperPlayerView", "mVodPlayer.getBufferDuration()=" + mVodPlayer.getBufferDuration());
        return 0;
    }

    @Override
    public void setSurface(Surface surface) {
        if (this.mVodPlayer != null) {
            this.mVodPlayer.setSurface(surface);
            playVodURL(mPlayUrl);
        }
    }

    @Override
    public void setDisplay(SurfaceHolder holder) {
    }

    @Override
    public void setVolume(float v1, float v2) {
        if (this.mVodPlayer != null) {
            //此为静音
            mVodPlayer.setMute(v1 == 0.0f);
        }
    }

    @Override
    public void setLooping(boolean isLooping) {
        if (this.mVodPlayer != null) {
            this.mVodPlayer.setLoop(isLooping);
        }
    }

    @Override
    public void setOptions() {
    }

    private float mSpeed = 1;

    @Override
    public void setSpeed(float speed) {

        Log.e("==>>", "setSpeed" + speed / 1000);
        mSpeed = speed;
        if (this.mVodPlayer != null) {
            this.mVodPlayer.setRate(speed / 1000);
        }
    }

    @Override
    public float getSpeed() {
        return mSpeed;
    }

    @Override
    public long getTcpSpeed() {
        return 0;
    }


    @Override
    public void onPlayEvent(TXVodPlayer txVodPlayer, int event, Bundle bundle) {
        if (event != 2005) {
            Log.e("jyj------>", "----event------->" + event + "-----bundle---->" + bundle.toString());
        }
        onPlayEvent(event, bundle);
    }

    private void onPlayEvent(int event, Bundle param) {
        if (event != 2005) {
            String playEventLog = "TXLivePlayer onPlayEvent event: " + event + ", " + param.getString("EVT_MSG");
            Log.e("===>>", playEventLog);
        }

        switch (event) {
            case TXLiveConstants.PLAY_ERR_STREAM_SWITCH_FAIL:
                //2307 清晰度切换失败
                Toast.makeText(mAppContext, "清晰度切换失败", Toast.LENGTH_SHORT).show();
                break;
            case TXLiveConstants.PLAY_ERR_NET_DISCONNECT:
                //2301
                mPlayerEventListener.onError();
                break;
            case TXLiveConstants.PLAY_ERR_FILE_NOT_FOUND:
                break;
            case TXLiveConstants.PLAY_EVT_PLAY_END:
                //2006 播放完成
                mPlayerEventListener.onCompletion();
                break;
            case TXLiveConstants.PLAY_EVT_RCV_FIRST_I_FRAME:
                //2003 点播显示首帧画面
                mVodPlayer.resume();
                mPlayerEventListener.onPrepared();
                mPlayerEventListener.onInfo(MEDIA_INFO_VIDEO_RENDERING_START, -1);
                break;
            case TXLiveConstants.PLAY_EVT_PLAY_BEGIN:
                //2004 播放开始
//                mPlayerEventListener.onPrepared();
//                mPlayerEventListener.onInfo(MEDIA_INFO_VIDEO_RENDERING_START, -1);
                break;
            case TXLiveConstants.PLAY_EVT_PLAY_PROGRESS:
                // 2005 播放进度
                break;
            case TXLiveConstants.PLAY_EVT_PLAY_LOADING:
                //2007开始缓冲
                mPlayerEventListener.onInfo(MEDIA_INFO_BUFFERING_START, -1);

                break;
            case TXLiveConstants.PLAY_WARNING_RECONNECT:

                break;
            case TXLiveConstants.PLAY_EVT_VOD_LOADING_END:
                //2014缓冲结束
                mPlayerEventListener.onInfo(MEDIA_INFO_BUFFERING_END, -1);

                break;
            case TXLiveConstants.PLAY_EVT_VOD_PLAY_PREPARED:
                //2013点播准备完成
                mPlayerEventListener.onInfo(MEDIA_INFO_BUFFERING_END, -1);
                break;
            case 2016:
                //点播解码失败
                mPlayerEventListener.onError();
                break;
            case TXLiveConstants.PLAY_EVT_STREAM_SWITCH_SUCC:
                //清晰度切换成功
                Toast.makeText(this.mAppContext, "清晰度切换成功", Toast.LENGTH_SHORT).show();
                break;
        }

    }


    @Override
    public void onNetStatus(TXVodPlayer txVodPlayer, Bundle bundle) {

    }


    private void playVodURL(String url) {

        if (url == null || "".equals(url)) {
            return;
        }


        stopPlay(false);

        if (mVodPlayer != null) {
            mVodPlayer.setStartTime(0);
            mVodPlayer.setAutoPlay(true);
            mVodPlayer.setVodListener(this);
            mVodPlayer.setToken(null);

            int ret = mVodPlayer.startPlay(url);
            mVideoPlay = ret == 0;

        }
    }


    private void stopPlay(boolean isNeedClearLastImg) {
        if (this.mVodPlayer != null) {
            this.mVodPlayer.setVodListener(null);
            this.mVodPlayer.stopPlay(isNeedClearLastImg);
        }
    }
}
