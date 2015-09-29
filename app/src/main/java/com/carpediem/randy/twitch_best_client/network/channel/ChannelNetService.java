package com.carpediem.randy.twitch_best_client.network.channel;

import com.carpediem.randy.twitch_best_client.base.AppContants;
import com.carpediem.randy.twitch_best_client.module.channel.ChannelResponse;
import com.carpediem.randy.twitch_best_client.util.TextUtil;

import java.io.IOException;

import retrofit.Call;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by randy on 15-9-28.
 */

public class ChannelNetService {
    private static final String TAG = "ChannelNetService";
    interface IChannel {
        @GET("/{user}/channels/{channel}")
        Call<ChannelResponse> getChannelObject(@Path("user") String username,
                                               @Path("channel") String channel);
    }

    /**
     *
     * @param username
     * @param channel
     * @return
     */
    public static ChannelResponse getChannelObject(String username,String channel) {
        if (TextUtil.isNullOrEmpty(username) || TextUtil.isNullOrEmpty(channel)) {
            throw new IllegalArgumentException(TAG+"getChannelObject");
        }


        ChannelResponse response = null;



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppContants.BASE_URL)
                .addConverter(ChannelResponse.class,ChannelResponse.converter)
                .build();
        IChannel service = retrofit.create(IChannel.class);
        Call<ChannelResponse> channelCall = service.getChannelObject(username,channel);

        try {
            response = channelCall.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

}
