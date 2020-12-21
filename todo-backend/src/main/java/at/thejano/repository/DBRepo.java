package at.thejano.repository;

import at.thejano.entity.Status;
import at.thejano.entity.TODO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class DBRepo {
    @Inject
    public EntityManager em;


    public void initDB() {
        this.create(new TODO(0, "Implement database", "10.12.2020", "Jan Fischlmayr", "Ready"));
        this.create(new TODO(1, "Implement backend", "12.12.2020", "Jan Fischlmayr", "Ready"));
        this.create(new TODO(2, "Implement frontend", "20.12.2020", "Jan Fischlmayr", "Ready"));
        this.create(new TODO(3, "Present project", "22.12.2020", "Jan Fischlmayr", "In Progress"));
        this.create(new TODO(4, "Give an A+", "22.12.2020", "Prof. Lackinger", "In Progress"));
    }

    @Transactional
    public TODO create(TODO todo) {
        em.persist(todo);
        return todo;
    }
    @Transactional
    public void update(TODO todo) {
        em.merge(todo);
    }

    @Transactional
    public void delete(long id) {
        em.remove(find(id));
    }

    public TODO find(long id) {
        return this.em.find(TODO.class, id);
    }

    public List<TODO> findAll () {
        return this.em.createNamedQuery("TODO.findAll", TODO.class).getResultList();
    }
}
