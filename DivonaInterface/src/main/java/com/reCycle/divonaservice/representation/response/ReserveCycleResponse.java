package com.reCycle.divonaservice.representation.response;

import com.reCycle.divonaservice.constant.ErrorCode.ErrorCodeInfo;
import lombok.Data;
import lombok.experimental.Builder;

/**
 * @author dasabhi
 */
@Data
@Builder
public class ReserveCycleResponse {

    private String reservationId;

    private ErrorCodeInfo errorCodeInfo;
}
