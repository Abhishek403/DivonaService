package com.reCycle.divonaservice.exception;

import com.reCycle.divonaservice.constant.ErrorCode.ErrorCodeType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @author dasabhi
 */
@Data
@NoArgsConstructor
public class DivonaBaseException extends Exception {

    @NonNull private String message;
    @NonNull private ErrorCodeType errorCodeType;
    private Exception exception;

    public DivonaBaseException(String message, ErrorCodeType errorCodeType){
        this.message = message;
        this.errorCodeType = errorCodeType;
    }

    public DivonaBaseException(Exception exception, ErrorCodeType errorCodeType){
        this.exception = exception;
        this.errorCodeType = errorCodeType;
    }

    public DivonaBaseException(Exception exception, String message, ErrorCodeType errorCodeType) {
        this.exception = exception;
        this.message = message;
        this.errorCodeType = errorCodeType;
    }
}
