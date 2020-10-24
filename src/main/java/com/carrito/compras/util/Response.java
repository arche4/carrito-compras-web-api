package com.carrito.compras.util;

import lombok.Data;

@Data
public class Response {
    private int codeMessage;
    private String message;
    private Object BackendMessage;

    public Response() {
    }

    public Response(int codeMessage, String message) {
        this.codeMessage = codeMessage;
        this.message = message;
    }

    public Response(int codeMessage, String message, Object backendMessage) {
        this.codeMessage = codeMessage;
        this.message = message;
        this.BackendMessage = backendMessage;
    }


}
