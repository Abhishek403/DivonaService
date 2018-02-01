package com.reCycle.divonaservice.service.impl;

import com.google.inject.Inject;
import com.reCycle.divonaservice.constant.CycleStatus;
import com.reCycle.divonaservice.dao.ICycleDao;
import com.reCycle.divonaservice.representation.response.GetCycleResponse;
import com.reCycle.divonaservice.service.ICycleService;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

/**
 * @author dasabhi
 */
@Slf4j
public class CycleService implements ICycleService {

    private ICycleDao cycleDao;

    @Inject
    public CycleService(ICycleDao cycleDao) {
        this.cycleDao = cycleDao;
    }

    @Override public Response getCycle(String id) {
        GetCycleResponse getCycleResponse = GetCycleResponse.builder()
                .cycleStatus(CycleStatus.PROVISIONED)
                .id("1")
                .build();

        return Response.status(Response.Status.OK).entity(getCycleResponse).build();
    }

    @Override public Response getCycles(Integer skip, Integer take) {
        GetCycleResponse getCycleResponse1 = GetCycleResponse.builder()
                .cycleStatus(CycleStatus.PROVISIONED)
                .id("1")
                .build();

        GetCycleResponse getCycleResponse2 = GetCycleResponse.builder()
                .cycleStatus(CycleStatus.ON_TRIP)
                .id("2")
                .build();

        List<GetCycleResponse> responseList = Arrays.asList(getCycleResponse1, getCycleResponse2);

        return Response.status(Response.Status.OK).entity(responseList).build();
    }
}

