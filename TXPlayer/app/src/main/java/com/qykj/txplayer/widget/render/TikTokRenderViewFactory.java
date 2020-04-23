package com.qykj.txplayer.widget.render;

import android.content.Context;

import com.dueeeke.videoplayer.render.IRenderView;
import com.dueeeke.videoplayer.render.RenderViewFactory;

public class TikTokRenderViewFactory extends RenderViewFactory {

    public static TikTokRenderViewFactory create() {
        return new TikTokRenderViewFactory();
    }

    @Override
    public IRenderView createRenderView(Context context) {
        return new TikTokRenderView(context);
    }
}
