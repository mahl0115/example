package com.java8.iface;

import com.es.model.User;

/**
 * @author mahl
 * @create 2017-11-12
 */
public interface IUserService {

    User getUser(int id);

    default User getUser2(int id){
          return new User();
    }
}
