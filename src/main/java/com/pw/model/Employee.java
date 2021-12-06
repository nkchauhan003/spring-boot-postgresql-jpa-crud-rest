package com.pw.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
