package com.reCycle.divonaservice.service;

import com.reCycle.divonaservice.exception.ValidationException;
import com.reCycle.divonaservice.representation.request.ReserveCycleRequest;

import javax.ws.rs.core.Response;

/**
 * @author dasabhi
 */
public interface IReservationService {

    Response get(String userId, String cycleId, String Id);

//    Response getAll(String userId, String cycleId, String Id, String skip, String take);

    Response reserve(ReserveCycleRequest request) throws ValidationException;

    Response reserveComplete();


}
