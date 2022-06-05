package com.example.medical_history.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "assignment")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Assignment {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
    UUID id;

    String title;

    String description;

    Boolean isCompleted;

    @Version
    Integer version;

    @CreationTimestamp
    @Column(updatable = false)
    Timestamp createdDate;

    @UpdateTimestamp
    Timestamp lastModifiedDate;

    @JsonIgnore
    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "med_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "assignment_id", referencedColumnName = "id"))
    List<User> meds;
}
