/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.persistencia;

import br.com.model.Produto;
import br.com.model.persistencia.dao.ProdutoDAO;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author User
 */
public class ProdutoDAOImpl extends DAOImpl<Produto, Integer> implements ProdutoDAO {

     public List<Produto> getByDescricao (String descricao){
        return getEntityManager().createQuery("select m from Produto m where m.descricao like '%" + descricao + "%'").getResultList();
    }
     
      public Produto getProdutoByDescricao(String descricao) {
        Query q = getEntityManager().createQuery("select m from Produto m where m.descricao like '" + descricao + "'", Produto.class);
        List<Produto> produtos = q.getResultList();
        for (Produto m : produtos) {
            return m;
        }
        return null;

    }

    
}
