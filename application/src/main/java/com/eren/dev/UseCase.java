package com.eren.dev;

public abstract class UseCase<IN, OUT> {
    public abstract OUT execute(IN anIn);
}
