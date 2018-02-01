package com.reCycle.divonaservice.service.impl;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.reCycle.divonaservice.constant.CycleStatus;
import com.reCycle.divonaservice.constant.ErrorCode.ErrorCodeType;
import com.reCycle.divonaservice.constant.UserStatus;
import com.reCycle.divonaservice.dao.ICycleDao;
import com.reCycle.divonaservice.dao.IReservationDao;
import com.reCycle.divonaservice.dao.IUserDao;
import com.reCycle.divonaservice.exception.ValidationException;
import com.reCycle.divonaservice.representation.request.ReserveCycleRequest;
import com.reCycle.divonaservice.representation.response.ReserveCycleResponse;
import com.reCycle.divonaservice.service.IReservationService;

import javax.ws.rs.core.Response;

/**
 * @author dasabhi
 */
public class ReservationService implements IReservationService {

    private IReservationDao reservationDao;
    private ICycleDao cycleDao;
    private IUserDao userDao;
    private long reservationMinInterval;

    @Inject ReservationService(IReservationDao reservationDao, ICycleDao cycleDao, IUserDao userDao,
            @Named("reservationMinInterval") long reservationMinInterval){
        this.reservationDao = reservationDao;
        this.cycleDao = cycleDao;
        this.userDao = userDao;
        this.reservationMinInterval = reservationMinInterval;
    }

    @Override public Response get(String userId, String cycleId, String Id) {
        return null;
    }

    @Override public Response reserve(ReserveCycleRequest request) throws ValidationException {
        validateReservation(request);
        return Response.status(Response.Status.OK)
                .entity(ReserveCycleResponse.builder().errorCodeInfo(null).reservationId("11")).build();
    }

    @Override public Response reserveComplete() {
        return null;
    }

    private void validateReservation(ReserveCycleRequest request) throws ValidationException {
        //check status.
        //        CycleStatus cycleStatus = cycleDao.get
        CycleStatus cycleStatus = CycleStatus.ON_TRIP;
        UserStatus userStatus = UserStatus.CANNOT_RESERVE;

        if (cycleStatus.name() != CycleStatus.DORMANT.name()) {
            throw new ValidationException("Cycle Status is: " + cycleStatus.name(),
                    ErrorCodeType.CYCLE_INELIGIBLE_FOR_RESERVATION_INVALID_STATUS);
        }

        if (userStatus.name() != UserStatus.LOGGED_IN.name()) {
            throw new ValidationException("User Status is: " + userStatus.name(),
                    ErrorCodeType.USER_INELIGIBLE_FOR_RESERVATION_INVALID_STATUS);
        }

        //GetLastReservation Status.
        long lastReservedTimestamp = request.getReservedTimestampInSeconds() - 3500;

        if (Long.compare(request.getReservedTimestampInSeconds(), lastReservedTimestamp) < reservationMinInterval){
            throw new ValidationException("Minimum interval violation occurred with last reservation on: "
                    + lastReservedTimestamp + ".",
                    ErrorCodeType.USER_INELIGIBLE_FOR_RESERVATION_MIN_INTERVAL_VIOLATION);
        }
    }
}
