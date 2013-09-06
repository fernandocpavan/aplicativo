/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.persistencia;

import br.com.model.Fornecedor;
import br.com.model.persistencia.dao.FornecedorDAO;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author fernando_pavan
 */
public class FornecedorDAOImpl extends DAOImpl<Fornecedor, Integer> implements FornecedorDAO{
    
    public List<Fornecedor> getByNome (String nome){
        return getEntityManager().createQuery("select m from Fornecedor m where m.nome like '%" + nome + "%'").getResultList();
    }
     
      public Fornecedor getFornecedorByNome(String nome) {
        Query q = getEntityManager().createQuery("select m from Fornecedor m where m.nome like '" + nome + "'", Fornecedor.class);
        List<Fornecedor> fornecedores = q.getResultList();
        Fornecedor ma = new Fornecedor();
        for (Fornecedor m : fornecedores) {
            ma = m;
        }
        return ma;

    }

 
}
