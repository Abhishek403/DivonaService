package com.reCycle.divonaservice.representation.response;

import com.reCycle.divonaservice.constant.DockStatus;
import lombok.Data;
import lombok.experimental.Builder;

/**
 * @author dasabhi
 */
@Data
@Builder
public class GetDockResponse {

    private String id;

    private DockStatus dockStatus;
}
