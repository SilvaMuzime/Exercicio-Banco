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
 * @see ContaBancaria
 * @see Imprimivel
 * Su-classe da classe ContaBancaria que implementa a interface Imprimivel
 */
public class ContaPoupanca extends ContaBancaria implements Imprimivel{
    //valor limite de saldo que pode ser atingido
    private final double limite = -100;
    
    
    @Override
    public void sacar(double valor){
        if( (super.getSaldo()-valor) >= limite){
            super.setSaldo(super.getSaldo()-valor);
             JOptionPane.showMessageDialog(null,"Levantamento efectuado com sucesso");
        }else{
            JOptionPane.showMessageDialog(null,"O levantamento nao pode ser efectuado");
        }            
    }
    
    @Override
    public void depositar(double valor){
        super.setSaldo(super.getSaldo()+valor);    
        JOptionPane.showMessageDialog(null,"Deposito efectuado com sucesso");
    }
    
    @Override
    public void mostrarDados() {
        String dados="Numero da conta: "+super.getNumeroDeConta()+"\n"+
                "Saldo actual: "+super.getSaldo()+"\n"+
                "Limite: "+ this.limite;
        JOptionPane.showMessageDialog(null,dados);
    }

    public double getLimite() {
        return limite;
    }
    
}
