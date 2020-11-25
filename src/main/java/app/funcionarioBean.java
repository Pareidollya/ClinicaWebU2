
package app;
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
import javax.persistence.TypedQuery;
/**
 *
 * @author jao
 */
@ManagedBean
@RequestScoped
public class funcionarioBean {
    
    funcionario user = new funcionario();
    private List<funcionario> funcionarios = new ArrayList<funcionario>(); 

    public void setFuncionarios(List<funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public funcionario getUser() {
        return user;
    }

    public void setUser(funcionario user) {
        this.user = user;
    }
    
    public String cadastrarFuncionario(){
        EntityManager em = persist.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(user);
        et.commit();
        em.close();
        return "cadastrarFuncionario2";
        
    }
  
    public void selecionarFuncionario(funcionario user){
        this.user = user;
    }
    
    
    public void excluir(funcionario user){
        EntityManager em = persist.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        user = em.merge(user);
        em.remove(user);
        et.commit();
        em.close();
    }
    
    public List<funcionario> getFuncionarios() {   
        EntityManager em = persist.getEntityManager();
        Query q = em.createQuery("select user from funcionario user", funcionario.class);
        List<funcionario> funcionarioList = q.getResultList();
        em.close();
        return funcionarioList;
    }
    
    public List<funcionario> pesquisarNome(String nome){
        EntityManager em = persist.getEntityManager();
        String sim = "from funcionario where nome like :nomeFuncionario";
        TypedQuery<funcionario> query = em.createQuery(sim, funcionario.class);
        query.setParameter("nomeFuncionario", nome + "%");
        return query.getResultList();
    }
   
    
    public String commandBackCad(){
        return "cadastro";
    }
    public String commandFP(){
        return "folha";
    }
    public String commandAtt(){
        return "funcionarioList2";
    }
    public funcionarioBean() {


    }

}

