/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uipacontroleadotantes.banco.animais;

import java.time.LocalDate;

/**
 *
 * @author mckatoo
 */
public class AnimaisBean {
    private int codAnimal;
    private String nome;
    private String especie;
    private char[] sexo;
    private LocalDate dataNasc;
    private char[] porte;
    private char[] castrado;
    private int codAdotante;
    private LocalDate dataAdocao;

    public int getCodAnimal() {
        return codAnimal;
    }

    public void setCodAnimal(int codAnimal) {
        this.codAnimal = codAnimal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public char[] getSexo() {
        return sexo;
    }

    public void setSexo(char[] sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public char[] getPorte() {
        return porte;
    }

    public void setPorte(char[] porte) {
        this.porte = porte;
    }

    public char[] getCastrado() {
        return castrado;
    }

    public void setCastrado(char[] castrado) {
        this.castrado = castrado;
    }

    public int getCodAdotante() {
        return codAdotante;
    }

    public void setCodAdotante(int codAdotante) {
        this.codAdotante = codAdotante;
    }

    public LocalDate getDataAdocao() {
        return dataAdocao;
    }

    public void setDataAdocao(LocalDate dataAdocao) {
        this.dataAdocao = dataAdocao;
    }

    @Override
    public String toString() {
        return "AnimaisBean{" + "codAnimal=" + codAnimal + ", nome=" + nome + ", especie=" + especie + ", sexo=" + sexo + ", dataNasc=" + dataNasc + ", porte=" + porte + ", castrado=" + castrado + ", codAdotante=" + codAdotante + ", dataAdocao=" + dataAdocao + '}';
    }
    
}
