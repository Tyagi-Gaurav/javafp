package com.gt.jfp.construct.exception;

import java.util.function.Consumer;
import java.util.function.Supplier;

public interface TryCatchWithResult<T> {
    TryCatchWithResult<T> onException(Consumer<Throwable> function);

    TryCatchWithResult<T> onExceptionReturn(Supplier<T> function);

    TryCatchWithResult<T> withFinally(Supplier<Void> function);

    T run();
}
