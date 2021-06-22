package com.gt.jfp.construct.exception;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class TryCatchWithResultImpl<T> implements TryCatchWithResult<T> {
    private final Supplier<T> supplier;
    private Consumer<Throwable> exceptionSupplier;
    private Supplier<Void> finallySupplier;
    private Supplier<T> exceptionReturnSupplier;

    public TryCatchWithResultImpl(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    @Override
    public TryCatchWithResultImpl<T> onException(Consumer<Throwable> exceptionSupplier) {
        this.exceptionSupplier = exceptionSupplier;
        return this;
    }

    @Override
    public TryCatchWithResult<T> onExceptionReturn(Supplier<T> exceptionReturnSupplier) {
        this.exceptionReturnSupplier = exceptionReturnSupplier;
        return this;
    }

    @Override
    public TryCatchWithResultImpl<T> withFinally(Supplier<Void> finallySupplier) {
        this.finallySupplier = finallySupplier;
        return this;
    }

    public T run() {
        try {
            return supplier.get();
        } catch(Exception e) {
            if (exceptionSupplier != null){
                exceptionSupplier.accept(e);
            } else {
                return exceptionReturnSupplier.get();
            }
        }
        finally {
            if (finallySupplier != null) {
                finallySupplier.get();
            }
        }
        return null;
    }
}
