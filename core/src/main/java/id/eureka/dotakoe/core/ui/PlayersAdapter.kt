package id.eureka.dotakoe.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import id.eureka.dotakoe.core.databinding.ItemPlayersBinding
import id.eureka.dotakoe.core.domain.model.ProPlayer

class PlayersAdapter : RecyclerView.Adapter<PlayersAdapter.PlayersHolder>() {

    private val players = mutableListOf<ProPlayer>()
    var onItemClick: ((ProPlayer) -> Unit)? = null

    inner class PlayersHolder(private val binding: ItemPlayersBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(proPlayer: ProPlayer) {
            with(binding) {
                tvPlayerName.text = proPlayer.personName
                tvTeamName.text = proPlayer.teamName

                root.setOnClickListener {
                    onItemClick?.invoke(proPlayer)
                }
            }
        }
    }

    fun setData(newData: List<ProPlayer>) {
        val diffCallback = PlayersDiffUtilsCallback(players, newData)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        players.clear()
        players.addAll(newData)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayersHolder {
        return PlayersHolder(
            ItemPlayersBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PlayersHolder, position: Int) {
        holder.bind(players[position])
    }

    override fun getItemCount(): Int {
        return players.size
    }


}

class PlayersDiffUtilsCallback(
    private val oldList: List<ProPlayer>,
    private val newList: List<ProPlayer>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].accountId == newList[newItemPosition].accountId
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

}