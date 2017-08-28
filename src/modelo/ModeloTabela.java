package modelo;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author João Metambo
 * @author José Seie
 * @author Alfredo Sebastião
 * @version 1.0
 *  
 * Classe modelo da tabela de contas
 */
public class ModeloTabela extends AbstractTableModel {

    private ArrayList linhas = null;
    private String[] colunas = null;

    public ModeloTabela(ArrayList lin, String[] col) {
        setLinhas(lin);
        setColunas(col);
    }

    public ArrayList getLinhas() {
        return linhas;
    }

    public void setLinhas(ArrayList linhas) {
        this.linhas = linhas;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }

    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override

    public String getColumnName(int numCol) {
        return colunas[numCol];
    }

    public Object getValueAt(int numLin, int numCol) {
        Object[] linha = (Object[]) getLinhas().get(numLin);
        return linha[numCol];
    }
    public void remove(int indexRow){
    if(indexRow<linhas.size())
        linhas.remove(indexRow);
        fireTableRowsDeleted(indexRow, indexRow);
    }
    public void remove(Object object){
    
        int index = linhas.indexOf(object);
        linhas.remove(object);
        fireTableRowsDeleted(index, index);
    }

}
