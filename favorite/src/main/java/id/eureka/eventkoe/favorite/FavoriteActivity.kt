package id.eureka.eventkoe.favorite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.eureka.eventkoe.favorite.di.favoriteModule
import org.koin.core.context.loadKoinModules

class FavoriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)
        loadKoinModules(favoriteModule)
    }
}