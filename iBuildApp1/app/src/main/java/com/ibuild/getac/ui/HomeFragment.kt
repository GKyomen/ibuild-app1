package com.ibuild.getac.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ibuild.getac.R
import com.ibuild.getac.adapter.ProductCardListAdapter
import com.ibuild.getac.adapter.StoreCardListAdapter
import com.ibuild.getac.model.Product
import com.ibuild.getac.model.Store
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener

class HomeFragment : Fragment() {

    private lateinit var hscroll1: RecyclerView
    private lateinit var hscroll2: RecyclerView
    private lateinit var carouselView: CarouselView

    //hardcoded, temporario enquanto não tem o banco de dados
    private val sampleImages = intArrayOf(
        R.drawable.imgplaceholder,
        R.drawable.imgplaceholder,
        R.drawable.imgplaceholder,
        R.drawable.imgplaceholder,
        R.drawable.imgplaceholder
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        carouselView = getView()?.findViewById(R.id.homeCarousel) as CarouselView
        carouselView.setImageListener(imageListener)
        carouselView.pageCount = sampleImages.size

        hscroll1 = getView()?.findViewById(R.id.hscroll1) as RecyclerView
        hscroll1.adapter = getView()?.let { StoreCardListAdapter(stores(), it.context) }
        val layoutManager1 = LinearLayoutManager(getView()?.context)
        layoutManager1.orientation = LinearLayoutManager.HORIZONTAL
        hscroll1.layoutManager = layoutManager1

        hscroll2 = getView()?.findViewById(R.id.hscroll2) as RecyclerView
        hscroll2.adapter = getView()?.let { ProductCardListAdapter(products(), it.context) }
        val layoutManager2 = LinearLayoutManager(getView()?.context)
        layoutManager2.orientation = LinearLayoutManager.HORIZONTAL
        hscroll2.layoutManager = layoutManager2
    }

    private var imageListener: ImageListener =
        ImageListener { position, imageView ->
            imageView.setImageResource(sampleImages[position])
        }

    //hardcoded, temporario enquanto não tem o banco de dados das lojas
    private fun stores() : List<Store> {
        return listOf(
            Store("Nome do estabelecimento 1", "Nome da rua - Cidade 1", 4.8),
            Store("Nome do estabelecimento 2", "Nome da rua - Cidade 2", 4.7),
            Store("Nome do estabelecimento 3", "Nome da rua - Cidade 3", 4.5),
            Store("Nome do estabelecimento 4", "Nome da rua - Cidade 4", 4.9),
            Store("Nome do estabelecimento 5", "Nome da rua - Cidade 5", 5.0)
        )
    }

    private fun products(): List<Product> {
        return listOf(
            Product("Nome do produto 1", 3.50, "un", "Tok\u0026Stok"),
            Product("Nome do produto 2", 9.99, "kg", "Leroy Merlin"),
            Product("Nome do produto 3", 5.75, "litro", "C\u0026C"),
            Product("Nome do produto 4", 7.50, "un", "Telhanorte"),
            Product("Nome do produto 5", 2.30, "metro", "Dicico")
        )
    }
}
