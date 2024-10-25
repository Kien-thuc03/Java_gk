package edu.iuh.fit.ongk.daos;

import edu.iuh.fit.ongk.models.Thuoc;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class ThuocDAO {
    private EntityManager entityManager;

    public ThuocDAO() {
        this.entityManager = Persistence.createEntityManagerFactory("MariaDB").createEntityManager();
    }

    public Optional<Thuoc> findById(String id) {
        return Optional.ofNullable(entityManager.find(Thuoc.class, id));
    }

    public List<Thuoc> findAll() {
        return entityManager.createNamedQuery("Thuoc.findAll", Thuoc.class).getResultList();
    }

    public List<Thuoc> findByMaLoai(String maLoai) {
        return entityManager.createNamedQuery("Thuoc.findByMaLoai_MaLoai", Thuoc.class).setParameter("maLoai", maLoai).getResultList();
    }

    public boolean addThuoc(Thuoc thuoc) {
        entityManager.getTransaction().begin();
        entityManager.persist(thuoc);
        entityManager.getTransaction().commit();
        return true;
    }

    public boolean updateThuoc(Thuoc thuoc) {
        entityManager.getTransaction().begin();
        entityManager.merge(thuoc);
        entityManager.getTransaction().commit();
        return true;
    }

    public boolean deleteThuoc(String maThuoc) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Thuoc.class, maThuoc));
        entityManager.getTransaction().commit();
        return true;
    }
}
