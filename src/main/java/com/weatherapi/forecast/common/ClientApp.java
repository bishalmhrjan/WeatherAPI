package com.weatherapi.forecast.common;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "client_apps")
public class ClientApp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 100, unique = true)
    private String clientId;

    @Column(nullable = false, length = 100, unique = true)
    private String clientSecret;

    @Transient
    private String rawClientSecret;

    private boolean enabled;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private AppRole role;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(orphanRemoval = true)
    @JoinTable(
            name = "apps_locations",
            joinColumns = {@JoinColumn(name = "app_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "location_code", referencedColumnName = "code")}
    )
    private Location location;

    private boolean trashed;


    public static ClientApp newSystemApp() {
        ClientApp newApp = new ClientApp();
        newApp.setRole(AppRole.SYSTEM);

        return newApp;
    }

    public static ClientApp newReaderApp() {
        ClientApp newApp = new ClientApp();
        newApp.setRole(AppRole.READER);

        return newApp;
    }

    public static ClientApp newUpdaterApp() {
        ClientApp newApp = new ClientApp();
        newApp.setRole(AppRole.UPDATE);

        return newApp;
    }



    @Transient
    public String getAssignedUser() {
        if (user == null) return null;
        return this.user.getName() + " - " + this.user.getEmail();
    }

    @Transient
    public String getAssignedLocation() {
        if (location == null) return null;
        return location.getCode() + " - " + location.getCityName() + ", " + location.getRegionName() + ", " + location.getCountryName();
    }

    @Transient
    public boolean isEditing() {
        return id != null && id > 0;
    }


}
