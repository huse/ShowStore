package com.hus.kpr.showstore

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.hus.kpr.showstore.databinding.FragmentInstructionsBinding
import com.hus.kpr.showstore.databinding.FragmentOnboardingBinding


/**
 * A simple [Fragment] subclass.
 * Use the [InstructionsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InstructionsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentInstructionsBinding>(inflater, R.layout.fragment_instructions, container, false)
        binding.buttonInstruction.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_instructionsFragment_to_shoeListFragment))
        return binding.root
    }


}

