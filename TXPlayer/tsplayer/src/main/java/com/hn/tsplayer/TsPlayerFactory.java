package com.hn.tsplayer;

import android.content.Context;

import com.dueeeke.videoplayer.player.PlayerFactory;

public class TsPlayerFactory extends PlayerFactory<TsSuperPlayer> {

    public static TsPlayerFactory create() {
        return new TsPlayerFactory();
    }

    @Override
    public TsSuperPlayer createPlayer(Context context) {
        return new TsSuperPlayer(context);
    }
}
