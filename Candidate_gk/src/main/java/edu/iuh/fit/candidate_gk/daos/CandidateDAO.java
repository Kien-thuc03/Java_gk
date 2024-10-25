package edu.iuh.fit.candidate_gk.daos;

import edu.iuh.fit.candidate_gk.enums.Roles;
import edu.iuh.fit.candidate_gk.models.Candidate;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Optional;

public class CandidateDAO {
    private EntityManager entityManager;

    public CandidateDAO() {
        this.entityManager = Persistence.createEntityManagerFactory("MariaDB").createEntityManager();
    }

    public Optional<Candidate> findById(String id) {
        return Optional.ofNullable(entityManager.find(Candidate.class, id));
    }

    public List<Candidate> findAll() {
        return entityManager.createNamedQuery("Candidate.findAll", Candidate.class).getResultList();
    }

    public List<Candidate> findByEmail(String gmail) {
        return entityManager.createNamedQuery("Candidate.findByEmailEndsWith", Candidate.class)
                .setParameter("email", gmail)
                .getResultList();
    }

    public List<Candidate> findByRole(Roles role) {
        return entityManager.createNamedQuery("Candidate.findByExperiences_Role", Candidate.class)
                .setParameter("role", role)
                .getResultList();
    }
}
