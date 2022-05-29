package com.prmto.cryptocrazycompose.service

import com.prmto.cryptocrazycompose.model.Crypto
import com.prmto.cryptocrazycompose.model.CryptoList
import com.prmto.cryptocrazycompose.util.Constant
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoAPI {

    @GET("prices")
    suspend fun getCryptoList(
        @Query("key") key: String = Constant.API_KEY,
    ): CryptoList

    @GET("currencies")
    suspend fun getCrypto(
        @Query("key") key: String = Constant.API_KEY,
        @Query("ids") id: String,
        @Query("attributes") attributes: String
    ): Crypto
}