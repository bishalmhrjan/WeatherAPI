package com.weatherapi.forecast.common;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@Builder
@AllArgsConstructor

public class User implements Serializable {

    public static final long serialVersionUID = 1234L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Column(nullable = false, length = 70)
    private String password;

    @Column(nullable = false, length = 50)
    private String name;

    private boolean enabled;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private UserType type;

    private boolean trashed;

    public User() {
        this.enabled = true;
    }
    public User(Integer id) {
        super();
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
