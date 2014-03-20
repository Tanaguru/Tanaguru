/*
 *  Tanaguru - Automated webpage assessment
 *  Copyright (C) 2008-2012  Open-S Company
 * 
 *  This file is part of Tanaguru.
 * 
 *  Tanaguru is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License as
 *  published by the Free Software Foundation, either version 3 of the
 *  License, or (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Affero General Public License for more details.
 * 
 *  You should have received a copy of the GNU Affero General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 *  Contact us by mail: open-s AT open-s DOT com
 */

package org.opens.tgol.security.userdetails;

import java.util.List;
import org.opens.tgol.entity.service.user.UserDataService;
import org.opens.tgol.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

/**
 *
 * @author jkowalczyk
 */
public class TgolUserDetailsService extends JdbcDaoImpl {

    private UserDataService userDataService;
    @Autowired
    public void setUserDataService(UserDataService userDataService) {
        this.userDataService = userDataService;
    }
    
    /**
     * 
     */
    public TgolUserDetailsService() {
        super();
    }

    @Override
    protected UserDetails createUserDetails(String username, UserDetails userFromUserQuery,
            List<GrantedAuthority> combinedAuthorities) {
        
        User user = userDataService.getUserFromEmail(username);

        return new TgolUserDetails(
                username, 
                userFromUserQuery.getPassword(), 
                userFromUserQuery.isEnabled(),
                true, 
                true, 
                true, 
                combinedAuthorities,
                user);
    }
    
}