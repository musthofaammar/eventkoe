package id.eureka.eventkoe.favorite.ui.home

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import id.eureka.eventkoe.favorite.R
import id.eureka.eventkoe.favorite.databinding.FavoriteHomeFragmentBinding

class FavoriteHomeFragment : Fragment(R.layout.favorite_home_fragment) {

    private val binding: FavoriteHomeFragmentBinding by viewBinding()

    companion object {
        fun newInstance() = FavoriteHomeFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setToolbar()

        binding.btnPlayers.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment2_to_playersFragment3)
        }
    }

    private fun setToolbar() {
        (activity as AppCompatActivity).supportActionBar?.title = "Favorites"
        (activity as AppCompatActivity).supportActionBar?.setBackgroundDrawable(
            ColorDrawable(
                resources.getColor(R.color.purple_500)
            )
        )
        setHasOptionsMenu(false)
    }
}