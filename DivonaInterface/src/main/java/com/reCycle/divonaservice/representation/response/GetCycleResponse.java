package com.reCycle.divonaservice.representation.response;

import com.reCycle.divonaservice.constant.CycleStatus;
import lombok.Data;
import lombok.experimental.Builder;

/**
 * @author dasabhi
 */
@Data
@Builder
public class GetCycleResponse {

    private String id;

    private CycleStatus cycleStatus;
}
