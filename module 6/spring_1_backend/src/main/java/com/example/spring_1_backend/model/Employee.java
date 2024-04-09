package com.example.spring_1_backend.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Date birthdate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username_id", referencedColumnName = "username")
    private User user;
    private String cmnd;
    private boolean gender;
    private String email;
    private String img_url;
}
