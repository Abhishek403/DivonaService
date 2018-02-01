package com.reCycle.divonaservice.representation.request;

import lombok.Data;
import lombok.NonNull;

/**
 * @author dasabhi
 */
@Data
public class ReserveCycleRequest {

    @NonNull
    private String cycleId;

    @NonNull
    private String userId;

    @NonNull
    private String dockId;

    @NonNull
    private Long reservedTimestampInSeconds;
}
