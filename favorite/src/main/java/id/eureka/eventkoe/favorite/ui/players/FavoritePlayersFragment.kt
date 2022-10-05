package id.eureka.eventkoe.favorite.ui.players

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import id.eureka.dotakoe.core.ui.PlayersAdapter
import id.eureka.eventkoe.favorite.R
import id.eureka.eventkoe.favorite.databinding.FavoritePlayersFragmentBinding
import org.koin.android.viewmodel.ext.android.viewModel

class FavoritePlayersFragment : Fragment(R.layout.favorite_players_fragment) {

    private val binding: FavoritePlayersFragmentBinding by viewBinding()
    private val viewModelFavorite: FavoritePlayersViewModel by viewModel()
    private val adapter by lazy { PlayersAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setToolbar()
        setRecyclerView()
        getData()
    }

    private fun setToolbar() {
        (activity as AppCompatActivity).supportActionBar?.title = "Players"
        (activity as AppCompatActivity).supportActionBar?.setBackgroundDrawable(
            ColorDrawable(
                resources.getColor(R.color.purple_500)
            )
        )
        setHasOptionsMenu(false)
    }

    private fun setRecyclerView() {
        adapter.onItemClick = { selectedData ->
            val action =
                FavoritePlayersFragmentDirections.actionPlayersFragmentToPlayerDetailFragment(
                    selectedData
                )

            binding.root.findNavController().navigate(action)
        }

        binding.rvPlayers.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@FavoritePlayersFragment.adapter
        }
    }

    private fun getData() {
        viewModelFavorite.getFavoriteProPlayer().observe(viewLifecycleOwner, { favorites ->
            adapter.setData(favorites)
            if (!favorites.isNullOrEmpty()) {
                binding.viewError.root.visibility = View.GONE
            } else {
                binding.viewError.tvError.text = "Favorite is Empty"
                binding.viewError.root.visibility = View.VISIBLE
            }
        })
    }

}