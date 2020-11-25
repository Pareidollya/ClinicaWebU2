package infra;

import java.io.Serializable;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author jao
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "aluno3")
public class aluno_1 extends nota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    
    private Long id;
    private String dataNascimento,status,sexo,curso;

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

     
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    
    public void setStatus() {
        if (this.getNotaFinal() >= 6){
            this.status = "Aprovado";
        }
        if(this.getNotaFinal() < 6 && this.getNotaFinal() >= 4){
            this.status = "Prova final";
        }
        if(this.getNotaFinal() < 4){
            this.status = "Reprovado";
        }
            
    }
    
    public String getStatus() {
        return this.status;
    }

   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public aluno_1() {
    }


    public void setStatus(String status) {
        this.status = status;
    }
    
}
