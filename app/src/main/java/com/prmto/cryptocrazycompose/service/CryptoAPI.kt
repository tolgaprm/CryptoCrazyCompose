package com.prmto.cryptocrazycompose.service

import com.prmto.cryptocrazycompose.model.Crypto
import com.prmto.cryptocrazycompose.model.CryptoList
import com.prmto.cryptocrazycompose.util.Constant
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoAPI {

    @GET("cryptolist.json")
    suspend fun getCryptoList(
    ): CryptoList

    @GET("crypto.json")
    suspend fun getCrypto(
        @Query("ids") id: String,
        @Query("attributes") attributes: String
    ): Crypto
}