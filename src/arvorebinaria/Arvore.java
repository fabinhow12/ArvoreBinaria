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
public class Arvore<V> {

    private No raiz;

    public No getRaiz() {
        return raiz;
    }

    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }

    public boolean estaVazia() {
        return this.raiz == null;
    }

    private void adicionarNo(No novo, No parente) {
        if (novo.getId() == parente.getId()) {
            System.out.println("ja existe um no com o mesmo id");

        } else if (novo.getId() < parente.getId()) {
            if (parente.getEsquerdo() == null) {
                parente.setEsquerdo(novo);
            } else {
                this.adicionarNo(novo, parente.getEsquerdo()); //recursividade
            }

        } else if (novo.getId() > parente.getId()) {
            if (parente.getDireito() == null) {
                parente.setDireito(novo);
            } else {
                this.adicionarNo(novo, parente.getDireito());
            }
        } else {

        }
    }

    public void adicionar(V elemento, int id) {
        if (this.raiz == null) {
            this.raiz = new No(elemento, id);
        } else {
            this.adicionarNo(new No(elemento, id), this.raiz);
        }
    }

    public No pesquisar(int id) {
        No auxBusca = this.raiz;

        while (auxBusca != null) {
            if (id > auxBusca.getId()) {
                auxBusca = auxBusca.getDireito();
            } else if (id < auxBusca.getId()) {
                auxBusca = auxBusca.getEsquerdo();
            } else { //busca.getId() == id 
                return auxBusca;
            }
        }

        return null;
    }

    public No pegarParente(int id) {
        No aux = this.raiz;

        while (aux != null) {
            No esquerdo = aux.getEsquerdo();
            No direito = aux.getDireito();

            if (aux.getId() == id || (esquerdo != null && esquerdo.getId() == id) || (direito != null && direito.getId() == id)) {
                return aux;
            } else if (id < aux.getId()) {
                aux = esquerdo;
            } else {
                aux = direito;
            }
        }
        return null;
    }

    //pega o maior valor da subarvore da esquerda 
    public No pegarSucessor(No no) {
        No aux = no.getEsquerdo();

        while (aux != null) {
            No direito = aux.getDireito();

            if (direito != null) {
                aux = aux.getDireito();
            } else {
                return aux;
            }
        }

        return null;
    }

    public void deletar(int id) {
        No noParaDeletar = this.pesquisar(id);
        No parente = this.pegarParente(id);

        if (noParaDeletar == null) {
            System.out.println("nada para deletar..");

        } else if (noParaDeletar.quantidadeFilhos() == 0) {

            if (noParaDeletar == parente.getEsquerdo()) {
                parente.setEsquerdo(null);
            } else if (noParaDeletar == parente.getDireito()) {
                parente.setDireito(null);
            } else { //no para deletar é a raiz
                this.raiz = null;
            }

        } else if (noParaDeletar.quantidadeFilhos() == 1) {

            if (noParaDeletar == parente.getEsquerdo()) {

                if (noParaDeletar.getEsquerdo() != null) {
                    parente.setEsquerdo(noParaDeletar.getEsquerdo());
                } else {
                    parente.setEsquerdo(noParaDeletar.getDireito());
                }

            } else if (noParaDeletar == parente.getDireito()) {

                if (noParaDeletar.getEsquerdo() != null) {
                    parente.setDireito(noParaDeletar.getEsquerdo());
                } else {
                    parente.setDireito(noParaDeletar.getDireito());
                }

            } else {

                if (noParaDeletar.getEsquerdo() != null) {
                    this.raiz = noParaDeletar.getEsquerdo();
                } else {
                    this.raiz = noParaDeletar.getDireito();
                }
            }

        } else if (noParaDeletar.quantidadeFilhos() == 2) {

            if (noParaDeletar == parente.getEsquerdo()) {
                No sucessor = this.pegarSucessor(noParaDeletar.getEsquerdo());
                No parenteSucessor = this.pegarParente(sucessor.getId());

                if (parenteSucessor != noParaDeletar) {
                    parenteSucessor.setDireito(sucessor.getEsquerdo());
                }

                if (noParaDeletar.getEsquerdo() != sucessor) {
                    sucessor.setEsquerdo(noParaDeletar.getEsquerdo());
                }
                sucessor.setDireito(noParaDeletar.getDireito());

                parente.setEsquerdo(sucessor);

            } else if (noParaDeletar == parente.getDireito()) {
                No sucessor = this.pegarSucessor(noParaDeletar.getEsquerdo());
                No parenteSucessor = this.pegarParente(sucessor.getId());

                if (parenteSucessor != noParaDeletar) {
                    parenteSucessor.setDireito(sucessor.getEsquerdo());
                }

                if (noParaDeletar.getEsquerdo() != sucessor) {
                    sucessor.setEsquerdo(noParaDeletar.getEsquerdo());
                }
                sucessor.setDireito(noParaDeletar.getDireito());

                parente.setDireito(sucessor);

            } else { //raiz
                No sucessor = this.pegarSucessor(noParaDeletar.getDireito());
                No parenteSucessor = this.pegarParente(sucessor.getId());

                if (parenteSucessor != noParaDeletar) {
                    parenteSucessor.setDireito(sucessor.getEsquerdo());
                }

                if (noParaDeletar.getEsquerdo() != sucessor) {
                    sucessor.setEsquerdo(noParaDeletar.getEsquerdo());
                }
                sucessor.setDireito(noParaDeletar.getDireito());

                this.raiz = sucessor;
            }
        }
    }

    private void imprimirArvore(No n) {
        if (n.getEsquerdo() != null) {
            imprimirArvore(n.getEsquerdo());
        }
        if (n.getDireito() != null) {
            imprimirArvore(n.getDireito());
        }

        System.out.println("Nó: " + n.getId() + ", valor: " + n.getValor());

    }

    public void imprimirArvore() {
        this.imprimirArvore(this.raiz);
    }

    public void apagarTudo() {
        this.raiz = null;
    }

    public void imprimirEspecial() {

        No aux = this.raiz;

        if (aux.quantidadeFilhos() == 0) {
            System.out.println("( " + aux.getValor() + ")");
            
        } else if (aux.quantidadeFilhos() == 1) {
            No parente = this.pegarParente(aux.getId());

            if (parente.getEsquerdo() != null) {
                System.out.println("( " + aux.getValor() + ")");
                System.out.println("/");
                System.out.println("( " + aux.getEsquerdo().getValor() + ")");

            } else {
                System.out.println("'\'");
                System.out.println("( " + aux.getDireito().getValor() + ")");
            }

        } else if (aux.quantidadeFilhos() == 2) {
            System.out.println("           (" + aux.getValor() + ")");
            System.out.println("      /                   \\");
            System.out.println("(" + aux.getEsquerdo().getValor() + ")              ("+ aux.getDireito().getValor() + ")");
        }

    }

}
