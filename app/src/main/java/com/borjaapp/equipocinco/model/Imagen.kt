package com.borjaapp.equipocinco.model
import com.google.gson.annotations.SerializedName

data class Imagen (
    @SerializedName("message") val url: String,
    @SerializedName("status") val status: String
)