/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author jao
 */
@Entity
public class folha implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double salarioBruto,inss,irrf,slarioLiquido;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public double getInss() {
        return inss;
    }

    public void setInss(double inss) {
        this.inss = inss;
    }

    public double getIrrf() {
        return irrf;
    }

    public void setIrrf(double irrf) {
        this.irrf = irrf;
    }

    public double getSlarioLiquido() {
        return slarioLiquido;
    }

    public void setSalarioLiquido(double slarioLiquido) {
        this.slarioLiquido = slarioLiquido;
    }
    
    public void calcularInss(){
        if(salarioBruto < 1751.82){
            this.inss = salarioBruto * 0.08;
        } else if(salarioBruto > 1751.81 && salarioBruto < 2919.73){
            this.inss = salarioBruto * 0.09;
        } else if(salarioBruto > 2919.72 && salarioBruto < 5839.46){
            this.inss = salarioBruto * 0.11;
        } else if (salarioBruto > 5839.45){
            this.inss = 817.66;
        }
    }
    
     public void calcularIrrf(){
        double salarioSInss = salarioBruto - this.getInss();
        if(salarioSInss < 1903.99){
            this.irrf = 0.0;
        } else if(salarioSInss > 1903.98 && salarioSInss < 2826.66){
            this.irrf = (salarioSInss * 0.075) - 142.80;
        } else if(salarioSInss > 2826.65 && salarioSInss < 3751.06) {
            this.irrf = (salarioSInss * 0.15) - 354.8;
        } else if(salarioSInss > 3751.05 && salarioSInss < 4664.69){
            this.irrf = (salarioSInss * 0.225) - 636.13;
        } else if(salarioSInss > 4664.68){
            this.irrf = (salarioSInss * 0.275) - 869.36;
        }
    }
     
     public void calcularSalarioLiquido(){
        this.slarioLiquido = this.salarioBruto - (this.getIrrf() + this.getInss());
    }

   
}
