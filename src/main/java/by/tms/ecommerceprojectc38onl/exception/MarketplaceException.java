package by.tms.ecommerceprojectc38onl.exception;

import lombok.Getter;

@Getter
public class MarketplaceException extends RuntimeException {
    private final String errorCode;

    public MarketplaceException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}