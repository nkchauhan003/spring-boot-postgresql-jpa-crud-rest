package com.pw.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "TB_EMPLOYEE")
@Getter @Setter @NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Employee extends AbstractEntity {
    @NotBlank
    @Size(max = 20)
    @Column(name = "NAME")
    private String name;

    @NotBlank
    @Size(min = 2, max = 50)
    @Column(name = "DESIGNATION")
    private String designation;
}
