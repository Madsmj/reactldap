/*
 * Copyright 2005-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.ldap.samples.useradmin.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.samples.useradmin.domain.DepartmentRepo;
import org.springframework.ldap.samples.useradmin.domain.User;
import org.springframework.ldap.samples.useradmin.domain.Users;
import org.springframework.ldap.samples.useradmin.service.UserService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


@RestController
@RequestMapping("/rest")
public class RestCurrentUserController {

  private final AtomicInteger nextEmployeeNumber = new AtomicInteger(10);

  @Autowired
  private UserService userService;

  @Autowired
  private DepartmentRepo departmentRepo;

  @RequestMapping(value = {"/", "/current-user"}, method = { RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS } )
  public Users index(@RequestParam(required = false) String name) {
    Users usrs = new Users();
    if (StringUtils.hasText(name)) {
      usrs.setContent(userService.searchByNameName(name));
      return usrs;
    } else {
      List<User> userList = new ArrayList<User>();
      Iterable<User> all = userService.findAll();
      Iterator<User> iterator = all.iterator();
      while (iterator.hasNext()){
        User user = iterator.next();
        userList.add(user);
      }

      usrs.setContent(userList);
      return usrs;
    }

  }



}
