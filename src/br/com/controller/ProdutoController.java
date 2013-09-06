/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.model.Produto;
import br.com.model.persistencia.ProdutoDAOImpl;
import br.com.model.persistencia.dao.ProdutoDAO;
import java.util.List;

/**
 *
 * @author User
 */
public class ProdutoController {
    public boolean salvar(Produto produto) {
        ProdutoDAO dao = new ProdutoDAOImpl();
        return dao.save(produto);
    }

    public boolean excluir(int id) {
        ProdutoDAO dao = new ProdutoDAOImpl();
        return dao.remove(Produto.class, id);
    }
    
    public List<Produto> listarProduto() {
        ProdutoDAO dao = new ProdutoDAOImpl();
        return dao.getAll(Produto.class);
    }
    
    public Produto listarProdutoById (int id){
        ProdutoDAO dao = new ProdutoDAOImpl();
        return dao.getById(Produto.class, id);
    }
    
   public List<Produto> listarProdutoByDescricao (String descricao){
        ProdutoDAO dao = new ProdutoDAOImpl();
        return dao.getByDescricao(descricao);
    }
      
   public Produto listarProdutoByDescricao2(String descricao){
       ProdutoDAO dao = new ProdutoDAOImpl();
       return dao.getProdutoByDescricao(descricao);
   }
}
