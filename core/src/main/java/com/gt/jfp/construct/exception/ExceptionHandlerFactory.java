package com.gt.jfp.construct.exception;

import java.util.function.Supplier;

public class ExceptionHandlerFactory {

    private ExceptionHandlerFactory() {}

    public static TryCatchWithoutResult TryCatchWithoutResult(Runnable runnable) {
        return new TryCatchWithoutResultImpl(runnable);
    }

    public static <T> TryCatchWithResult<T> TryCatchWithResult(Supplier<T> supplier) {
        return new TryCatchWithResultImpl<>(supplier);
    }
}
