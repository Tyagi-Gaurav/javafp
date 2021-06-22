package com.gt.jfp.domain;

public interface TryCatch {
    TryCatch onException(Routine function);

    TryCatch withFinally(Routine function);

    void run();
}
