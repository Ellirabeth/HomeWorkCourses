import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//@ApplicationScoped
public class EntityManagerProducer {

    private EntityManagerFactory entityManagerFactory = //Persistence.createEntityManagerFactory();
//            Persistence.createEntityManagerFactory(HibernateUtil.PERSISTENT_UNIT_NAME);
            Persistence.createEntityManagerFactory("ru.easyjava.data.jpa.hibernate");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Produces
    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    @Produces
    public EntityManager createEntityManager() {
        return entityManager;
    }

}
