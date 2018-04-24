package com.example.times.di.module;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.times.db.AppDatabase;
import com.example.times.db.TopStoryDao;
import com.example.times.di.RepoScope;
import com.example.times.network.HeaderInterceptor;
import com.example.times.network.NetWorkService;
import com.example.times.network.NetworkClient;
import com.example.times.utils.Constants;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Karishma on 17/4/18.
 */

@Module
public class RepoModule {

    @RepoScope
    @Provides
    Retrofit getRetrofit(OkHttpClient.Builder httpClient){
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @RepoScope
    @Provides
    OkHttpClient.Builder getClient(Context context){

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new HeaderInterceptor(context));
        httpClient.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        httpClient.connectTimeout(5000, TimeUnit.SECONDS);
        httpClient.readTimeout(5000,TimeUnit.SECONDS);
        httpClient.writeTimeout(5000,TimeUnit.SECONDS);

        return httpClient;
    }


    @RepoScope
    @Provides
    NetWorkService getNetworkService(Retrofit retrofit){
        return retrofit.create(NetWorkService.class);
    }

    @RepoScope
    @Provides
    public NetworkClient getRetrofitClient(Context context,NetWorkService service){
        return new NetworkClient(context,service);
    }

    @Provides
    AppDatabase getDatabase(Context app) {
        return Room.databaseBuilder(app,
                AppDatabase.class, Constants.DATABASE_NAME).build();
    }

    @RepoScope
    @Provides
    TopStoryDao getTopStoriesDao(AppDatabase database){
        return database.getTopStoryDao();
    }

}
