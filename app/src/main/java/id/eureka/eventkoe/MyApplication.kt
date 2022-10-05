package id.eureka.eventkoe

import android.app.Application
import id.eureka.dotakoe.core.di.databaseModule
import id.eureka.dotakoe.core.di.networkModule
import id.eureka.dotakoe.core.di.repositoryModule
import id.eureka.eventkoe.di.useCaseModule
import id.eureka.eventkoe.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule,
                )
            )
        }
    }
}