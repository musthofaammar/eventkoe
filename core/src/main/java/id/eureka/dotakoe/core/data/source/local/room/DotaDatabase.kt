package id.eureka.dotakoe.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import id.eureka.dotakoe.core.data.source.local.entity.ProPlayerEntity

@Database(entities = [ProPlayerEntity::class], version = 1, exportSchema = false)
abstract class DotaDatabase : RoomDatabase() {
    abstract fun proPlayerDao(): ProPlayerDao
}