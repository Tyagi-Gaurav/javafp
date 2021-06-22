package com.gt.jfp.construct;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static com.gt.jfp.ExceptionHandlerFactory.TryCatchWithoutResult;
import static org.assertj.core.api.Assertions.assertThat;

class TryCatchWithoutResultTest {
    @Test
    public void shouldExecuteCodeInsideTryCatch() {
        //given
        AtomicInteger x = new AtomicInteger(5);

        //When
        TryCatchWithoutResult(() -> {
            x.set(x.get() + 1);
        }).run();

        //Then
        assertThat(x.get()).isEqualTo(6);
    }

    @Test
    public void shouldExecuteCodeInsideException() {
        //given
        AtomicInteger x = new AtomicInteger(5);

        //When
        TryCatchWithoutResult(() -> {
            x.set(x.get() + 1);
            throw new RuntimeException();
        }).onException(() -> x.set(x.get() + 1)).run();

        //Then
        assertThat(x.get()).isEqualTo(7);
    }

    @Test
    public void shouldExecuteCodeInsideFinallyBlock() {
        //given
        AtomicInteger x = new AtomicInteger(5);

        //When
        TryCatchWithoutResult(() -> {
            x.set(x.get() + 1);
            throw new RuntimeException();
        }).onException(() -> x.set(x.get() + 1))
                .withFinally(() -> x.set(x.get() + 1))
                .run();

        //Then
        assertThat(x.get()).isEqualTo(8);
    }

    @Test
    public void shouldExecuteCodeInsideFinallyWhenNoExceptionThrown() {
        //given
        AtomicInteger x = new AtomicInteger(5);

        //When
        TryCatchWithoutResult(() -> {
            x.set(x.get() + 1);
        }).onException(() -> x.set(x.get() + 1))
                .withFinally(() -> x.set(x.get() + 1))
                .run();

        //Then
        assertThat(x.get()).isEqualTo(7);
    }
}