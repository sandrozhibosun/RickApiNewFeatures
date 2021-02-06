package com.apolis.corutinedaggerrick.data.models

data class GetCharacterResponse(
    val info: Info,
    var results: ArrayList<Character>
)