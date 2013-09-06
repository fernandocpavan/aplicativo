package br.com.view;

import br.com.model.Fornecedor;
import br.com.model.Produto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author fernando_pavan
 */
public class ProdutoTableModel extends AbstractTableModel {

    private static final int COL_ID = 0;
    private static final int COL_DESCRICAO = 1;
    private static final int COL_QTDE = 2;
    private static final int COL_FORNECEDOR = 3;
    
    private List<Produto> linhas;
    // Array com os nomes das colunas.
    private String[] colunas = new String[]{"Código", "Descriçao", "Quantidade", "Fornecedor"};

    //Cria uma ProdutoTableModel sem nenhuma linha
    public ProdutoTableModel() {
        linhas = new ArrayList<Produto>();
    }

    //Cria uma ProdutoTableModel contendo a lista recebida por parâmetro.
    public ProdutoTableModel(List<Produto> produtos) {
        this.linhas = new ArrayList<Produto>(produtos);
    }

    public int getRowCount() {
        return linhas.size();
    }

    /*
     * Retorna a quantidade de colunas
     * 2 colunas: uma para id e a outra para nome.
     */
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    public Class getColumnClass(int columnIndex) {
        //Qual a classe das nossas colunas? A coluna 1 é inteira, as outras string.  
        if (columnIndex == COL_ID) {
            return Integer.class;
        }else if (columnIndex == COL_DESCRICAO ){
            return String.class;
        }else if (columnIndex == COL_QTDE){
            return String.class;
        }else if (columnIndex == COL_FORNECEDOR){
            return Fornecedor.class;
        }
        return null;
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        //Indicamos se a célula da rowIndex e da columnIndex é editável. Nossa tabela toda é.  
        return false;
    }

    //Retorna o valor da coluna e o valor da linha
    public Object getValueAt(int row, int column) {
        //pega a marca da linha
        Produto m = linhas.get(row);

        //verifica qual valor deve ser retornado
        if (column == COL_ID) {
            return m.getId();
        } else if (column == COL_DESCRICAO) {
            return m.getDescricao();
        } else if (column == COL_QTDE){
            return m.getQtde();
        } else if (column == COL_FORNECEDOR){
            return m.getFornecedor();
        }
        return "";
    }

    public void setValueAt(Object aValue, int row, int column) {
        //Vamos alterar o valor da coluna columnIndex na linha rowIndex com o valor aValue passado no parâmetro.  
        //Note que vc poderia alterar 2 campos ao invés de um só.  
        Produto u = linhas.get(row);
        if (column == COL_ID) {
            u.setId((Integer) aValue);
        } else if (column == COL_DESCRICAO) {
            u.setDescricao(aValue.toString());
        } else if (column == COL_QTDE) {
            u.setQtde((Integer)aValue);
        } else if (column == COL_FORNECEDOR) {
            u.setFornecedor((Fornecedor) aValue);
        }
    }

    // Retorna a marca referente a linha especificada
    public Produto getProduto(int indiceLinha) {
        return linhas.get(indiceLinha);
    }


// Adiciona a marca especificada ao produto
    public void addProduto(Produto marca) {
        // Adiciona o registro.
        linhas.add(marca);

        // Pega a quantidade de registros e subtrai 1 para
        // achar o último índice. A subtração é necessária
        // porque os índices começam em zero.
        int ultimoIndice = getRowCount() - 1;


        // Notifica a mudança.
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
        ordenarPorDescricao();

    }
    
        public void updateProduto(int indiceLinha, Produto marca) {
            linhas.set(indiceLinha, marca);
        // Notifica a mudança.
        fireTableRowsUpdated(indiceLinha, indiceLinha);
        ordenarPorDescricao();
    }
    
    //Remove o sócio da linha especificada.
    public void removeProduto(int indiceLinha) {
        // Remove o registro.
        linhas.remove(indiceLinha);

        // Notifica a mudança.
        fireTableRowsDeleted(indiceLinha, indiceLinha);
        ordenarPorDescricao();
    }

// Remove todos os registros.
    public void limpar() {
        // Remove todos os elementos da lista de sócios.
        linhas.clear();

        // Notifica a mudança.
        fireTableDataChanged();
    }
    
    public void ordenarPorDescricao() {
        //ordena pelo nome
        Collections.sort(linhas, new Comparator<Produto>() {

            public int compare(Produto o1, Produto o2) {
                return o1.getDescricao().compareTo(o2.getDescricao());
            }
        });

        //avisa que a tabela foi alterada
        fireTableDataChanged();
    }
}
