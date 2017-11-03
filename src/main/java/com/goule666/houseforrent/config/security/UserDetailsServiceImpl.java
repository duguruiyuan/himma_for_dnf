package com.goule666.houseforrent.config.security;

import com.goule666.houseforrent.model.UserDetailsDO;
import com.goule666.houseforrent.model.domain.RoleDO;
import com.goule666.houseforrent.model.domain.UserDO;
import com.goule666.houseforrent.service.RoleService;
import com.goule666.houseforrent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;

/**
 * 根据用户名，生成对应的权限。
 * @author niewenlong
 * @date 2017-10-24 15:53:25
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    /**
     * 获取 userDetail
     * @param username 用户名
     * @return userDeatails 用户详情
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) {
        UserDO user = userService.findByName(username);
        RoleDO role = roleService.findById(user.getRoleId());

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            Collection<? extends GrantedAuthority> authorities;
            try {
                //ROLE_ADMIN,user,admin 身份:权限
                authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(role.getRoleName() +"," + role.getAuth() + ",");
            } catch (Exception e) {
                authorities = null;
            }

            Date lastPasswordReset = new Date();
            lastPasswordReset.setTime(user.getLastPasswordChange().getTime());
            return new UserDetailsDO(
                    user.getId(),
                    user.getName(),
                    user.getPassword(),
                    lastPasswordReset,
                    authorities,
                    user.getEnable()
            );
        }
    }
}
