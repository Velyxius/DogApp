package com.borjaapp.equipocinco.webservice

import com.borjaapp.equipocinco.utils.Constants.END_POINT_BREEDS
import com.borjaapp.equipocinco.utils.Constants.END_POINT_IMAGES
import com.borjaapp.equipocinco.model.BreedResponse
import com.borjaapp.equipocinco.model.Imagen
import retrofit2.http.GET

interface ApiService {

    @GET(END_POINT_IMAGES)
    suspend fun getRandomImage(): Imagen

    @GET(END_POINT_BREEDS)
    suspend fun getBreeds(): BreedResponse
}
