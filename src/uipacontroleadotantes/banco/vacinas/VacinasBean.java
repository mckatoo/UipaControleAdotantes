/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uipacontroleadotantes.banco.vacinas;

import uipacontroleadotantes.uteis.Sanitize;

/**
 *
 * @author mckatoo
 */
public class VacinasBean {

    private int codVacina;
    private String nome;
    private String Descricao;

    public int getCodVacina() {
        return codVacina;
    }

    public void setCodVacina(int codVacina) {
        this.codVacina = codVacina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    @Override
    public String toString() {
        return "VacinasBean{" + "codVacina=" + codVacina + ", nome=" + nome + ", Descricao=" + Descricao + '}';
    }

}
