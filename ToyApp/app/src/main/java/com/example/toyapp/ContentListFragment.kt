package com.example.toyapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.toyapp.database.ToyDatabase
import com.example.toyapp.databinding.FragmentContentListBinding
import timber.log.Timber

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

private lateinit var binding: FragmentContentListBinding
private lateinit var viewModel: ContentListViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [ContentListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ContentListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_content_list,
            container,
            false
        )

        val application = requireNotNull(this.activity).application

        val dataSource = ToyDatabase.getInstance(application).toyDatabaseDao

        val viewModelFactory = ContentListViewModelFactory(dataSource, application)

        viewModel = ViewModelProvider(this, viewModelFactory).get(ContentListViewModel::class.java)

        binding.lifecycleOwner = this.viewLifecycleOwner

        Timber.i("inflated view")


        val adapter = ToyAppAdapter(ToyAppAdapter.ToyListener { toyId ->
            Toast.makeText(context, toyId.toString(), Toast.LENGTH_SHORT).show()
            viewModel.onToyItemClicked(toyId)
        })

        viewModel.toyList.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        binding.playList.adapter = adapter

        viewModel.navigateToToyDetail.observe(viewLifecycleOwner, Observer { toy ->
            toy?.let {
                this.findNavController().navigate(ContentListFragmentDirections.actionContentListFragmentToToyDetailFragment(toy))
            }
        })

        binding.playList.layoutManager = LinearLayoutManager(context)


        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ContentListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ContentListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}