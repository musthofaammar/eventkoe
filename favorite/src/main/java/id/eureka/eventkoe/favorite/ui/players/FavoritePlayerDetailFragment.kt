package id.eureka.eventkoe.favorite.ui.players

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import id.eureka.dotakoe.core.utils.DateUtils
import id.eureka.eventkoe.favorite.R
import id.eureka.eventkoe.favorite.databinding.FavoritePlayerDetailFragmentBinding
import org.koin.android.viewmodel.ext.android.viewModel

class FavoritePlayerDetailFragment : Fragment(R.layout.favorite_player_detail_fragment) {

    private val args: FavoritePlayerDetailFragmentArgs by navArgs()
    private val viewModel: FavoritePlayerDetailViewModel by viewModel()
    private val binding: FavoritePlayerDetailFragmentBinding by viewBinding()

    private var statusFavorite: Boolean = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getExtra()

        setToolbar()
    }

    private fun setToolbar() {
        (activity as AppCompatActivity).supportActionBar?.title = "Detail Player"
        (activity as AppCompatActivity).supportActionBar?.setBackgroundDrawable(
            ColorDrawable(
                resources.getColor(R.color.blue_whale)
            )
        )
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.favorite_detail_menu, menu)
        setFavoriteState(menu)

        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun setFavoriteState(menu: Menu) {
        val favorite = menu.findItem(R.id.action_favorite)
        if (statusFavorite) {
            favorite.icon =
                ContextCompat.getDrawable(requireContext(), R.drawable.ic_baseline_favorite_24)
        } else {
            favorite.icon =
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.ic_baseline_favorite_border_24
                )
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_favorite -> {
                statusFavorite = !statusFavorite
                viewModel.setFavorite(args.extraPlayer, statusFavorite)
                requireActivity().invalidateOptionsMenu()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        setFavoriteState(menu)
        super.onPrepareOptionsMenu(menu)
    }

    private fun getExtra() {
        val player = args.extraPlayer

        statusFavorite = player.favorite

        binding.tvPlayerName.text = player.name
        binding.tvTeamName.text = player.teamName
        binding.tvPlayerRealName.text = "Person Name : ${player.personName}"
        binding.tvLastLogin.text =
            "Last Match : ${DateUtils.formatDatetimeToDate(player.lastMatchTime)}"
        binding.tvCountry.text = "Region : ${player.countryCode}"


        Glide.with(requireContext())
            .load(player.avatarFull)
            .circleCrop()
            .into(binding.ivPlayer)
    }
}