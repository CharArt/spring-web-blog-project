package ru.specialist.java.spring.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="role")
public class Role {

    public static final int ADMIN = 1;
    public static final int USER = 2;

    @Id
    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public Integer getRoleId() {return roleId;}
    public void setRoleId(Integer roleId) {this.roleId = roleId;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public List<User> getUsers() {return users;}
    public void setUsers(List<User> users) {this.users = users;}
}
