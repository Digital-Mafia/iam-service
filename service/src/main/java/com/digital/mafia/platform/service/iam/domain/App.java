package com.digital.mafia.platform.service.iam.domain;

import com.digital.mafia.platform.service.entity.base.BaseTransactionalEntity;
import com.digital.mafia.platform.service.entity.base.DomainEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
public class App extends BaseTransactionalEntity implements DomainEntity<App> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,updatable = false,unique = true)
    private Long id;

    @Column(name = "app_code",unique = true,updatable = false)
    private String appCode;

    @Column(name = "app_key",unique = true,updatable = false)
    private String appKey;

    private String icon;

    @Column(name = "support_user_login")
    private String supportUserLogin;

    @Column(name = "tenant_login")
    private String tenantLogin;

    @Column(name = "type")
    private String type;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name="app_open_apis",
            joinColumns = @JoinColumn(name =  "app_id"),
            uniqueConstraints = @UniqueConstraint(name = "app_unique_path",columnNames = {"app_id","open_apis"})
    )
    private Set<String> openApis;

    @Builder
    public App(String uuid, Long tenantId, Boolean isActive, String inactiveReason, Long appCreatedTimestamp, Long appLastModifiedTimestamp, Long id, String appCode, String appKey, String icon, String supportUserLogin, String tenantLogin, String type, Set<String> openApis) {
        super(uuid, tenantId, isActive, inactiveReason, appCreatedTimestamp, appLastModifiedTimestamp);
        this.id = id;
        this.appCode = appCode;
        this.appKey = appKey;
        this.icon = icon;
        this.supportUserLogin = supportUserLogin;
        this.tenantLogin = tenantLogin;
        this.type = type;
        this.openApis = openApis;
    }

    public App init(){
        this.id = null;
        return this;
    }
    public void appOpenApis(Set<String> openApis){
        if(Objects.isNull(this.openApis)) this.openApis = new LinkedHashSet<>();
        this.openApis.addAll(openApis);
    }

}
