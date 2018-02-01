package com.reCycle.divonaservice.exception;

import com.reCycle.divonaservice.constant.ErrorCode.ErrorCodeType;

/**
 * @author dasabhi
 */
public class ValidationException extends DivonaBaseException {

   public ValidationException(String message, ErrorCodeType errorCodeType){
       super(message, errorCodeType);
   }
}
