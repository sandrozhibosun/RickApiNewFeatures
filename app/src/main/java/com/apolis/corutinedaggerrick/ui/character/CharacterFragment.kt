package com.apolis.corutinedaggerrick.ui.character

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.apolis.corutinedaggerrick.R
import com.apolis.corutinedaggerrick.app.di.DaggerAppComponent
import com.apolis.corutinedaggerrick.data.models.Character
import com.apolis.corutinedaggerrick.databinding.FragmentCharacterBinding
import javax.inject.Inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CharacterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CharacterFragment : Fragment(),CharacterGetListener {


    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentCharacterBinding
    @Inject
    lateinit var characterViewModel:CharacterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        val view= inflater.inflate(R.layout.fragment_character, container, false)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_character, container, false)
        val view = binding.root
        Log.d("abc","first fragment")

        //inject
        var component=DaggerAppComponent.create()
        component.inject(this)

        binding.characterAdapter=CharacterAdapter(requireContext())
//        characterViewModel= ViewModelProvider(requireActivity()).get(CharacterViewModel::class.java)
        characterViewModel.characterGetListener=this
        init()

        return view
    }


    private fun init(){
        characterViewModel.getCharacterListFromRepo()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CharacterFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CharacterFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onGet(mList: LiveData<ArrayList<Character>>) {
        mList.observe(viewLifecycleOwner, Observer {
            binding.characterAdapter?.setData(it)
        })
    }
}