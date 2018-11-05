package chirikualii.com.footballapps.di

import android.app.Application
import android.content.Context
import chirikualii.com.footballapps.BuildConfig
import chirikualii.com.footballapps.data.api.ApiService
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by chirikualii on {DATE}
 */
@Module
class AppModule {

    @Provides
    fun provideApplication(app: Application): Context = app

    @Provides
    @Singleton
    fun provideRetorfit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
    }
    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

}