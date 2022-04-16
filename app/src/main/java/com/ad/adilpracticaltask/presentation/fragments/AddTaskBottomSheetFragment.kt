package com.ad.adilpracticaltask.presentation.fragments

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.ad.adilpracticaltask.R
import com.ad.adilpracticaltask.data.local.model.DataModel
import com.ad.adilpracticaltask.databinding.ActivityMainBinding
import com.ad.adilpracticaltask.databinding.PopupAddTaskBinding
import com.ad.adilpracticaltask.util.DateUtils
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
        binding.tvDate.text = DateUtils.getCurrentDate()
        binding.tvTime.text = DateUtils.getCurrentDate(DateUtils.TIME_FORMAT)
        binding.ivClose.setOnClickListener(this)
        binding.tvSave.setOnClickListener(this)
        binding.tvDate.setOnClickListener(this)
        binding.tvTime.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tvSave -> {
                if (!checkValidation()) {
                    var data=DataModel(binding.edtTask.text.toString(),"","","","",binding.tvTime.text.toString(),binding.alertNotificationSwitch.isChecked,false)

                }
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

    private fun checkValidation(): Boolean {
        var isError = false
        var errMessage = ""
        binding.edtTask.text?.trim()
         if (TextUtils.isEmpty(binding.edtTask.text))
        {
            errMessage=resources.getString(R.string.alert)
            isError= true
        }
        if (isError) {

            Toast.makeText(
                requireContext(),
                errMessage,
                Toast.LENGTH_SHORT
            ).show()
        }

        return isError
    }
}