package com.example.blog.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class MyUserDetail implements UserDetails {
    private User user;

    public MyUserDetail(User user) {
        this.user = user;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorityList = new ArrayList();
        Iterator var2 = this.user.getRoles().iterator();

        while(var2.hasNext()) {
            Role role = (Role)var2.next();
            grantedAuthorityList.add(new SimpleGrantedAuthority(role.getName()));
        }

        return grantedAuthorityList;
    }

    public String getPassword() {
        return this.user.getPassword();
    }

    public String getUsername() {
        return this.user.getUsername();
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return this.user.isEnabled();
    }
}
