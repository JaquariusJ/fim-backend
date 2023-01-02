package com.money.fimsystem.security.vo;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.money.fimsystem.user.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.Transient;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class AuthUserDetails implements UserDetails {

    private User user;

    private List<String> authoriteStrings;

    @JsonIgnore
    private List<SimpleGrantedAuthority> authorities;

    public AuthUserDetails(User user, List<String> authoriteStrings) {
        this.user = user;
        this.authoriteStrings = authoriteStrings;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(CollectionUtils.isNotEmpty(authorities)){return authorities;}
        authorities = authoriteStrings.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
