package com.hus.kpr.showstore.listshoe

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.hus.kpr.showstore.R
import com.hus.kpr.showstore.databinding.FragmentShoeListList2Binding
import timber.log.Timber

class ShoeListFragment2  : Fragment(){

    private val shoeListingsViewModel: ShoelistViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeListList2Binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list_list2, container, false)
        binding.lifecycleOwner = this

        shoeListingsViewModel.getShoesLiveDatas().observe(viewLifecycleOwner, {
            val gg: String = it.toString()
            Toast.makeText(context,gg, Toast.LENGTH_LONG).show()
            if (it.isNotEmpty()) {
                Timber.d(gg,"list")
                context?.let { context ->
                    val shoeContainer = binding.shoeListInsideScroll
                    it.forEach { shoe ->
                        //Code fails here:
                        val shoeLayout = LaoutShoes(context)
                        shoeLayout.loadingShoeToList(shoe)
                        shoeContainer.addView(shoeLayout)
                    }
                }
            }
        })

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

}