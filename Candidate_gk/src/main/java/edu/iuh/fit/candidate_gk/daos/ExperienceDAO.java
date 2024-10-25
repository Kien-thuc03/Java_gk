package edu.iuh.fit.candidate_gk.daos;

import edu.iuh.fit.candidate_gk.models.Experience;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Optional;

public class ExperienceDAO {
    private EntityManager entityManager;

    public ExperienceDAO() {
        this.entityManager = Persistence.createEntityManagerFactory("MariaDB").createEntityManager();
    }

    public Optional<Experience> findById(String id) {
        return Optional.ofNullable(entityManager.find(Experience.class, id));
    }

    public List<Experience> findAll() {
        return entityManager.createNamedQuery("Experience.findAll", Experience.class).getResultList();
    }


}
