package com.hus.kpr.showstore

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.hus.kpr.showstore.data.DataShoe
import com.hus.kpr.showstore.databinding.FragmentInstructionsBinding
import com.hus.kpr.showstore.databinding.FragmentShoeListListBinding
import com.hus.kpr.showstore.dummy.DummyContent
import com.hus.kpr.showstore.recycler.CustomAdapter
import com.hus.kpr.showstore.ui.login.ShoeDetailViewModel
import java.util.ArrayList

/**
 * A fragment representing a list of Items.
 */
class ShoeListFragment : Fragment() {

    private var columnCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentShoeListListBinding>(inflater, R.layout.fragment_shoe_list_list, container, false)
        binding.buttonAddShoe.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoeListFragment_to_shoeDetailFragment))

/*        val b = ArrayList<Int>()
        for (i in 0..29) {
            b.add(i)
        }
        val dataShoe: DataShoe
        val mRecyclerView = binding.list

        mRecyclerView.setLayoutManager( LinearLayoutManager(getActivity()))
        val customAdapter = CustomAdapter(dataShoe)
        mRecyclerView.adapter = customAdapter*/


        val model = ViewModelProvider(requireActivity()).get(ShoeDetailViewModel::class.java)

        binding.lifecycleOwner = this

        model.shoes.observe(viewLifecycleOwner, Observer { list ->
            val adapter = CustomAdapter(list)
            binding.list.adapter = adapter
        })
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.shoe_detail)

        return binding.root
    }



    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            ShoeListFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}