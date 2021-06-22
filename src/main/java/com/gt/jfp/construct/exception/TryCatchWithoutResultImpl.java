package com.gt.jfp.construct.exception;

import java.util.function.Consumer;

public class TryCatchWithoutResultImpl implements TryCatchWithoutResult {
    private final Runnable routine;
    private Consumer<Exception> exception;
    private Runnable finalRoutine;

    public TryCatchWithoutResultImpl(Runnable routine) {
        this.routine = routine;
    }

    @Override
    public TryCatchWithoutResultImpl onException(Consumer<Exception> exceptionConsumer) {
        this.exception = exceptionConsumer;
        return this;
    }

    @Override
    public TryCatchWithoutResultImpl withFinally(Runnable function) {
        this.finalRoutine = function;
        return this;
    }

    @Override
    public void run() {
        try {
            this.routine.run();
        } catch(Exception e) {
            if (exception != null){
                exception.accept(e);
            }
        }
        finally {
            if (finalRoutine != null) {
                finalRoutine.run();
            }
        }
    }
}
