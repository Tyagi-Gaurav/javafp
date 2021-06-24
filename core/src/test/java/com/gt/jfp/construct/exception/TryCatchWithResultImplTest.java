package com.gt.jfp.construct.exception;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class TryCatchWithResultImplTest {
    @Test
    void shouldExecuteCodeInsideTryCatch() {
        //When
        Integer result = new TryCatchWithResultImpl<>(() -> 7).run();

        //Then
        assertThat(result).isEqualTo(7);
    }

    @Test
    void shouldBeAbleToReturnCodeFromException() {
        //When
        Integer result = new TryCatchWithResultImpl<>(() -> {
            int i = 2;
            while (i > 0) i--;

            if (i == 0) {
                throw new RuntimeException();
            } else {
                return 7;
            }
        })
                .onExceptionReturn(() -> 8)
                .run();

        //Then
        assertThat(result).isEqualTo(8);
    }

    @Test
    void shouldBeAbleToRethrowException() {
        //When
        TryCatchWithResultImpl<Integer> integerTryCatchWithResult = new TryCatchWithResultImpl<>(() -> {
            int i = 2;
            while (i > 0) i--;

            if (i == 0) {
                throw new RuntimeException();
            } else {
                return 7;
            }
        })
                .onException(e -> {
                    throw new RuntimeException(e);
                });

        Throwable throwable = catchThrowable(() -> integerTryCatchWithResult.run());

        //Then
        assertThat(throwable).isInstanceOf(RuntimeException.class);
    }

    @Test
    void shouldExecuteCodeInsideFinallyBlock() {
        //given
        AtomicInteger x = new AtomicInteger(5);

        //When
        Integer result = new TryCatchWithResultImpl<>(() -> 7)
                .onExceptionReturn(() -> 8)
                .withFinally(() -> {
                    x.set(x.get() + 1);
                    return null;
                })
                .run();

        //Then
        assertThat(result).isEqualTo(7);
    }
}