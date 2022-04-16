package com.ad.adilpracticaltask.data.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ad.adilpracticaltask.R
import com.ad.adilpracticaltask.data.local.model.DataModel
import com.ad.adilpracticaltask.databinding.ItemTodoBinding

class TodoAdapter(val context: Context, val onClickListener: OnTodoItemClick) :
    RecyclerView.Adapter<TodoAdapter.ViewHolder>() {
    private var list: ArrayList<DataModel> = arrayListOf()

    interface OnTodoItemClick {

        fun onClickOnHoldItem(
            position: Int,
            selectedModel: DataModel
        )
    }


    inner class ViewHolder(val binding: ItemTodoBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemTodoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.binding.apply {

            tvDate.text = list[position].dayNumber
            tvDateDay.text = list[position].dayName
            tvDateMonth.text = list[position].month
            tvTodo.text = list[position].task

            checkbox.isChecked = list[position].isCompleted
            itemRoot.setBackgroundResource(if (list[position].isCompleted) R.drawable.shape_selected else R.drawable.shape_unselected)
            checkbox.setOnCheckedChangeListener { compoundButton, isChecked ->

                if (compoundButton.isPressed) {

                    list[position].isCompleted = isChecked
                    notifyItemChanged(position)
                    onClickListener.onClickOnHoldItem(position, list[position])

                }

            }
        }
    }

    override fun getItemCount(): Int = list.size

    fun setData(newList: ArrayList<DataModel>) {
        //  lastSelectedPosition = -1
        // val toDoDiffUtil = DiffUtilsHold(list, newList)
        // val toDoDiffResult = DiffUtil.calculateDiff(toDoDiffUtil)
        list = ArrayList()
        this.list = newList;
        notifyDataSetChanged()
        //  toDoDiffResult.dispatchUpdatesTo(this)
    }

    class DiffUtilsHold(
        private val oldList: ArrayList<DataModel>,
        private val newList: ArrayList<DataModel>
    ) : DiffUtil.Callback() {

        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] === newList[newItemPosition]
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }
    }