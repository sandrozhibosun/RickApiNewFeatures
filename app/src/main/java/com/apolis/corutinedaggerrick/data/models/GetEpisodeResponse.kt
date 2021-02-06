package com.apolis.corutinedaggerrick.data.models



data class GetEpisodeResponse(
    val info: InfoX,
    val results: ArrayList<Episode>
)