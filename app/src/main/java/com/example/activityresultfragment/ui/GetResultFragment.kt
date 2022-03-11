package com.example.activityresultfragment.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.activityresultfragment.R
import com.example.activityresultfragment.databinding.FragmentGetResultBinding
import com.example.activityresultfragment.utils.KEY

class GetResultFragment : Fragment() {

    lateinit var binding: FragmentGetResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGetResultBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        findNavController().currentBackStackEntry?.savedStateHandle?.let { handle ->
            handle.getLiveData<String>(KEY)
                .observe(viewLifecycleOwner) { res ->
                    if(res != null){
                        binding.getresult.text = res.toString()
                        Log.d("get",res.toString())
                    }
                }
        }
        binding.add.setOnClickListener {
            findNavController().navigate(R.id.action_getResultFragment_to_resultFragment)
        }

    }
}