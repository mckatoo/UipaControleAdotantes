/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uipacontroleadotantes.banco.adotantes;

/**
 *
 * @author mckatoo
 */
public class AdotantesBean {
    private int codAdotante;
    private String nome;
    private String telefone;
    private String celular;
    private String cep;
    private String endereco;
    private String bairro;
    private String cidade;
    private String uf;
    private String cpf;
    private String rg;
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
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
        return "AdotantesBean{" + "codAdotante=" + codAdotante + ", nome=" + nome + ", telefone=" + telefone + ", celular=" + celular + ", cep=" + cep + ", endereco=" + endereco + ", bairro=" + bairro + ", cidade=" + cidade + ", uf=" + uf + ", cpf=" + cpf + ", rg=" + rg + ", sexo=" + sexo + ", email=" + email + '}';
    }

}
