package com.hlub.dev.chatfirebasedemo.fragment;

import com.hlub.dev.chatfirebasedemo.notification.MyResponse;
import com.hlub.dev.chatfirebasedemo.notification.Sender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {
    @Headers(
            {
                    "Content-Type:application/json",
                    "Authorization:key=AAAAsL_wyg4:APA91bE69N_5c3E4knRwKBYpi2oW0q9jA9l9IwIC7fatAMbrbKxGEk99J47YnbmYQObTHuM1du_5ggt4kwCmQs45KqHiX9ygFUuC_I4d-rE_MBwjp1aZv85iIBlUlhS_NBaQjQWo1O0J"
            }
    )

    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body Sender body);
}
