package edu.iuh.fit.gk_xe.daos;

import edu.iuh.fit.gk_xe.models.Xe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Optional;

public class QuanlyXeDAO {
    private EntityManager entityManager;

    public QuanlyXeDAO() {
        this.entityManager = Persistence.createEntityManagerFactory("MariaDB").createEntityManager();
    }

    public Optional<Xe> findById(String id) {
        return Optional.ofNullable(entityManager.find(Xe.class, id));
    }

    public List<Xe> findAll() {
        return entityManager.createNamedQuery("Xe.findAll", Xe.class).getResultList();
    }

    public List<Xe> findByMaLoai(String maLoai) {
        return entityManager.createNamedQuery("Xe.findByMaLoai_MaLoai", Xe.class).setParameter("maLoai", maLoai).getResultList();
    }

    public boolean addXe(Xe xe) {
        entityManager.getTransaction().begin();
        entityManager.persist(xe);
        entityManager.getTransaction().commit();
        return true;
    }
}
