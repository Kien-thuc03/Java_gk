package edu.iuh.fit.candidate_gk.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "candidate")
@NamedQueries({
        @NamedQuery(name = "Candidate.findAll", query = "select c from Candidate c"),
        @NamedQuery(name = "Candidate.findById", query = "select c from Candidate c where c.id = :id"),
        @NamedQuery(name = "Candidate.findByEmailLike", query = "select c from Candidate c where c.email like :email"),
        @NamedQuery(name = "Candidate.findByEmailEndsWith", query = "select c from Candidate c where c.email like concat('%', :email)"),
        @NamedQuery(name = "Candidate.findByExperiences_Role", query = "select c from Candidate c inner join c.experiences experiences where experiences.role = :role")
})
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 255)
    @NotNull
    @ColumnDefault("''")
    @Column(name = "email", nullable = false)
    private String email;

    @Size(max = 255)
    @NotNull
    @ColumnDefault("''")
    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Size(max = 15)
    @NotNull
    @ColumnDefault("'0'")
    @Column(name = "phone", nullable = false, length = 15)
    private String phone;

    @OneToMany(mappedBy = "candidate")
    private List<Experience> experiences;

}