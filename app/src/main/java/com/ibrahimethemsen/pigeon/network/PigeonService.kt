package com.ibrahimethemsen.pigeon.network

import com.ibrahimethemsen.models.Currency
import retrofit2.http.GET

interface PigeonService {
    @GET("currency")
    suspend fun getCurrency() : List<Currency>
}