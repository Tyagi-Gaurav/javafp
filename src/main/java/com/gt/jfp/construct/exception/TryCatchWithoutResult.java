package com.gt.jfp.construct.exception;

import java.util.function.Consumer;

public interface TryCatchWithoutResult {
    TryCatchWithoutResult onException(Consumer<Exception> consumer);

    TryCatchWithoutResult withFinally(Runnable function);

    void run();
}
