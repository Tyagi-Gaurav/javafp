package com.gt.jfp.construct;

import com.gt.jfp.domain.Routine;
import com.gt.jfp.domain.TryCatch;

public class TryCatchWithoutResult implements TryCatch {
    private final Routine routine;
    private Routine exception;
    private Routine finalRoutine;
    private RuntimeException runtimeException;

    public TryCatchWithoutResult(Routine routine) {
        this.routine = routine;
    }

    @Override
    public TryCatchWithoutResult onException(Routine function) {
        this.exception = function;
        return this;
    }

    @Override
    public TryCatchWithoutResult withFinally(Routine function) {
        this.finalRoutine = function;
        return this;
    }

    @Override
    public void run() {
        try {
            this.routine.run();
        } catch(Exception e) {
            if (runtimeException != null) {
                throw runtimeException;
            } else if (exception != null){
                exception.run();
            }
        }
        finally {
            if (finalRoutine != null) {
                finalRoutine.run();
            }
        }
    }
}
