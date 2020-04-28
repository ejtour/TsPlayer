package com.qykj.txplayer.util;

import android.content.Context;

import com.qykj.txplayer.bean.TiktokBean;
import com.qykj.txplayer.bean.VideoBean;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class DataUtil {

    public static final String SAMPLE_URL = "http://vfx.mtime.cn/Video/2019/03/14/mp4/190314223540373995.mp4";


    public static List<VideoBean> getVideoList() {
        List<VideoBean> videoList = new ArrayList<>();

        videoList.add(new VideoBean("CCTV10科教",
                "https://cms-bucket.nosdn.127.net/cb37178af1584c1588f4a01e5ecf323120180418133127.jpeg",
                "https://aldirect.hls.huya.com/src/78941969-2773696425-11912935434407116800-2199063580264-10057-A-0-1_2500.m3u8?wsSecret=3d06f9aa6a52e018dcf488af8a989a4b&wsTime=5ea161ad"));

        videoList.add(new VideoBean("CCTV11戏曲",
                "https://cms-bucket.nosdn.127.net/eb411c2810f04ffa8aaafc42052b233820180418095416.jpeg",
                "http://cctvcnch5c.v.wscdns.com/live/cctv11_2/index.m3u8"));

        videoList.add(new VideoBean("新闻联播",
                "https://cms-bucket.nosdn.127.net/cb37178af1584c1588f4a01e5ecf323120180418133127.jpeg",
                "http://cctvcnch5c.v.wscdns.com/live/cctv12_2/index.m3u8"));

        videoList.add(new VideoBean("CCTV8电视剧",
                "https://cms-bucket.nosdn.127.net/eb411c2810f04ffa8aaafc42052b233820180418095416.jpeg",
                "http://cctvcnch5c.v.wscdns.com/live/cctv8_2/index.m3u8"));

        videoList.add(new VideoBean("CCTV10科教",
                "https://cms-bucket.nosdn.127.net/cb37178af1584c1588f4a01e5ecf323120180418133127.jpeg",
                "http://cctvcnch5c.v.wscdns.com/live/cctv10_2/index.m3u8"));

        videoList.add(new VideoBean("CCTV11戏曲",
                "https://cms-bucket.nosdn.127.net/eb411c2810f04ffa8aaafc42052b233820180418095416.jpeg",
                "http://cctvcnch5c.v.wscdns.com/live/cctv11_2/index.m3u8"));

        videoList.add(new VideoBean("新闻联播",
                "https://cms-bucket.nosdn.127.net/cb37178af1584c1588f4a01e5ecf323120180418133127.jpeg",
                "http://cctvcnch5c.v.wscdns.com/live/cctv12_2/index.m3u8"));

        videoList.add(new VideoBean("CCTV8电视剧",
                "https://cms-bucket.nosdn.127.net/eb411c2810f04ffa8aaafc42052b233820180418095416.jpeg",
                "http://cctvcnch5c.v.wscdns.com/live/cctv8_2/index.m3u8"));

        videoList.add(new VideoBean("CCTV10科教",
                "https://cms-bucket.nosdn.127.net/cb37178af1584c1588f4a01e5ecf323120180418133127.jpeg",
                "http://cctvcnch5c.v.wscdns.com/live/cctv10_2/index.m3u8"));

        videoList.add(new VideoBean("CCTV11戏曲",
                "https://cms-bucket.nosdn.127.net/eb411c2810f04ffa8aaafc42052b233820180418095416.jpeg",
                "http://cctvcnch5c.v.wscdns.com/live/cctv11_2/index.m3u8"));

        videoList.add(new VideoBean("新闻联播",
                "https://cms-bucket.nosdn.127.net/cb37178af1584c1588f4a01e5ecf323120180418133127.jpeg",
                "http://cctvcnch5c.v.wscdns.com/live/cctv12_2/index.m3u8"));

        videoList.add(new VideoBean("CCTV8电视剧",
                "https://cms-bucket.nosdn.127.net/eb411c2810f04ffa8aaafc42052b233820180418095416.jpeg",
                "http://cctvcnch5c.v.wscdns.com/live/cctv8_2/index.m3u8"));

        videoList.add(new VideoBean("CCTV10科教",
                "https://cms-bucket.nosdn.127.net/cb37178af1584c1588f4a01e5ecf323120180418133127.jpeg",
                "http://cctvcnch5c.v.wscdns.com/live/cctv10_2/index.m3u8"));

        videoList.add(new VideoBean("CCTV11戏曲",
                "https://cms-bucket.nosdn.127.net/eb411c2810f04ffa8aaafc42052b233820180418095416.jpeg",
                "http://cctvcnch5c.v.wscdns.com/live/cctv11_2/index.m3u8"));

        videoList.add(new VideoBean("新闻联播",
                "https://cms-bucket.nosdn.127.net/cb37178af1584c1588f4a01e5ecf323120180418133127.jpeg",
                "http://cctvcnch5c.v.wscdns.com/live/cctv12_2/index.m3u8"));

        videoList.add(new VideoBean("CCTV8电视剧",
                "https://cms-bucket.nosdn.127.net/eb411c2810f04ffa8aaafc42052b233820180418095416.jpeg",
                "http://cctvcnch5c.v.wscdns.com/live/cctv8_2/index.m3u8"));

        videoList.add(new VideoBean("CCTV10科教",
                "https://cms-bucket.nosdn.127.net/cb37178af1584c1588f4a01e5ecf323120180418133127.jpeg",
                "http://cctvcnch5c.v.wscdns.com/live/cctv10_2/index.m3u8"));

        videoList.add(new VideoBean("CCTV11戏曲",
                "https://cms-bucket.nosdn.127.net/eb411c2810f04ffa8aaafc42052b233820180418095416.jpeg",
                "http://cctvcnch5c.v.wscdns.com/live/cctv11_2/index.m3u8"));

        videoList.add(new VideoBean("新闻联播",
                "https://cms-bucket.nosdn.127.net/cb37178af1584c1588f4a01e5ecf323120180418133127.jpeg",
                "http://cctvcnch5c.v.wscdns.com/live/cctv12_2/index.m3u8"));

        return videoList;
    }

    public static List<TiktokBean> tiktokData;

    public static List<TiktokBean> getTiktokDataFromAssets(Context context) {
        try {
            if (tiktokData == null) {
                InputStream is = context.getAssets().open("tiktok_data");
                int length = is.available();
                byte[] buffer = new byte[length];
                is.read(buffer);
                is.close();
                String result = new String(buffer, Charset.forName("UTF-8"));
                tiktokData = TiktokBean.arrayTiktokBeanFromData(result);
            }
            return tiktokData;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

}
