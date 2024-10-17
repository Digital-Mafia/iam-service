package com.digital.mafia.platform.service.iam.domain;

import com.digital.mafia.platform.service.entity.base.BaseTransactionalEntity;
import com.digital.mafia.platform.service.entity.base.DomainEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Tenant extends BaseTransactionalEntity implements DomainEntity<Tenant> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,updatable = false,unique = true)
    private Long id;

    @Column(name = "tenant_login",nullable = false, unique = true)
    private String tenantLogin;

    @Email
    @Column(nullable = false)
    private String email;

    private String icon;

    @Pattern(regexp = "^\\d{4,14}$",message = "Invalid Mobile Number")
    private String mobileNumber;
    private String countryCode;
    @Column(columnDefinition = "TEXT")
    private String description;
    private LocalDateTime onBoardedDateTime;
    private String status;

    @Builder
    public Tenant(String uuid, Long tenantId, Boolean isActive, String inactiveReason, Long appCreatedTimestamp, Long appLastModifiedTimestamp, Long id, String tenantLogin, String email, String icon, String mobileNumber, String countryCode, String description, LocalDateTime onBoardedDateTime, String status) {
        super(uuid, tenantId, isActive, inactiveReason, appCreatedTimestamp, appLastModifiedTimestamp);
        this.id = id;
        this.tenantLogin = tenantLogin;
        this.email = email;
        this.icon = icon;
        this.mobileNumber = mobileNumber;
        this.countryCode = countryCode;
        this.description = description;
        this.onBoardedDateTime = onBoardedDateTime;
        this.status = status;
    }
}
