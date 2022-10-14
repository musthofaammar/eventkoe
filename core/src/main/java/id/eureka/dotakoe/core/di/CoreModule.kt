package id.eureka.dotakoe.core.di

import androidx.room.Room
import id.eureka.dotakoe.core.data.source.local.ProPlayerLocalDataSource
import id.eureka.dotakoe.core.data.source.local.room.DotaDatabase
import id.eureka.dotakoe.core.data.source.remote.ProPlayerRemoteDataSource
import id.eureka.dotakoe.core.data.source.remote.network.ApiService
import id.eureka.dotakoe.core.data.source.repository.ProPlayerRepository
import id.eureka.dotakoe.core.domain.repository.IProPlayerRepository
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import okhttp3.CertificatePinner
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

        val passPhrase : ByteArray = SQLiteDatabase.getBytes("dotakoe".toCharArray())
        val factory = SupportFactory(passPhrase)

        Room.databaseBuilder(
            androidContext(),
            DotaDatabase::class.java, "dota.db"
        ).fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }
}

val networkModule = module {
    single {
        val hostName = "api.opendota.com"

        val certificatePinner = CertificatePinner.Builder()
            .add(hostName, "sha256/dVXrIfaaz0QX0r9s9REFfj7wuV4d4isukZ0svRmh3oY=")
            .add(hostName, "sha256/FEzVOUp4dF3gI0ZVPRJhFbSJVXR+uQmMH65xhs1glH4=")
            .build()

        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .certificatePinner(certificatePinner)
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