package com.hus.kpr.showstore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.hus.kpr.showstore.data.DataShoe
import com.hus.kpr.showstore.databinding.FragmentShoeDetailBinding
import com.hus.kpr.showstore.listshoe.ShoelistViewModel
import com.hus.kpr.showstore.ui.login.ShoeDetailViewModel
import timber.log.Timber

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ShoeDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeDetailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var viewModel: ShoeDetailViewModel

    private val shoeListingsViewModel: ShoelistViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        super.onCreateView(inflater, container, savedInstanceState)
        val binding = DataBindingUtil.inflate<FragmentShoeDetailBinding>(inflater, R.layout.fragment_shoe_detail, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(ShoeDetailViewModel::class.java)
        binding.lifecycleOwner = this
        binding.shoelistViewModels = shoeListingsViewModel
        binding.dataShoeInxmlfile = DataShoe()

        Timber.i("hhhhhhh"+binding.dataShoeInxmlfile?.color)
        binding.buttonSaveShoe.setOnClickListener{
            Timber.i("kkkkkkkkkkkkk")
            Timber.i(binding.dataShoeInxmlfile?.model)
            val gg2: String = it.toString()+ "this is list"
            Toast.makeText(context,gg2, Toast.LENGTH_LONG).show()
            Timber.i("kkkkkkkkkkkkk")
            shoeListingsViewModel.addShoes(shoeListingsViewModel.shoe)


           DataShoe(
                "1",
                binding.shoeModelEdit.text.toString(),
                binding.shoeSizeEdit.text.toString(),
                binding.shoeColorEdit.text.toString(),
                binding.shoeDescriptionEdit.text.toString()
            ).also { binding.dataShoeInxmlfile = it }

            val detailsShoeNumberss = binding.dataShoeInxmlfile
            viewModel.saveCurrentDetail(detailsShoeNumberss)
            val gg: String = binding.shoeModelEdit.text.toString()
            //val gg: String = it.toString()
            Toast.makeText(context,gg, Toast.LENGTH_LONG).show()
            //Navigation.createNavigateOnClickListener(R.id.action_shoeDetailFragment_to_shoeListFragment)

            view?.findNavController()?.navigate(R.id.action_shoeDetailFragment_to_shoeListFragment22)

        }
        binding.buttonCancelShoe.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoeDetailFragment_to_shoeListFragment22))
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ShoeDetailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ShoeDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}