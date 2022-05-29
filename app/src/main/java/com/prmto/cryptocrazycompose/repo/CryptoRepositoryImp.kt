package com.prmto.cryptocrazycompose.repo

import com.prmto.cryptocrazycompose.model.Crypto
import com.prmto.cryptocrazycompose.model.CryptoList
import com.prmto.cryptocrazycompose.service.CryptoAPI
import com.prmto.cryptocrazycompose.util.Constant
import com.prmto.cryptocrazycompose.util.Resource
import javax.inject.Inject

class CryptoRepositoryImp @Inject constructor(
    private val api: CryptoAPI
) : CryptoRepository {

    override suspend fun getCryptoList(): Resource<CryptoList> {
        val response = try {
            api.getCryptoList()

        } catch (e: Exception) {
            return Resource.Error("Error")
        }
        return Resource.Success(response)
    }

    override suspend fun getCrypto(id: String): Resource<Crypto> {
        val response = try {
            api.getCrypto(id = id, attributes = Constant.CALL_ATTRIBUTES)
        } catch (e: Exception) {
            return Resource.Error("error")
        }

        return Resource.Success(response)
    }
}