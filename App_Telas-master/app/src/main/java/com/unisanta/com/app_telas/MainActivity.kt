package com.unisanta.com.app_telas

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ProdutoAdapter
    lateinit var lista: MutableList<Produto>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        val nav = findViewById<BottomNavigationView>(R.id.bottomNav)

        recyclerView.layoutManager = LinearLayoutManager(this)

        carregarEletronicos()

        nav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_eletronicos -> carregarEletronicos()
                R.id.nav_roupas -> carregarRoupas()
                R.id.nav_livros -> carregarLivros()
            }
            true
        }
    }

    private fun carregarEletronicos() {
        lista = mutableListOf(
            Produto(nome ="Celular", preco = 1500.0, imagem = R.drawable.celular),
            Produto(nome ="Notebook", preco = 3500.0, imagem = R.drawable.notebook)
        )
        atualizar()
    }

    private fun carregarRoupas() {
        lista = mutableListOf(
            Produto(nome = "Camiseta", preco = 50.0, imagem = R.drawable.camisa),
            Produto(nome = "Calça", preco = 120.0, imagem =   R.drawable.calca)
        )
        atualizar()
    }

    private fun carregarLivros() {
        lista = mutableListOf(
            Produto(nome = "Livro", preco = 80.0, imagem = R.drawable.livro),
            Produto(nome ="Livro", preco = 90.0, imagem = R.drawable.livro2)
        )
        atualizar()
    }

    private fun atualizar() {
        adapter = ProdutoAdapter(lista)
        recyclerView.adapter = adapter
    }
}