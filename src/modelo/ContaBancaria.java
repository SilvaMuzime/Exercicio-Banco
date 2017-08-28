/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.JOptionPane;

/**
*
* @author silva-muzime
 */
public abstract class ContaBancaria {
    private int numeroDeConta;
    private double saldo;
    
     /**
     * Metodo reponsavel por efectuar o levantamento numa conta
     * @param valor  valor a ser levantado 
     */
    public abstract void sacar(double valor);
    
    
     /**
     * Metodo responsavel pelo deposito de valores numa conta
     * @param valor valor a ser depositado
     */
    public abstract void depositar(double valor);
    
    public int getNumeroDeConta() {
        return numeroDeConta;
    }
    

    public void setNumeroDeConta(int numeroDeConta) {
        this.numeroDeConta = numeroDeConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Metodo que executa a transferencia do valor de conta para outra conta
     * @param valor valor a transferir
     * @param conta conta destino
     */
    public void transferir(double valor, ContaBancaria conta){
        if(this instanceof ContaCorrente){
            ContaCorrente cc = ((ContaCorrente)this);
            boolean condicao=(this.getSaldo() - valor - cc.getTaxaDeOperacao()) > 0;
            if(condicao){
                cc.sacar(valor);
                conta.depositar(valor);                
            }            
        }else{
            ContaPoupanca cp = ((ContaPoupanca)this);
            boolean condicao = (cp.getSaldo()-valor) >= cp.getLimite();
            if(condicao){
                cp.sacar(valor);
                conta.depositar(valor);                 
            }
        }
        
        
    }
    
    
    
}
