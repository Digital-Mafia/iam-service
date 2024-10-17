package com.digital.mafia.platform.service.iam.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,updatable = false,unique = true)
    private Long id;

    @Column(nullable = false, name = "user_login")
    private String userLogin;

    private String firstName;
    private String middleName;
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "tenant",foreignKey = @ForeignKey(name = "iam_user_tenant_fk"))
    private Tenant tenant;



}
