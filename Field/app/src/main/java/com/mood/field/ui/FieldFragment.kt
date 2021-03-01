package com.mood.field.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mood.field.R
import com.mood.field.databinding.FragmentFieldBinding
import com.mood.field.domain.Market
import com.mood.field.viewmodels.FieldViewModel
import com.mood.field.viewmodels.FieldViewModelFactory

class FieldFragment : Fragment() {

    /**
     * One way to delay creation of the viewModel until an appropriate lifecycle method is to use
     * lazy. This requires that viewModel not be referenced before onActivityCreated, which we
     * do in this Fragment.
     */
    private val viewModel: FieldViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onActivityCreated()"
        }
        ViewModelProvider(this, FieldViewModelFactory(activity.application))
            .get(FieldViewModel::class.java)
    }

    /**
     * RecyclerView Adapter for converting a list of Markets to cards.
     */
    private var viewModelAdapter: MarketAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        viewModel.marketList.observe(viewLifecycleOwner, Observer<List<Market>> { markets ->
//            markets?.apply {
//                viewModelAdapter?.submitList(markets)
//            }
//        })

        viewModel.marketList.observe(viewLifecycleOwner, Observer {
            it?.let {
                viewModelAdapter?.submitList(it)
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentFieldBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_field,
            container,
            false
        )

        binding.lifecycleOwner = this.viewLifecycleOwner

        return binding.root
    }
}