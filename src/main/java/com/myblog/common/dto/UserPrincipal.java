package com.myblog.common.dto;

import cn.hutool.core.util.ObjectUtil;
import com.myblog.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lemoncc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPrincipal implements UserDetails {

    private Long userId;

    private String userIp;

    private String userName;

    private String userPassword;

    private String userEmail;

    private String userProfilePhoto;

    private Date gmtCreate;

    private Date userBirthday;

    private Integer userAge;

    private Integer userTelephoneNumber;

    private String userNickname;

    private Integer userStatus;

    private Integer userPermission;

    private Collection<? extends GrantedAuthority> authorities;

    public static UserPrincipal create(Users user, List<String> permissions) {
        List<SimpleGrantedAuthority> authorities = permissions.stream()
                .filter(ObjectUtil::isNotNull)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        return new UserPrincipal(user.getUserId(), user.getUserIp(), user.getUserName(), user.getUserPassword(),
                user.getUserEmail(), user.getUserProfilePhoto(), user.getGmtCreate(), user.getUserBirthday(),
                user.getUserAge(), user.getUserTelephoneNumber(), user.getUserNickname(), user.getUserStatus(), user.getUserPermission(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return userPassword;
    }

    @Override
    public String getUsername() {
        return userName;
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
