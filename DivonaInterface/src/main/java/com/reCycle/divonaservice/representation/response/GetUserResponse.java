package com.reCycle.divonaservice.representation.response;

import com.reCycle.divonaservice.constant.UserStatus;
import lombok.Data;
import lombok.experimental.Builder;

/**
 * @author dasabhi
 */
@Data
@Builder
public class GetUserResponse {

    private String id;

    private UserStatus userStatus;
}
