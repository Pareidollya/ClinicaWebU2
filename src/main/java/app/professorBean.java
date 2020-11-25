
package app;

import infra.curso;
import infra.funcionario;
import infra.persist;
import infra.professor;
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
public class professorBean extends funcionarioBean{
    
    professor prof = new professor();
    private List<professor> professores = new ArrayList<>();
    
  
    public professor getProf() {
        return prof;
    }
    public void setProf(professor prof) {
        this.prof = prof;
    }

    public List<professor> getProfessores() {
        EntityManager em = persist.getEntityManager();
        Query q = em.createQuery("select prof from professor prof", professor.class);
        List<professor> ps = q.getResultList();
        em.close();
        return ps;
    }

    public void setProfessores(List<professor> professores) {
        this.professores = professores;
    } 
    
    public String cadastrarProfessor(){
        this.prof.setCargo("Professor");
        EntityManager em = persist.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(prof);
        et.commit();
        em.close();
        return "cadastroProfessor2";
        
    }
    public void excluir(professor prof){
        EntityManager em = persist.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        prof = em.merge(prof);
        em.remove(prof);
        et.commit();
        em.close();
    }
}
