package test;

import dao.DaoProduto;
import dao.DaoVenda;
import dao.Idao.IDaoProduto;
import dao.Idao.IDaoVenda;
import model.Produto;
import model.Venda;

import java.util.ArrayList;

public class Test {
    private IDaoProduto daoProduto;
    private IDaoVenda daoVenda;

    public Test(){
        try{
              this.daoProduto = new DaoProduto();

              ArrayList<Produto> produtos =  this.daoProduto.getProdutos();

              for( Produto produto : produtos){
                  System.out.println(produto);
              }
//
//            Produto produto = this.daoProduto.getProdutoPorId(10);
//            System.out.println(produto);
//
//            Produto produtoAtualizado =  new Produto( 10, "nomeTest", 0);
//
//            produto = this.daoProduto.putProdutoPorId(produtoAtualizado);
//
//            this.daoProduto.postProduto(new Produto ("", 0.90));

              this.daoVenda = new DaoVenda();

//              List<Venda> vendas = this.daoVenda.getTodasAsVendas();
//
//              for ( Venda venda : vendas ){
//                  System.out.println(venda);
//              }

//              Venda venda = this.daoVenda.getVendaPorId(5682);

                Venda novaVenda = this.daoVenda.potsVenda( new Venda( 92, 900 ));

              System.out.println(novaVenda);


        }catch( Exception ex){
            ex.printStackTrace();
        }
        System.out.println("Hello world!");


    }

    public static void main(String[] args) {
        new Test();
    }
}
