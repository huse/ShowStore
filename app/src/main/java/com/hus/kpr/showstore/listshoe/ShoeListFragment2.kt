package com.hus.kpr.showstore.listshoe

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.hus.kpr.showstore.R
import com.hus.kpr.showstore.data.DataShoe
import com.hus.kpr.showstore.databinding.FragmentShoeListList2Binding
import com.hus.kpr.showstore.databinding.TextRowItemBinding
import com.hus.kpr.showstore.recycler.CustomAdapter
import com.hus.kpr.showstore.ui.login.ShoeDetailViewModel

import timber.log.Timber

class ShoeListFragment2  : Fragment(){

    private val shoeListingsViewModel: ShoelistViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeListList2Binding
 //   private lateinit var binding2: TextRowItemBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list_list2, container, false)

//        binding2 = DataBindingUtil.inflate(inflater, R.layout.text_row_item, container, false)

        binding.lifecycleOwner = this

        /*shoeListingsViewModel.getShoesLiveDatas().observe(viewLifecycleOwner, {
            val gg: String = it.toString()+ "this is list"
            Toast.makeText(context,gg, Toast.LENGTH_LONG).show()
            if (it.isNotEmpty()) {
                Timber.i(gg)
                context?.let { context ->
                    val shoeContainer = binding.shoeListInsideScroll
                    it.forEach { shoe ->
                        //Code fails here:
                        val shoeLayout = LaoutShoes(context)
                        shoeLayout.loadingShoeToList(shoe)
                        shoeContainer.addView(shoeLayout)
                        //shoeContainer.addView(loadingShoeToList(shoe))
                    }
                }
            }
        })*/


     val model = ViewModelProvider(requireActivity()).get(ShoeDetailViewModel::class.java)

     binding.lifecycleOwner = this

     model.getShoes.observe(viewLifecycleOwner, Observer { list ->
         //val adapter = CustomAdapter(list)
         //binding.list.adapter = adapter

         if (list.isNotEmpty()) {
             context?.let { context ->
                 val shoeContainer = binding.shoeListInsideScroll
                 list.forEach { shoe ->
                     //Code fails here:
                     val shoeLayout = LaoutShoes(context)
                     shoeLayout.loadingShoeToList(shoe)
                     shoeContainer.addView(shoeLayout)
                     //shoeContainer.addView(loadingShoeToList(shoe))
                 }
             }
         }

     })
     (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.shoe_detail)
       binding.buttonAddShoe.setOnClickListener {

           val gg: String = it.toString()
           Toast.makeText(context,gg, Toast.LENGTH_LONG).show()

           Timber.d(gg,"list")
           view?.findNavController()?.navigate(R.id.action_shoeListFragment22_to_shoeDetailFragment)
       }
        binding.buttonLogout.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_shoeListFragment22_to_loginFragment))

        return binding.root
    }
/*
    fun loadingShoeToList(shoe: DataShoe) {
        binding2.apply {
            numberText.text  = shoe.number
            modelTextRow.text = shoe.model
            colorTextRow.text = shoe.color
            sizeTextRow.text = shoe.size
            descTextRow.text = shoe.description
        }
    }*/

}