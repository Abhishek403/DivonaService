package com.reCycle.divonaservice.activity;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.reCycle.divonaservice.constant.ErrorCode.ErrorCodeInfo;
import com.reCycle.divonaservice.constant.ErrorCode.ErrorCodeType;
import com.reCycle.divonaservice.exception.ValidationException;
import com.reCycle.divonaservice.representation.request.ReserveCycleRequest;
import com.reCycle.divonaservice.representation.response.ReserveCycleResponse;
import com.reCycle.divonaservice.service.IReservationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author dasabhi
 */
@Singleton
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = "reserve")
@Path("/reserve")
@Slf4j
public class ReservationActivity {

    private IReservationService reservationService;

    @Inject
    public ReservationActivity(IReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "performs cycle reservation, returns relevant information in case of success or failure",
            response = ReserveCycleResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Api successfully responded"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
            @ApiResponse(code = 400, message = "Request could not be be fulfilled due to bad syntax")
    })
    @Path("/")
    public Response reserveCycle(@Valid ReserveCycleRequest request) {
        log.info("Received request to perform reservation against the request: " + request);
        Response response = null;
        try {
            return reservationService.reserve(request);
        } catch (ValidationException ex){
            log.error("Failed to perform reservation against the request: " + request, ex);
            ReserveCycleResponse cycleResponse = ReserveCycleResponse.builder()
                    .reservationId(null)
                    .errorCodeInfo(new ErrorCodeInfo(ex.getMessage(), ex.getErrorCodeType()))
                    .build();

            response = Response.status(Response.Status.OK)
                    .entity(cycleResponse)
                    .build();
        } catch (Exception ex) {
            log.error("Failed to perform reservation against the request: " + request, ex);

            //Default error Code info
            ErrorCodeInfo errorCodeInfo = new ErrorCodeInfo();
            errorCodeInfo.setErrorCodeType(ErrorCodeType.INTERNAL_SERVER_ERROR);
            errorCodeInfo.setMessage(ex.getMessage());

            ReserveCycleResponse cycleResponse = ReserveCycleResponse.builder()
                    .reservationId(null)
                    .errorCodeInfo(errorCodeInfo)
                    .build();

            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(cycleResponse)
                    .build();
        }

        return response;
    }
}
