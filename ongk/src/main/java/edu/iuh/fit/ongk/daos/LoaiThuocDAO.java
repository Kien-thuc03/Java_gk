package edu.iuh.fit.ongk.daos;

import edu.iuh.fit.ongk.models.LoaiThuoc;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class LoaiThuocDAO {
    private EntityManager entityManager;

    public LoaiThuocDAO() {
        this.entityManager = Persistence.createEntityManagerFactory("MariaDB").createEntityManager();
    }

    public Optional<LoaiThuoc> findById(String id) {
        return Optional.ofNullable(entityManager.find(LoaiThuoc.class, id));
    }

    public List<LoaiThuoc> findAll() {
        return entityManager.createNamedQuery("LoaiThuoc.findAll", LoaiThuoc.class).getResultList();
    }

    public boolean addLoaiThuoc(LoaiThuoc loaiThuoc) {
        entityManager.getTransaction().begin();
        entityManager.persist(loaiThuoc);
        entityManager.getTransaction().commit();
        return true;
    }

    public boolean updateLoaiThuoc(LoaiThuoc loaiThuoc) {
        entityManager.getTransaction().begin();
        entityManager.merge(loaiThuoc);
        entityManager.getTransaction().commit();
        return true;
    }

    public boolean deleteLoaiThuoc(String maLoai) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(LoaiThuoc.class, maLoai));
        entityManager.getTransaction().commit();
        return true;
    }

}
