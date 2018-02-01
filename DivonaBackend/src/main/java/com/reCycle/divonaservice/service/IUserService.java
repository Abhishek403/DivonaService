package com.reCycle.divonaservice.service;

import javax.ws.rs.core.Response;

/**
 * @author dasabhi
 */
public interface IUserService {

    Response getUser(String id);

    Response getUsers(Integer skip, Integer take);
}
