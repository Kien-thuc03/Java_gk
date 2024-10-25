package edu.iuh.fit.candidate_gk.models;

import edu.iuh.fit.candidate_gk.enums.Roles;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "experience")
@NamedQueries({
        @NamedQuery(name = "Experience.findAll", query = "select e from Experience e"),
        @NamedQuery(name = "Experience.findById", query = "select e from Experience e where e.id = :id")
})
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 120)
    @NotNull
    @ColumnDefault("''")
    @Column(name = "company", nullable = false, length = 120)
    private String company;

    @NotNull
    @Column(name = "from_date", nullable = false)
    private LocalDate fromDate;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Roles role;

    @NotNull
    @Column(name = "to_date", nullable = false)
    private LocalDate toDate;

    @Size(max = 400)
    @NotNull
    @ColumnDefault("''")
    @Column(name = "work_desc", nullable = false, length = 400)
    private String workDesc;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "candidate", nullable = false)
    private Candidate candidate;

}