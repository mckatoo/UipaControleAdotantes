/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uipacontroleadotantes.banco.adotantes;

import uipacontroleadotantes.uteis.Sanitize;

/**
 *
 * @author mckatoo
 */
public class AdotantesBean {
    private int codAdotante;
    private String nome;
    private String telefone;
    private String celular;
    private String endereco;
    private String bairro;
    private String cidade;
    private String UF;
    private String CPF;
    private String RG;
    private char[] sexo;
    private String email;

    public int getCodAdotante() {
        return codAdotante;
    }

    public void setCodAdotante(int codAdotante) {
        this.codAdotante = codAdotante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public char[] getSexo() {
        return sexo;
    }

    public void setSexo(char[] sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Adotantes{" + "codAdotante=" + codAdotante + ", nome=" + nome + ", telefone=" + telefone + ", celular=" + celular + ", endereco=" + endereco + ", bairro=" + bairro + ", cidade=" + cidade + ", UF=" + UF + ", CPF=" + CPF + ", RG=" + RG + ", sexo=" + Sanitize.sanitizar(sexo) + ", email=" + email + '}';
    }
    
    
}
