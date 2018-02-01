package com.reCycle.divonaservice.activity;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.reCycle.divonaservice.representation.response.GetUserResponse;
import com.reCycle.divonaservice.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

/**
 * @author dasabhi
 */
@Singleton
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = "user")
@Path("/user")
@Slf4j
public class UserActivity {

    private IUserService userService;

    @Inject
    public UserActivity(IUserService userService) {
        this.userService = userService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "returns user corresponding to Id",
            response = GetUserResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Api successfully responded"),
            @ApiResponse(code = 500, message = "Internal Server ErrorCode"),
            @ApiResponse(code = 400, message = "Request could not be be fulfilled due to bad syntax")
    })
    @Path("/{userId}")
    public Response get(@PathParam("userId") String userId) {
        log.info("[get] received get request for user id: " + userId);
        return userService.getUser(userId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "returns all users lying between skip and take, when ordered by Id.",
            response = Collection.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Api successfully responded"),
            @ApiResponse(code = 500, message = "Internal Server ErrorCode"),
            @ApiResponse(code = 400, message = "Request could not be be fulfilled due to bad syntax")
    })
    @Path("/take/{take}/skip/{skip}")
    public Response get(@PathParam("take") Integer take, @PathParam("skip") Integer skip) {
        log.info("[get] received get request for all users, take: " + take + ", skip: " + skip);
        return userService.getUsers(take, skip);
    }
}
