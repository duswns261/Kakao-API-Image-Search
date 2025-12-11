package com.cret.kakaoimagesearch.model

import com.google.gson.annotations.SerializedName

data class SearchNetworkResponse(
    @SerializedName("meta")
    val meta: Meta,
    @SerializedName("documents")
    val documents: List<Document>
)
