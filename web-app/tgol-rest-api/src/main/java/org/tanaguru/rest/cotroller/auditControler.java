/*
 * Tanaguru - Automated webpage assessment
 * Copyright (C) 2008-2018  Tanaguru.org
 *
 * This file is part of Tanaguru.
 *
 * Tanaguru is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Contact us by mail: tanaguru AT tanaguru DOT org
 */
package org.tanaguru.rest.cotroller;

import java.util.Collection;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tanaguru.entity.audit.Audit;
import org.tanaguru.webapp.entity.user.User;
import org.tanaguru.entity.service.audit.AuditDataService;
import org.tanaguru.webapp.entity.service.user.UserDataService;


/**
 *
 * @author mkebri@tanaguru.com
 */
@Controller
//@RequestMapping("/users")
class auditController {
 
    
    private static final Logger LOGGER = Logger.getLogger(auditController.class);
//    private ProcessResultDataService processResultDataService;
//    @Autowired
//    public void setProcessResultDataService(ProcessResultDataService processResultDataService) {
//        this.processResultDataService = processResultDataService;
//    }
//  
//    
    @Autowired
    private AuditDataService auditDataService;
    
    private UserDataService userDataService ;
    @Autowired
    public void setUserDataService(UserDataService userDataService){
    this.userDataService = userDataService;
    }
    
 

//   @RequestMapping(value="/audits", method = RequestMethod.GET)
//  // @ResponseBody
//   public List<Audit> findAll() {
//       return (List<Audit>) auditDataService.findAll();
//   }
//   
   
   
   @RequestMapping(value ="/test", method = RequestMethod.GET)
   @ResponseBody
   public String test(){
       return "It works!";
   }
   
   @RequestMapping(value ="/audits/{id}", method = RequestMethod.GET)
   @ResponseBody
   public Audit getAudits(@PathVariable("id") long idAudit  ){
       LOGGER.debug("begin call get all");
       try {
          Audit audit;
           audit = auditDataService.read(idAudit);
            return  audit;
       } catch (Exception e) {
           LOGGER.debug(e);
       }
            
      return null;
   }
   
   
   @RequestMapping(value ="/users", method = RequestMethod.GET)
   @ResponseBody
   public  Collection<User> getAllUsers(){
       return  userDataService.findAll();
   }
   
   
   
   
 
//   @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//   @ResponseBody
//   public Audit findOne(@PathVariable("id") Long id) {
//       return RestPreconditions.checkFound( auditDataService.getAuditWithTest(id));
//   }
// 
//   @RequestMapping(method = RequestMethod.POST)
//   @ResponseStatus(HttpStatus.CREATED)
//   @ResponseBody
//   public Long create(@RequestBody Audit resource) {
//       Preconditions.checkNotNull(resource);
//       return auditDataService.create(resource);
//   }
// 
//   @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//   @ResponseStatus(HttpStatus.OK)
//   public void update(@PathVariable( "id" ) Long id, @RequestBody Foo resource) {
//       Preconditions.checkNotNull(resource);
//       RestPreconditions.checkNotNull(auditDataService.getById( resource.getId()));
//       auditDataService.update(resource);
//   }
// 
//   @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//   @ResponseStatus(HttpStatus.OK)
//   public void delete(@PathVariable("id") Long id) {
//       auditDataService.deleteById(id);
//   }
 
}