
package app;

import infra.aluno_1;
import infra.curso;
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
public class cursoBean {
    curso Curso = new curso();
    aluno_1 Aluno = new aluno_1();
    professor Prof = new professor();
    
    
    
    public curso getCurso() {
        return Curso;
    }

    public void setCurso(curso Curso) {
        this.Curso = Curso;
    }


        public List<curso> getCursos() {
        EntityManager em = persist.getEntityManager();
        Query q = em.createQuery("select Curso from curso Curso", curso.class);
        List<curso> ps = q.getResultList();
        em.close();
        return ps;
    }

    public aluno_1 getAluno() {
        return Aluno;
    }

    public void setAluno(aluno_1 Aluno) {
        this.Aluno = Aluno;
    }

    public professor getProf() {
        return Prof;
    }

    public void setProf(professor prof) {
        this.Prof = prof;
    }

    ////////////////
    public void salvarAlunoCurso(){
        
        this.Curso.setAlunos();
        this.Aluno.setCurso(this.Curso.getTitulo());
        this.Aluno.setNotaFinal();
        this.Aluno.setStatus();
        
  
        
        EntityManager em = persist.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(Aluno);
        et.commit();
        em.close();
    }
    public String salvarAlunoCursoNota(){
        this.Curso.setAlunos();
        this.Aluno.setCurso(this.Curso.getTitulo());
        this.Aluno.setNotaFinal();
        this.Aluno.setStatus();
        
        
        EntityManager em = persist.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(Aluno);
        et.commit();
        em.close();
        return "cadastrarCurso2";
    }
    
    
    public String alunoSalvo(){
        return Aluno.getNome();
    }
        
    
    public void salvarProfCurso(){
        this.Curso.setProfessores();
        this.Prof.setAreaInteresse(this.Curso.getTitulo());
 
        EntityManager em = persist.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(Prof);
        et.commit();
        em.close();
      
    }
    public String profSalvo(){
        return Prof.getNome();
    }
    
    
    public String cadastrarCurso(){
        this.Curso.setProfessores();
        this.Prof.setCargo("Professor");
        this.Prof.setAreaInteresse(this.Curso.getTitulo());
        
        EntityManager em = persist.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(Curso);
        em.merge(Prof);
        et.commit();
        em.close();
        return "cadastrarCurso2";
    }
    public void excluirCurso(curso Curso){
        EntityManager em = persist.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        Curso = em.merge(Curso);
        em.remove(Curso);
        et.commit();
        em.close();
    }

    
    public cursoBean() {
    }
    
}
