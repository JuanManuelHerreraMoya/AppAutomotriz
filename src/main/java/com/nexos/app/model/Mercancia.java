package com.nexos.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mercancia")
public class Mercancia implements Serializable {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;

    @Column(name = "nombremercancia")
    private String nombremercancia;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "fechaingreso")
    private Date fechaIngreso;

    @Column(name = "usuarioresgistra")
    private String usuarioresgistra;
}
