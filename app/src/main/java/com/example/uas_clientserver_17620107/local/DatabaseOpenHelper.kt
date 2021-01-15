package com.example.uas_clientserver_17620107.local

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.uas_clientserver_17620107.common.domain.model.Events
import org.jetbrains.anko.db.*

const val DATABASE_NAME = "EventsTeam.db"
class DatabaseOpenHelper(context: Context)
    : ManagedSQLiteOpenHelper(context, DATABASE_NAME, null,1) {

    companion object {
        private var instance : DatabaseOpenHelper? = null

        @Synchronized
        fun getInstances(context: Context) : DatabaseOpenHelper {

           return when (instance) {
                null -> {
                    instance = DatabaseOpenHelper(context)
                    instance as DatabaseOpenHelper
                } else -> instance as DatabaseOpenHelper
            }
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        //create table
        db?.createTable(
            Events.TABLE_FAVORITE, true,
                Events.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                Events.ID_EVENT to TEXT + UNIQUE,
                Events.HOME_TEAM to TEXT,
                Events.AWAY_TEAM to TEXT,
                Events.HOME_SCORE to TEXT,
                Events.AWAY_SCORE to TEXT,
                Events.HOME_SHOT to TEXT,
                Events.AWAY_SHOT to TEXT,
                Events.DATE_EVENT to TEXT,
                Events.HOME_GOAL_DETAIL to TEXT,
                Events.HOME_LINEUP_GOALKEEPER to TEXT,
                Events.HOME_LINEUP_DEFENCE to TEXT,
                Events.HOME_LINEUP_MIDFIELD to TEXT,
                Events.HOME_LINEUP_FORWARD to TEXT,
                Events.HOME_LINEUP_SUBTITUTIES to TEXT,
                Events.HOME_BADGE to TEXT,
                Events.AWAY_GOAL_DETAIL to TEXT,
                Events.AWAY_LINEUP_GOALKEEPER to TEXT,
                Events.AWAY_LINEUP_DEFENCE to TEXT,
                Events.AWAY_LINEUP_MIDFIELD to TEXT,
                Events.AWAY_LINEUP_FORWARD to TEXT,
                Events.AWAY_LINEUP_SUBTITUTIES to TEXT,
                Events.AWAY_BADGE to TEXT
                )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.dropTable(Events.TABLE_FAVORITE, true)
    }

}

// Access property for Context
val Context.database: DatabaseOpenHelper
    get() = DatabaseOpenHelper.getInstances(applicationContext)