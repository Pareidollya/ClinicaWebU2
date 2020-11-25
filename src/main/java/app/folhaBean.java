/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import infra.curso;
import infra.folha;
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
public class folhaBean {
    folha pagamento = new folha();
     private List<folha> pagamentos = new ArrayList<folha>();


   public void setPagamentos(List<folha> pagamentos) {
     this.pagamentos = pagamentos;
    }
     
    public folha getPagamento() {
        return pagamento;
    }

    public void setPagamento(folha pagamento) {
        this.pagamento = pagamento;
    }
    
    public void calcularFolha() {
        
        pagamento.calcularInss();
        pagamento.calcularIrrf();
        pagamento.calcularSalarioLiquido();
    }
    public String cadastrarFolha(){
        EntityManager em = persist.getEntityManager();
        EntityTransaction et = em.getTransaction();
        
        pagamento.calcularInss();
        pagamento.calcularIrrf();
        pagamento.calcularSalarioLiquido();
        
        et.begin();
        em.merge(pagamento);
        et.commit();
        em.close();
        return "folha2";
    }
   
     public List<folha> getPagamentos() {   
        EntityManager em = persist.getEntityManager();
        Query q = em.createQuery("select pagamento from folha pagamento", folha.class);
        List<folha> folhaList = q.getResultList();
        em.close();
       return folhaList;
    }
     
     public void excluir(folha pagamento){
        EntityManager em = persist.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        pagamento = em.merge(pagamento);
        em.remove(pagamento);
        et.commit();
        em.close();
    }
     
    public String commandBackFolha(){
        return "folha";
    }
    public folhaBean() {
   
    }
    
}
