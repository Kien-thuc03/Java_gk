package edu.iuh.fit.ongk.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "thuoc")
@NamedQueries({
        @NamedQuery(name = "Thuoc.findAll", query = "select t from Thuoc t"),
        @NamedQuery(name = "Thuoc.findByMaThuoc", query = "select t from Thuoc t where t.maThuoc = :maThuoc"),
        @NamedQuery(name = "Thuoc.findByMaLoai_MaLoai", query = "select t from Thuoc t where t.maLoai.maLoai = :maLoai")
})
public class Thuoc {
    @Id
    @Size(max = 255)
    @Column(name = "ma_thuoc", nullable = false)
    private String maThuoc;

    @Column(name = "GIA")
    private Double gia;

    @Column(name = "nam_sx")
    private Integer namSx;

    @Size(max = 255)
    @Column(name = "ten_thuoc")
    private String tenThuoc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_loai")
    private LoaiThuoc maLoai;

    public String getMaThuoc() {
        return maThuoc;
    }

    public void setMaThuoc(String maThuoc) {
        this.maThuoc = maThuoc;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public Integer getNamSx() {
        return namSx;
    }

    public void setNamSx(Integer namSx) {
        this.namSx = namSx;
    }

    public String getTenThuoc() {
        return tenThuoc;
    }

    public void setTenThuoc(String tenThuoc) {
        this.tenThuoc = tenThuoc;
    }

    public LoaiThuoc getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(LoaiThuoc maLoai) {
        this.maLoai = maLoai;
    }

}