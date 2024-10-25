package edu.iuh.fit.gk_xe.daos;

import edu.iuh.fit.gk_xe.models.Loaixe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Optional;

public class QuanlyLoaiXeDAO {
    private EntityManager entityManager;

    public QuanlyLoaiXeDAO() {
        this.entityManager = Persistence.createEntityManagerFactory("MariaDB").createEntityManager();
    }

    public Optional<Loaixe> findById(String id) {
        return Optional.ofNullable(entityManager.find(Loaixe.class, id));
    }

    public List<Loaixe> findAll() {
        return entityManager.createNamedQuery("Loaixe.findAll", Loaixe.class).getResultList();
    }


}
