package com.example.digikalamvvm.network;

import com.example.digikalamvvm.model.CatModel;
import com.example.digikalamvvm.model.HomeModel;
import com.example.digikalamvvm.model.TimerModel;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface  Api {

    @GET("home.php")
    Single<HomeModel> ListSlider();

    @GET("cat.php")
    Single<CatModel> Cat();

    @GET("timer.php")
    Single<TimerModel> Timer();

  /*  @GET("index.php")
    Single<List<Datamodel>> Listdatamodel();
    @FormUrlEncoded
    @POST("login.php")
    Single<Status> singlestaus(@Field("mobile") String mobile, @Field("pass") String pass);
    @FormUrlEncoded
    @POST("reg.php")
    Single<Status> Single_register(@Field("n") String n, @Field("m") String m, @Field("e") String e, @Field("p") String p);4


     @POST("tweet")
    Call<TweetModel> createNewTweet(@Body TweetModel tweetModel);

    @GET("tweet")
    Call<List<TweetModel>> getTweets();

    @GET("tweet/{id}")
    Call<TweetModel> getTweetById(@Path("id") String tweetId);

    @PUT("tweet/{id}")
    Call<TweetModel> updateTweetById(@Path("id") String tweetId, @Body TweetModel tweetModel);

    @DELETE("tweet/{id}")
    Call<OperationResultModel> deleteTweetById(@Path("id") String tweetId);

    @POST("signup")
    Call<AuthenticationResponseModel> signUp(@Body SignUpRequestModel signUpRequestModel);

    @POST("signin")
    Call<AuthenticationResponseModel> signIn(@Body SignInRequestModel signInRequestModel);

    @DELETE("user/app")
    Call<OperationResultModel> terminateApp();

    @PUT("user/profile")
    Call<UserModel> updateUserProfile(@Body UserModel userModel);

    @Multipart
    @POST("user/profile/image")
    Call<UserModel> uploadUserProfileImage(@Header("Authorization") String authHeader, @PartMap Map<String, RequestBody> map);

    @DELETE("tokens")
    Call<OperationResultModel> removeAllAccessToken();

    @POST("refreshtoken")
    Call<TokenModel> getRefreshToken(@Body RefreshTokenRequestModel refreshTokenRequestModel);

    @GET("tweet")
    Call<List<TweetModel>> getTweetsByFeel(@Query("feel") String feel);


   */


}
