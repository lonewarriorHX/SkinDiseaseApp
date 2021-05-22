package com.example.submission3jetpackhanvey.utility

import androidx.sqlite.db.SimpleSQLiteQuery

object Helper {
    const val BEST_VOTE = "Best"
    const val WORST_VOTE = "Worst"
    const val RANDOM_VOTE = "Random"
    const val MOVIE_ENTITIES = "movie_entities"
    const val TV_SHOW_ENTITIES = "tv_show_entities"

    fun getSortedQuery(filter: String, table_name: String): SimpleSQLiteQuery {
        val simpleQuery = StringBuilder().append("SELECT * FROM $table_name ")
        when (filter) {
            BEST_VOTE -> simpleQuery.append("ORDER BY score DESC")
            WORST_VOTE -> simpleQuery.append("ORDER BY score ASC")
            RANDOM_VOTE -> simpleQuery.append("ORDER BY RANDOM()")
        }
        return SimpleSQLiteQuery(simpleQuery.toString())
    }
}