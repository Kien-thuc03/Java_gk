package edu.iuh.fit.gk_xe.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "loaixe")
@NamedQueries({
        @NamedQuery(name = "Loaixe.findAll", query = "select l from Loaixe l"),
        @NamedQuery(name = "Loaixe.findByMaLoai", query = "select l from Loaixe l where l.maLoai = :maLoai")
})
public class Loaixe {
    @Id
    @Size(max = 50)
    @Column(name = "maLoai", nullable = false, length = 50)
    private String maLoai;

    @Size(max = 50)
    @NotNull
    @Column(name = "tenLoai", nullable = false, length = 50)
    private String tenLoai;

    @OneToMany(mappedBy = "maLoai")
    private Set<Xe> xes = new LinkedHashSet<>();

    @Override
    public String toString() {
        return "Loaixe{" +
                "maLoai='" + maLoai + '\'' +
                ", tenLoai='" + tenLoai + '\'' +
                ", xes=" + xes +
                '}';
    }
}