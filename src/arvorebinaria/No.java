/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvorebinaria;

/**
 *
 * @author walison
 */
public class No<V> {

    private V valor;
    private int id;
    private No esquerdo, direito;

    public No(V valor, int id) {
        this.valor = valor;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public V getValor() {
        return valor;
    }

    public void setValor(V valor) {
        this.valor = valor;
    }

    public No getEsquerdo() {
        return esquerdo;
    }

    public void setEsquerdo(No esquerdo) {
        this.esquerdo = esquerdo;
    }

    public No getDireito() {
        return direito;
    }

    public void setDireito(No direito) {
        this.direito = direito;
    }

    public int quantidadeFilhos() {
        if (esquerdo != null && direito != null) {
            return 2;
        } else if (esquerdo != null || direito != null) {
            return 1;
        } else {
            return 0;
        }
    }
    
   
    
}
