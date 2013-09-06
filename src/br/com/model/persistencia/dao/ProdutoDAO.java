/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.persistencia.dao;

import br.com.model.Produto;
import java.util.List;

/**
 *
 * @author fernando_pavan
 */
public interface ProdutoDAO extends DAO<Produto, Integer>{
    List<Produto> getByDescricao (String descricao);
    Produto getProdutoByDescricao(String descricao);
}
