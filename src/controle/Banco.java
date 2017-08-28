/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import modelo.ContaBancaria;
import modelo.ContaCorrente;
import modelo.ContaPoupanca;
import modelo.Imprimivel;
import modelo.ModeloTabela;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author silva-muzime
 * Classe responsavel pelo gerenciamento de dados das contas bancarias 
 */
public class Banco implements Imprimivel{
    private ArrayList<ContaBancaria> contas = new ArrayList<>();
    int totalContas = contas.size();
    
    public ArrayList<ContaBancaria> getContas() {
        return contas;
    }

    public Banco() {
    }
    /**
     * Metodo que serve para adicionar uma nova conta 
     * @param cb conta a ser adicionada
     */
    public void inserir(ContaBancaria cb){
        contas.add(cb);
        JOptionPane.showMessageDialog(null,"Conta adicionada com sucesso \n"+ "O seu número de conta é :"+(contas.size()-1));
    }
    /**
     * Metodo que remove uma dada conta
     * @param cb
     * @return 
     */
    public boolean remover(ContaBancaria cb){
        contas.remove(cb);
       return true;        
    }
    
    /**
     * Metodo responsavel por actualizar a tabela de contas
     * @param table tabela que e recebida
     * @return tabela preenchida com dados disponiveis 
     */
    public JTable listar(JTable table){
        String[] colunas = new String[]{
            "Número da conta","Tipo de conta","Saldo"
        };

        ArrayList aux =  new ArrayList<>();
        
        aux=dados(aux);
        
        ModeloTabela m = new ModeloTabela(aux, colunas);
        table.setModel(m);
        
        return table; 
    }
    /**
     * Metodo que faz a pesquisa de contas 
     * @param numeroConta numero de conta a ser procurada
     * @return conta bancaria
     */
    public ContaBancaria procuraConta(int numeroConta){
        
        for(int i=0; i< contas.size(); i++)
            if(contas.get(i).getNumeroDeConta()==numeroConta)
                return contas.get(i);
        
        return null;    
        
    }
    /**
     * Metodo que mostra dados de todas as contas disponiveis
     */
    @Override
    public void mostrarDados() {
        contas.forEach(n->{
            if(n instanceof ContaCorrente){
                ((ContaCorrente)n).mostrarDados();
            }else{
                ((ContaPoupanca)n).mostrarDados();
            }
        });
      
    }
    /**
     * Metodo que prepara os dados das contas para serem introduzidos na tabela
     * @param lista de contas a ser preparada
     * @return lista ja preparada com dados das contas
     */
    public ArrayList<Object> dados(ArrayList<Object> lista){
        for(int i=0 ; i<contas.size();i++){
            if(contas.get(i) instanceof ContaCorrente){
                lista.add(new Object[]{
                    contas.get(i).getNumeroDeConta(),
                    "Conta corrente",
                    contas.get(i).getSaldo()
            });
            }else{
                lista.add(new Object[]{
                    contas.get(i).getNumeroDeConta(),
                    "Conta poupanca",
                    contas.get(i).getSaldo()
                });
            }
        }
    
        return lista;
    }
    
    
}
