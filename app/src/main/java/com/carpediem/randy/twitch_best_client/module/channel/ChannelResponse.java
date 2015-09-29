package com.carpediem.randy.twitch_best_client.module.channel;

import android.util.Log;

import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

import retrofit.Converter;

/**
 * Created by randy on 15-9-28.
 */
public class ChannelResponse implements Model{
    public static Converter<ChannelResponse> converter = new Converter<ChannelResponse>() {
        @Override
        public ChannelResponse fromBody(ResponseBody body) throws IOException {
            Log.i("Test",body.string());
            return null;
        }

        @Override
        public RequestBody toBody(ChannelResponse value) {
            return null;
        }
    };

    @Override
    public Converter getConverter() {
      return converter;
    }



}
