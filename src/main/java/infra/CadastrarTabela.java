
package infra;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

    
public class CadastrarTabela {
    public static void main(String[]args){
        EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("PUC0.0PU");
        EntityManager em = emf.createEntityManager();
        
        curso user = new curso();
        
        
        user.setTitulo("sim");
        user.setDescrição("sim");
        user.setCargaHoraria("0");
        user.setValor("19");
        
        user.setProfessores();
        user.setAlunos();
        
        
        
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(user);

        et.commit();
        em.close();
        emf.close();
}
    
}
