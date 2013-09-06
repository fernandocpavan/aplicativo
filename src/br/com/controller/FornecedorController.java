/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.model.Fornecedor;
import br.com.model.persistencia.FornecedorDAOImpl;
import br.com.model.persistencia.dao.FornecedorDAO;
import java.util.List;

/**
 *
 * @author fernando_pavan
 */
public class FornecedorController {
    
    public boolean salvar(Fornecedor fornecedor) {
        FornecedorDAO dao = new FornecedorDAOImpl();
        return dao.save(fornecedor);
    }

    public boolean excluir(int id) {
        FornecedorDAO dao = new FornecedorDAOImpl();
        return dao.remove(Fornecedor.class, id);

    }
    
    public List<Fornecedor> listarFornecedor() {
        FornecedorDAO dao = new FornecedorDAOImpl();
        return dao.getAll(Fornecedor.class);
    }
    
    public Fornecedor listarFornecedorById (int id){
        FornecedorDAO dao = new FornecedorDAOImpl();
        return dao.getById(Fornecedor.class, id);
    }
    
   public List<Fornecedor> listarFornecedoresByNome (String nome){
        FornecedorDAO dao = new FornecedorDAOImpl();
        return dao.getByNome(nome);
    }
     
   public Fornecedor listarFornecedorByNome (String nome){
       FornecedorDAO dao = new FornecedorDAOImpl();
       return dao.getFornecedorByNome(nome);
   }
        
}
