//package com.soccer.model.users;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//@Entity
//@Table(name = "users")
//public class Users  {
//    @Id
//    private String username;
//
//    @Column
//    private String password;
//
//    @Column
//    private boolean enabled;
//
//    @Column
//    private int roleid;
//
//    @Transient
//    private List<GrantedAuthority> roles = new ArrayList<>();
//
//    public List<GrantedAuthority> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(List<GrantedAuthority> roles) {
//        this.roles = roles;
//    }
//
//    public Users() {
//
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public boolean isEnabled() {
//        return enabled;
//    }
//
//    public void setEnabled(boolean enabled) {
//        this.enabled = enabled;
//    }
//
//    public void setRoleid(int roleid) {
//        this.roleid = roleid;
//    }
//
//    public int getRoleid() {
//        return roleid;
//    }
//
//    public void setRoleId(int roleId) {
//        this.roleid = roleId;
//    }
//}
//
//
