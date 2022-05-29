package com.prmto.cryptocrazycompose.repo

import com.prmto.cryptocrazycompose.model.Crypto
import com.prmto.cryptocrazycompose.model.CryptoList
import com.prmto.cryptocrazycompose.util.Resource

interface CryptoRepository {

    suspend fun getCryptoList(): Resource<CryptoList>

    suspend fun getCrypto(id: String): Resource<Crypto>
}