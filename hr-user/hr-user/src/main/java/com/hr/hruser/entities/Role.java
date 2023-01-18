package com.hr.hruser.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_ROLE")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roleName;

    public Role(Long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
