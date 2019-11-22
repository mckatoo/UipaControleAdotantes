/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uipacontroleadotantes.banco.vacinados;

import java.time.LocalDate;

/**
 *
 * @author mckatoo
 */
public class VacinadosBean {
    private int codVacinado;
    private int codAnimal;
    private int codVacina;
    private LocalDate dtVac;
    private String Obs;

    public int getCodVacinado() {
        return codVacinado;
    }

    public void setCodVacinado(int codVacinado) {
        this.codVacinado = codVacinado;
    }

    public int getCodAnimal() {
        return codAnimal;
    }

    public void setCodAnimal(int codAnimal) {
        this.codAnimal = codAnimal;
    }

    public int getCodVacina() {
        return codVacina;
    }

    public void setCodVacina(int codVacina) {
        this.codVacina = codVacina;
    }

    public LocalDate getDtVac() {
        return dtVac;
    }

    public void setDtVac(LocalDate dtVac) {
        this.dtVac = dtVac;
    }

    public String getObs() {
        return Obs;
    }

    public void setObs(String Obs) {
        this.Obs = Obs;
    }

    @Override
    public String toString() {
        return "VacinadosBean{" + "codVacinado=" + codVacinado + ", codAnimal=" + codAnimal + ", codVacina=" + codVacina + ", dtVac=" + dtVac + ", Obs=" + Obs + '}';
    }
    
}
