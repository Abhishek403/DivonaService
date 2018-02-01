package com.reCycle.divonaservice.service.impl;

import com.google.inject.Inject;
import com.reCycle.divonaservice.constant.UserStatus;
import com.reCycle.divonaservice.dao.IUserDao;
import com.reCycle.divonaservice.representation.response.GetUserResponse;
import com.reCycle.divonaservice.service.IUserService;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.core.Response;
import java.util.Arrays;

/**
 * @author dasabhi
 */
@Slf4j
public class UserService implements IUserService {

    private IUserDao userDao;

    @Inject
    public UserService(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override public Response getUser(String id) {
        GetUserResponse userResponse = GetUserResponse.builder()
                .userStatus(UserStatus.PROVISIONED)
                .id("1")
                .build();

        return Response.status(Response.Status.OK).entity(userResponse).build();
    }

    @Override public Response getUsers(Integer skip, Integer take) {
        GetUserResponse userResponse1 = GetUserResponse.builder()
                .userStatus(UserStatus.PROVISIONED)
                .id("1")
                .build();

        GetUserResponse userResponse2 = GetUserResponse.builder()
                .userStatus(UserStatus.SUSPENDED)
                .id("2")
                .build();

        GetUserResponse userResponse3 = GetUserResponse.builder()
                .userStatus(UserStatus.CANNOT_RESERVE)
                .id("3")
                .build();

        return Response.status(Response.Status.OK).entity(Arrays.asList(
                userResponse1,
                userResponse2,
                userResponse3
        )).build();
    }
}
