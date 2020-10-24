package com.carrito.compras.util;

import org.springframework.http.HttpStatus;

public class Utils {

    public static HttpStatus getHttpStatusResponse(Response response) {
        switch (response.getCodeMessage()) {
            case 200:
                return HttpStatus.OK;
            case 404:
                return HttpStatus.NOT_FOUND;
            case 500:
                return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.BAD_REQUEST;
    }
}
