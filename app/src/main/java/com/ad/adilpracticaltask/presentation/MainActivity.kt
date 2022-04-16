package com.ad.adilpracticaltask.presentation

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ad.adilpracticaltask.R
import com.ad.adilpracticaltask.base.BaseActivity
import com.ad.adilpracticaltask.data.adapters.TodoAdapter
import com.ad.adilpracticaltask.data.local.model.DataModel
import com.ad.adilpracticaltask.databinding.ActivityMainBinding
import com.ad.adilpracticaltask.presentation.fragments.AddTaskBottomSheetFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    var listAdapter: TodoAdapter? = null
    var mList = ArrayList<DataModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()

    }

    private fun initViews() {
        binding.imgAdd.setOnClickListener(this)
        setUserName()
        initRecyclerView()
    }

    private fun setUserName() {
        val name: String = Build.MODEL
        binding.tvName.text = name
    }

    private fun initRecyclerView() {

        listAdapter = TodoAdapter(this@MainActivity, object : TodoAdapter.OnTodoItemClick {
            override fun onClickOnHoldItem(position: Int, selectedModel: DataModel) {

            }

        })
        binding.rvList.adapter = listAdapter

    }

    private fun updateView() {
        if (mList.size > 0) {
            binding.rvList.visibility = View.VISIBLE
            //    binding.tvNoData.visibility = View.GONE
        } else {

            binding.rvList.visibility = View.GONE
            //   binding.tvNoData.visibility = View.VISIBLE
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.imgAdd -> {
                val bottomSheetFragment = AddTaskBottomSheetFragment()
                bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
            }

        }
    }
}