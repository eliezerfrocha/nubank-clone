package com.nubank.nubankclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.nubank.nubankclone.adapter.AdapterPagamento
import com.nubank.nubankclone.adapter.AdapterProduto
import com.nubank.nubankclone.databinding.ActivityMainBinding
import com.nubank.nubankclone.model.Pagamento
import com.nubank.nubankclone.model.Produto

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterPagamento: AdapterPagamento
    private lateinit var adapterProduto: AdapterProduto
    private val listPagamento: MutableList<Pagamento> = mutableListOf()
    private val listProduto: MutableList<Produto> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        // Recycler Pagamentos
        var recyclerIconesPagamento = binding.recyclerIconesPagamento
        recyclerIconesPagamento.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerIconesPagamento.setHasFixedSize(true)
        adapterPagamento = AdapterPagamento(this, listPagamento)
        recyclerIconesPagamento.adapter = adapterPagamento
        listaIconesPagamento()

        // Recycler Produtos
        val recyclerProdutos = binding.recyclerProdutos
        recyclerProdutos.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerProdutos.setHasFixedSize(true)
        adapterProduto = AdapterProduto(this, listProduto)
        recyclerProdutos.adapter = adapterProduto
        listTextoInformativo()
    }

    private fun listaIconesPagamento(){
        val icone1 = Pagamento(R.drawable.ic_pix, "Área Pix")
        listPagamento.add(icone1)

        val icone2 = Pagamento(R.drawable.barcode, "Boleto")
        listPagamento.add(icone2)

        val icone3 = Pagamento(R.drawable.emprestimo, "Empréstimo")
        listPagamento.add(icone3)

        val icone4 = Pagamento(R.drawable.transferencia, "Transferir")
        listPagamento.add(icone4)

        val icone5 = Pagamento(R.drawable.depositar, "Depositar")
        listPagamento.add(icone5)

        val icone6 = Pagamento(R.drawable.ic_recarga_celular, "Recarga")
        listPagamento.add(icone6)

        val icone7 = Pagamento(R.drawable.ic_cobrar, "Cobrar")
        listPagamento.add(icone7)

        val icone8 = Pagamento(R.drawable.doacao, "Doar")
        listPagamento.add(icone8)
    }

    private fun listTextoInformativo() {
        val textInfo1 = Produto("🎁 Participe da Promoção Tudo no Roxinho e concorra à...")
        listProduto.add(textInfo1)

        val textInfo2 = Produto("💳 Chegou o débito automático da fatura do cartão!")
        listProduto.add(textInfo2)

        val textInfo3 = Produto("👨‍💻 Conheça a conta PJ: prática e livre de burocracia para se...")
        listProduto.add(textInfo3)

        val textInfo4 = Produto("🏦 Salve seus amigos da burocracia: Faça um convite...")
        listProduto.add(textInfo4)
    }
}