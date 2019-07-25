package org.tanaguru.webapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsByNameServiceWrapper;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.tanaguru.webapp.entity.service.user.RoleDataService;
import org.tanaguru.webapp.entity.service.user.UserDataService;
import org.tanaguru.webapp.entity.user.User;

public class SiteMinderToUserDetailsServiceWrapper<T extends Authentication> extends UserDetailsByNameServiceWrapper<T> {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    UserDataService userDataService;

    @Autowired
    RoleDataService roleDataService;

    @Override
    public UserDetails loadUserDetails(T authentication) {
        UserDetails userDetails = null;
        try{
            userDetails = userDetailsService.loadUserByUsername(authentication.getName());
        }catch (UsernameNotFoundException e){
            User user = userDataService.create();
            user.setEmail1(authentication.getName());
            user.setName(authentication.getName());
            user.setPassword("placeholder");
            user.setFirstName(authentication.getName());
            user.setAccountActivation(true);
            user.setRole(roleDataService.read(2l));
            userDataService.saveOrUpdate(user);
            userDetails = userDetailsService.loadUserByUsername(authentication.getName());
        }


        return userDetails;
    }
}
