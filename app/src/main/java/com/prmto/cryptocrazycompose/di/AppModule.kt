package com.prmto.cryptocrazycompose.di

import com.prmto.cryptocrazycompose.repo.CryptoRepository
import com.prmto.cryptocrazycompose.repo.CryptoRepositoryImp
import com.prmto.cryptocrazycompose.service.CryptoAPI
import com.prmto.cryptocrazycompose.util.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun injectRetrofit(): CryptoAPI {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CryptoAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api: CryptoAPI): CryptoRepository {
        return CryptoRepositoryImp(api)
    }

}