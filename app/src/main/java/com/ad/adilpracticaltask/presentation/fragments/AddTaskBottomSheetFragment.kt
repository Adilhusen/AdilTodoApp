package com.ad.adilpracticaltask.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ad.adilpracticaltask.R
import com.ad.adilpracticaltask.databinding.ActivityMainBinding
import com.ad.adilpracticaltask.databinding.PopupAddTaskBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

class AddTaskBottomSheetFragment : BottomSheetDialogFragment(), View.OnClickListener {
    private lateinit var binding: PopupAddTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = PopupAddTaskBinding.inflate(layoutInflater)
        return (binding.root)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding.ivClose.setOnClickListener(this)
        binding.tvSave.setOnClickListener(this)
        binding.tvDate.setOnClickListener(this)
        binding.tvTime.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tvSave -> {

            }
            R.id.tvDate -> {

            }
            R.id.tvTime -> {

            }
            R.id.ivClose -> {
                dismiss()
            }

        }
    }
}