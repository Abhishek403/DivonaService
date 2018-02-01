package com.reCycle.divonaservice.service;

import javax.ws.rs.core.Response;

/**
 * @author dasabhi
 */
public interface IDockService {

    Response getDock(String id);

    Response getDocks(Integer skip, Integer take);
}
