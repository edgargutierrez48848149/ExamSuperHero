package com.gentera.yastas.sdk.myapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gentera.yastas.sdk.myapplication.R
import com.gentera.yastas.sdk.myapplication.core.Constants
import com.gentera.yastas.sdk.myapplication.core.Network
import com.gentera.yastas.sdk.myapplication.core.ResponseStatus
import com.gentera.yastas.sdk.myapplication.data.DatSouSuperHero
import com.gentera.yastas.sdk.myapplication.data.models.DtoSuperHero
import com.gentera.yastas.sdk.myapplication.databinding.FragmentListSuperHeroBinding
import com.gentera.yastas.sdk.myapplication.repositorys.network.ApiSuperHero
import com.gentera.yastas.sdk.myapplication.repositorys.network.RepNetSuperHero
import com.gentera.yastas.sdk.myapplication.viewModel.VmFactory
import com.gentera.yastas.sdk.myapplication.viewModel.VmNetSuperHero
import com.gentera.yastas.sdk.myapplication.viewModel.VmNetwork

class ListSuperHeroFragment : Fragment(), RvListSuperHero.OnClick {

    private lateinit var binding: FragmentListSuperHeroBinding
    private var adapter = RvListSuperHero(mutableListOf(), this)
    private val listSuperHeros: MutableList<DtoSuperHero> = mutableListOf()
    private val vmNetwork: VmNetwork by activityViewModels()
    private var startList = 0
    private var endList = 20
    private var isConected = true
    private val vmSuperHero by viewModels<VmNetSuperHero> {
        VmFactory(
            RepNetSuperHero(
                DatSouSuperHero(
                    Network().retrofit().create(ApiSuperHero::class.java)
                )
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListSuperHeroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvSuperHero.layoutManager = GridLayoutManager(requireContext(), 1)
        binding.rvSuperHero.isVerticalScrollBarEnabled = true
        binding.rvSuperHero.adapter = RvListSuperHero(listSuperHeros, this)
        adapter = binding.rvSuperHero.adapter as RvListSuperHero
        vmNetwork.getIsConected().observe(viewLifecycleOwner, { statusConnection ->
            isConected = statusConnection
            if (listSuperHeros.isEmpty()) {
                getAllSuperHeros()
            }
        })

        setupOnClick()
    }

    private fun setupOnClick() {
        // show the start of the list
        binding.btnUp.setOnClickListener {
            binding.rvSuperHero.smoothScrollToPosition(1)
        }

        //when reaching the end of the list,it add new elements
        binding.rvSuperHero.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0) {
                    val visibleItemCount = recyclerView.layoutManager!!.childCount
                    val totalItemCount = recyclerView.layoutManager!!.itemCount
                    val pastVisiblesItems =
                        (recyclerView.layoutManager as GridLayoutManager).findFirstVisibleItemPosition()
                    if (visibleItemCount + pastVisiblesItems >= totalItemCount) {
                        startList += 20
                        endList += 20
                        getAllSuperHeros()
                    }
                }
            }
        })
    }

    private fun getAllSuperHeros() {
        var count = startList
        if (isConected) {
            for (i in startList..endList) {
                vmSuperHero.getSuperHeroId("${Constants.ACCES_TOKEN}/${i + 1}")
                    .observe(viewLifecycleOwner, { responce ->
                        when (responce) {
                            is ResponseStatus.Loaing -> {
                            }
                            is ResponseStatus.Success -> {
                                listSuperHeros.add(responce.data)
                                adapter.notifyItemInserted(count)
                                count += 1
                            }
                            is ResponseStatus.Error -> {
                            }
                        }
                    })
            }
        } else {
            Toast.makeText(requireContext(), R.string.no_conection, Toast.LENGTH_LONG).show()
        }
    }

    override fun onClick(dtoSuperHero: DtoSuperHero) {
        val bundle = Bundle()
        bundle.putSerializable("dtoSuperHero", dtoSuperHero)
        findNavController().navigate(
            R.id.action_scheduleMeetingDetailFragment_to_detailSuperHeroFragment,
            bundle
        )
    }
}