package edu.iuh.fit.ongk.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "loai_thuoc")
@NamedQueries({
        @NamedQuery(name = "LoaiThuoc.findAll", query = "select l from LoaiThuoc l"),
        @NamedQuery(name = "LoaiThuoc.findByMaLoai", query = "select l from LoaiThuoc l where l.maLoai = :maLoai")
})
public class LoaiThuoc {
    @Id
    @Size(max = 255)
    @Column(name = "ma_loai", nullable = false)
    private String maLoai;

    @Size(max = 255)
    @Column(name = "ten_loai")
    private String tenLoai;

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

}