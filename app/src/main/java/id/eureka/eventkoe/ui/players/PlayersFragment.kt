package id.eureka.eventkoe.ui.players

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import id.eureka.dotakoe.core.data.source.Resource
import id.eureka.dotakoe.core.ui.PlayersAdapter
import id.eureka.eventkoe.R
import id.eureka.eventkoe.databinding.PlayersFragmentBinding
import org.koin.android.viewmodel.ext.android.viewModel

class PlayersFragment : Fragment(R.layout.players_fragment) {

    private val binding: PlayersFragmentBinding by viewBinding()
    private val viewModel: PlayersViewModel by viewModel()
    private val adapter by lazy { PlayersAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView()
        setToolbar()
    }

    override fun onResume() {
        super.onResume()
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

    private fun getData() {
        viewModel.getAllProPlayer().observe(viewLifecycleOwner, { result ->
            when (result) {
                is Resource.Error -> {
                    binding.progressBar.visibility = View.GONE
                    binding.viewError.root.visibility = View.VISIBLE
                    binding.viewError.tvError.text =
                        result.message ?: getString(R.string.something_wrong)
                }

                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }

                is Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    result.data?.let { adapter.setData(it) }
                }
            }
        })
    }

    private fun setRecyclerView() {

        adapter.onItemClick = { selectedData ->
            val action =
                PlayersFragmentDirections.actionPlayersFragmentToPlayerDetailFragment(
                    selectedData
                )

            binding.root.findNavController().navigate(action)
        }

        binding.rvPlayers.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@PlayersFragment.adapter
        }
    }
}