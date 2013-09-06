package br.com.view;

import br.com.model.Fornecedor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author fernando_pavan
 */
public class FornecedorTableModel extends AbstractTableModel {

    private static final int COL_ID = 0;
    private static final int COL_NOME = 1;
    private static final int COL_CNPJ = 2;
    private static final int COL_ENDERECO = 3;
     private static final int COL_EMAIL = 4;
    private List<Fornecedor> linhas;
    // Array com os nomes das colunas.
    private String[] colunas = new String[]{"Código", "Nome","CNPJ","Endereço","Email"};

    //Cria uma FornecedorTableModel sem nenhuma linha
    public FornecedorTableModel() {
        linhas = new ArrayList<Fornecedor>();
    }

    //Cria uma FornecedorTableModel contendo a lista recebida por parâmetro.
    public FornecedorTableModel(List<Fornecedor> fornecedores) {
        this.linhas = new ArrayList<Fornecedor>(fornecedores);
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
        }
        return String.class;
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        //Indicamos se a célula da rowIndex e da columnIndex é editável. Nossa tabela toda é.  
        return false;
    }

    //Retorna o valor da coluna e o valor da linha
    public Object getValueAt(int row, int column) {
        //pega a fornecedor da linha
        Fornecedor m = linhas.get(row);

        //verifica qual valor deve ser retornado
        if (column == COL_ID) {
            return m.getId();
        } else if (column == COL_NOME) {
            return m.getNome();
        }else if (column == COL_CNPJ) {
            return m.getCnpj();
        }else if (column == COL_ENDERECO) {
            return m.getEndereco();       
        }else if (column == COL_EMAIL) {
            return m.getEmail();
        }
        return "";
    }

    public void setValueAt(Object aValue, int row, int column) {
        //Vamos alterar o valor da coluna columnIndex na linha rowIndex com o valor aValue passado no parâmetro.  
        //Note que vc poderia alterar 2 campos ao invés de um só.  
        Fornecedor u = linhas.get(row);
        if (column == COL_ID) {
            u.setId((Integer) aValue);
        } else if (column == COL_NOME) {
            u.setNome(aValue.toString());
        }
        else if (column == COL_CNPJ) {
            u.setCnpj(aValue.toString());
        }
        else if (column == COL_ENDERECO) {
            u.setEndereco(aValue.toString());
        }
        else if (column == COL_EMAIL) {
            u.setEmail(aValue.toString());
        }

    }

    // Retorna a fornecedor referente a linha especificada
    public Fornecedor getFornecedor(int indiceLinha) {
        return linhas.get(indiceLinha);
    }


// Adiciona a fornecedor especificada ao modelo
    public void addFornecedor(Fornecedor fornecedor) {
        // Adiciona o registro.
        linhas.add(fornecedor);

        // Pega a quantidade de registros e subtrai 1 para
        // achar o último índice. A subtração é necessária
        // porque os índices começam em zero.
        int ultimoIndice = getRowCount() - 1;


        // Notifica a mudança.
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
        
    }
    
        public void updateFornecedor(int indiceLinha, Fornecedor fornecedor) {
            linhas.set(indiceLinha, fornecedor);
        // Notifica a mudança.
        fireTableRowsUpdated(indiceLinha, indiceLinha);
       
    }
    
    //Remove o sócio da linha especificada.
    public void removeFornecedor(int indiceLinha) {
        // Remove o registro.
        linhas.remove(indiceLinha);

        // Notifica a mudança.
        fireTableRowsDeleted(indiceLinha, indiceLinha);
        
    }

// Remove todos os registros.
    public void limpar() {
        // Remove todos os elementos da lista de sócios.
        linhas.clear();

        // Notifica a mudança.
        fireTableDataChanged();
    }
    
   
}
