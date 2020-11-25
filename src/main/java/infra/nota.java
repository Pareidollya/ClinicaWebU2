
package infra;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class nota extends Pessoa {
    private double nota1,nota2,nota3,nota4,notaFinal;
    private String descrição;
   

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public double getNota4() {
        return nota4;
    }

    public void setNota4(double nota4) {
        this.nota4 = nota4;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public void inserirNota(double nota1,double nota2,double nota3,double nota4){
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.nota4 = nota4;
    }
    public void setNotaFinal() {
        this.notaFinal = (this.nota1 + this.nota2 +this.nota3 +this.nota4)/4;
    }
    public double getNotaFinal() {
        return notaFinal;
    }
            
     
    }

    
    

