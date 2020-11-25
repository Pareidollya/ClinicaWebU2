
package app;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class navegação {
    public String cadFuncionario(){
        return "cadastrarFuncionario";
        }
    
    public String folhaPagamento(){
        return "folha";
        
    }
    public String main(){
        return "Principal";
    }
    
    public String cadProfessor(){
        return "cadastroProfessor";
    }
    public String cadCurso(){
        return "cadastrarCurso";
    }
    public String cadAluno(){
        return "cadastroAluno";
    }
    public String principal(){
        return "Principal";
    }
    
    public navegação() {
        
    }
    
}
