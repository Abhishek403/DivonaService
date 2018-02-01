package com.reCycle.divonaservice.constant.ErrorCode;

/**
 * @author dasabhi
 */
public enum ErrorCodeType {

    INTERNAL_SERVER_ERROR ("DIVONA_001"),

    DEPENDANCY_ERROR("DIVONA_002"),

    USER_INELIGIBLE_FOR_RESERVATION_INVALID_STATUS("DIVONA_003"),

    CYCLE_INELIGIBLE_FOR_RESERVATION_INVALID_STATUS("DIVONA_004"),

    DOCK_INELIGIBLE_FOR_RESERVATION_INVALID_STATUS("DIVONA_005"),

    USER_INELIGIBLE_FOR_RESERVATION_MIN_INTERVAL_VIOLATION("DIVONA_006");

    private String errorCode;

    ErrorCodeType(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode(){
        return errorCode;
    }
}
