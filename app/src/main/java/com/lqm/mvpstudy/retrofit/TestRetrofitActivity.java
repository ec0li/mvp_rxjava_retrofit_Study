package com.lqm.mvpstudy.retrofit;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * user：lqm
 * desc：
 */

public class TestRetrofitActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("www.baidu.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IUserBiz userBiz = retrofit.create(IUserBiz.class);
        //省略了retrofit的构建代码
        Call<User> call = userBiz.getUser("zhy");
        call.enqueue(new Callback<User>()
        {

            @Override
            public void onResponse(Response<User> response, Retrofit retrofit) {

            }

            @Override
            public void onFailure(Throwable t) {

            }

//            @Override
//            public void onResponse(Call<User> call, Response<User> response)
//            {
//                Log.e(TAG, "getUsePath:" + response.body());
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t)
//            {
//
//            }
        });

    }

}
