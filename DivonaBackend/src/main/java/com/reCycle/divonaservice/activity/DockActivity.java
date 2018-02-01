package com.reCycle.divonaservice.activity;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.reCycle.divonaservice.representation.response.GetDockResponse;
import com.reCycle.divonaservice.service.IDockService;
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
@Api(value = "dock")
@Path("/dock")
@Slf4j
public class DockActivity {

    private IDockService dockService;

    @Inject
    public DockActivity(IDockService dockService) {
        this.dockService = dockService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "returns dock corresponding to Id",
            response = GetDockResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Api successfully responded"),
            @ApiResponse(code = 500, message = "Internal Server ErrorCode"),
            @ApiResponse(code = 400, message = "Request could not be be fulfilled due to bad syntax")
    })
    @Path("/{dockId}")
    public Response get(@PathParam("dockId") String dockId) {
        log.info("[get] received get request for dock id: " + dockId);
        return dockService.getDock(dockId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "returns all docks lying between skip and take, when ordered by Id.",
            response = Collection.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Api successfully responded"),
            @ApiResponse(code = 500, message = "Internal Server ErrorCode"),
            @ApiResponse(code = 400, message = "Request could not be be fulfilled due to bad syntax")
    })
    @Path("/take/{take}/skip/{skip}")
    public Response get(@PathParam("take") Integer take, @PathParam("skip") Integer skip) {
        log.info("[get] received get request for all dock, take: " + take + ", skip: " + skip);
        return dockService.getDocks(take, skip);
    }
}
