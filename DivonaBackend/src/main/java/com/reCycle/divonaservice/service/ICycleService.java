package com.reCycle.divonaservice.service;

import javax.ws.rs.core.Response;

/**
 * @author dasabhi
 */
public interface ICycleService {

    Response getCycle(String id);

    Response getCycles(Integer skip, Integer take);
}
