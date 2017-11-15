package com.lqm.mvpstudy.retrofit;

import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;
import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.http.PartMap;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * user：lqm
 * desc：
 */

public interface IUserBiz {

    /**
     * 可以看到我们定义了一个getUser方法，方法接收一个username参数，
     * 并且我们的@GET注解中使用{username}声明了访问路径，
     * 这里你可以把{username}当做占位符，而实际运行中会通过@PATH("username")所标注的参数进行替换
     * @param username
     * @return
     */
    @GET("{username}")
    Call<User> getUser(@Path("username") String username);

    @GET("users")
    Call<List<User>> getUsersBySort(@Query("sortby") String sort);


    @POST("add")
    Call<List<User>> addUser(@Body User user);


    /**
     * 表单的方式传递键值对@FormUrlEncoded
     * @param username
     * @param password
     * @return
     */
    @POST("login")
    @FormUrlEncoded
    Call<User> login(@Field("username") String username, @Field("password") String password);

    /**
     * 单文件上传@Multipart
     */
//    @Multipart
//    @POST("register")
//    Call<User> registerUser(@Part MultipartBody.Part photo, @Part("username") RequestBody username, @Part("password") RequestBody password);


    /**
     * 多文件上传@PartMap
     */
    @Multipart
    @POST("register")
    Call<User> registerUser(@PartMap Map<String, RequestBody> params, @Part("password") RequestBody password);
































}
