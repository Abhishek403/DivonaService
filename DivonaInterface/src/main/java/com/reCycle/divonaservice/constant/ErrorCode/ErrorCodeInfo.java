package com.reCycle.divonaservice.constant.ErrorCode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dasabhi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorCodeInfo {
    private String message;
    private ErrorCodeType errorCodeType;
}
