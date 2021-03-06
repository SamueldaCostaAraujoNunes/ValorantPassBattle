package br.com.samuelnunes.valorantpassbattle.ui.view.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import br.com.samuelnunes.valorantpassbattle.databinding.DialogRewardBinding
import br.com.samuelnunes.valorantpassbattle.model.dto.Reward
import br.com.samuelnunes.valorantpassbattle.ui.viewModel.dialog.DialogRewardViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DialogReward : DialogBase() {

    private val viewModel: DialogRewardViewModel by viewModels()
    lateinit var binding: DialogRewardBinding
    private val args by navArgs<DialogRewardArgs>()

    private fun getReward(): Reward? {
        val id: Int = args.rewardId
        return viewModel.getRewardById(id, args.origin)
    }

    private fun getOriginTitle(): Int = viewModel.getTitle(args.origin)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DialogRewardBinding.inflate(inflater, container, false)
        val reward = getReward()
        if (reward != null) {
            binding.reward = reward
            binding.lifecycleOwner = this
            binding.titleName = "${getString(getOriginTitle())} ${reward.cap ?: reward.id}"
            binding.indicator = binding.indicatorImageSlider
        }
        return binding.root
    }

}