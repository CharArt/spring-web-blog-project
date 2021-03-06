package ru.specialist.java.spring.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="\"user\"")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user" )
    private List<Post> posts;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "is_active")
    private boolean isActive;

    public User() { createdAt = LocalDateTime.now();}

    public Long getUserId() {return userId;}
    public void setUserId(Long userId) {this.userId = userId;}

    public List<Role> getRoles() {return roles;}
    public void setRoles(List<Role> roles) {this.roles = roles;}

    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public LocalDateTime getCreatedAt() {return createdAt;}
    public void setCreatedAt(LocalDateTime createdAt) {this.createdAt = createdAt;}

    public List<Post> getPosts() {return posts;}
    public void setPosts(List<Post> posts) {this.posts = posts;}

    public boolean getIsActive() {return isActive;}
    public void setIsActive(boolean active) {isActive = active;}
}