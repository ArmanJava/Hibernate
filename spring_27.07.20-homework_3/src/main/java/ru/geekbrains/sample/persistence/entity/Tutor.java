package ru.geekbrains.sample.persistence.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Tutor extends AbstractEntity{
    private String name;

    private Integer studentcount;

    private Date birthDate;

    private boolean master;

    @Column(name = "last_name")
    private String surname;

    @OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Student> students;

}
