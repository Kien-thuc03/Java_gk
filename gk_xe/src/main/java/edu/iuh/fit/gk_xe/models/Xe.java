package edu.iuh.fit.gk_xe.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "xe")
@NamedQueries({
        @NamedQuery(name = "Xe.findAll", query = "select x from Xe x"),
        @NamedQuery(name = "Xe.findByMaLoai_MaLoai", query = "select x from Xe x where x.maLoai.maLoai = :maLoai")
})
public class Xe {
    @Id
    @Size(max = 50)
    @Column(name = "maXe", nullable = false, length = 50)
    private String maXe;

    @Size(max = 50)
    @NotNull
    @Column(name = "tenXe", nullable = false, length = 50)
    private String tenXe;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "gia", nullable = false)
    private Double gia;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "namSX", nullable = false)
    private Integer namSX;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "maLoai", nullable = false)
    private Loaixe maLoai;

    @Override
    public String toString() {
        return "Xe{" +
                "maXe='" + maXe + '\'' +
                ", tenXe='" + tenXe + '\'' +
                ", gia=" + gia +
                ", namSX=" + namSX +
                ", maLoai=" + maLoai +
                '}';
    }
}