package id.eureka.dotakoe.core.di

import androidx.room.Room
import id.eureka.dotakoe.core.data.source.local.ProPlayerLocalDataSource
import id.eureka.dotakoe.core.data.source.local.room.DotaDatabase
import id.eureka.dotakoe.core.data.source.remote.ProPlayerRemoteDataSource
import id.eureka.dotakoe.core.data.source.remote.network.ApiService
import id.eureka.dotakoe.core.data.source.repository.ProPlayerRepository
import id.eureka.dotakoe.core.domain.repository.IProPlayerRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory { get<DotaDatabase>().proPlayerDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            DotaDatabase::class.java, "dota.db"
        ).fallbackToDestructiveMigration().build()
    }
}

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }

    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.opendota.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { ProPlayerLocalDataSource(get()) }
    single { ProPlayerRemoteDataSource(get()) }
    single<IProPlayerRepository> { ProPlayerRepository(get(), get()) }
}