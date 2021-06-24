package com.gt.jfp.construct.exception;

import com.gt.jfp.construct.exception.TryCatchWithResult;
import com.gt.jfp.construct.exception.TryCatchWithResultImpl;
import com.gt.jfp.construct.exception.TryCatchWithoutResultImpl;
import com.gt.jfp.construct.exception.TryCatchWithoutResult;

import java.util.function.Supplier;

public class ExceptionHandlerFactory {
    public static TryCatchWithoutResult TryCatchWithoutResult(Runnable runnable) {
        return new TryCatchWithoutResultImpl(runnable);
    }

    public static <T> TryCatchWithResult<T> TryCatchWithResult(Supplier<T> supplier) {
        return new TryCatchWithResultImpl(supplier);
    }
}
