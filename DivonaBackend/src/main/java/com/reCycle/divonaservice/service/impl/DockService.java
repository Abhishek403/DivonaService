package com.reCycle.divonaservice.service.impl;

import com.google.inject.Inject;
import com.reCycle.divonaservice.constant.DockStatus;
import com.reCycle.divonaservice.dao.IDockDao;
import com.reCycle.divonaservice.representation.response.GetDockResponse;
import com.reCycle.divonaservice.service.IDockService;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.core.Response;
import java.util.Arrays;

/**
 * @author dasabhi
 */
@Slf4j
public class DockService implements IDockService {

    private IDockDao dockDao;

    @Inject
    public DockService(IDockDao dockDao) {
        this.dockDao = dockDao;
    }

    @Override public Response getDock(String id) {
        GetDockResponse dockResponse = GetDockResponse.builder()
                .dockStatus(DockStatus.ACTIVE)
                .id("1")
                .build();

        return Response.status(Response.Status.OK).entity(dockResponse).build();
    }

    @Override public Response getDocks(Integer skip, Integer take) {
        GetDockResponse dockResponse1 = GetDockResponse.builder()
                .dockStatus(DockStatus.ACTIVE)
                .id("1")
                .build();

        GetDockResponse dockResponse2 = GetDockResponse.builder()
                .dockStatus(DockStatus.INACTIVE)
                .id("2")
                .build();

        return Response.status(Response.Status.OK).entity(Arrays.asList(
                dockResponse1,
                dockResponse2
        )).build();
    }
}
