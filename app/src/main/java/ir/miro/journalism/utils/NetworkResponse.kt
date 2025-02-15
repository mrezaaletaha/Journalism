package ir.miro.journalism.utils

import ir.miro.journalism.data.sources.network.NetworkNews

/**
 * @author mrezaaletaha
 */

data class NetworkResponse(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<NetworkNews>
)