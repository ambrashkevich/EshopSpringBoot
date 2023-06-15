package com.tms.shop.utils;

import static org.apache.logging.log4j.util.Strings.isBlank;

import com.tms.shop.exceptions.ValidationException;
import lombok.experimental.UtilityClass;

@UtilityClass
public class HttpRequestParamValidator {

    private static final String REQUEST_PARAMETER_IS_NULL_ERROR = "Request parameter is not initialized!";

    public static void validateParam(String param) throws ValidationException {
        if (isBlank(param)) {
            throw new ValidationException(REQUEST_PARAMETER_IS_NULL_ERROR);
        }
    }
}