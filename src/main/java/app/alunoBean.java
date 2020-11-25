package app;


import infra.aluno;
import infra.aluno_1;
import infra.persist;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author jao
 */
@ManagedBean
@RequestScoped
public class alunoBean {

    aluno_1 Aluno = new aluno_1();
    private List<aluno_1> alunos = new ArrayList<>();

    public aluno_1 getAluno() {
        return Aluno;
    }

    public void setAluno(aluno_1 Aluno) {
        this.Aluno = Aluno;
    }

    public List<aluno_1> getAlunos() {
        EntityManager em = persist.getEntityManager();
        Query q = em.createQuery("select Aluno from aluno_1 Aluno", aluno_1.class);
        List<aluno_1> ps = q.getResultList();
        em.close();
        return ps;
    }
     public void excluir(aluno_1 Aluno){
        EntityManager em = persist.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        Aluno = em.merge(Aluno);
        em.remove(Aluno);
        et.commit();
        em.close();
    }

    public void setAlunos(List<aluno_1> alunos) {
        this.alunos = alunos;
    }
    public void status(){
        Aluno.setNotaFinal();
        Aluno.setStatus();
    }
    public String cadastrarAluno(){
        Aluno.setNotaFinal();
        Aluno.setStatus();
        EntityManager em = persist.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(Aluno);
        et.commit();
        em.close();
        return "cadastroAluno2";
    }
    
    
     
    public alunoBean() {
        
    }
    
}
