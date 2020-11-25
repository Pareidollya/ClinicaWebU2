
package infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author jao
 */
public class persist {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("PUC0.0PU");
    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
}
    
