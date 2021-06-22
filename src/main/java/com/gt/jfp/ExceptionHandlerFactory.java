package com.gt.jfp;

import com.gt.jfp.construct.TryCatchWithoutResult;
import com.gt.jfp.domain.Routine;
import com.gt.jfp.domain.TryCatch;

public class ExceptionHandlerFactory {
    public static TryCatch TryCatchWithoutResult(Routine consumer) {
        return new TryCatchWithoutResult(consumer);
    }
}
