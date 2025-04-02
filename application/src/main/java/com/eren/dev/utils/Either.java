package com.eren.dev.utils;

public class Either<L, R> {
    private final L left;
    private final R right;
    private final boolean isRight;

    private Either(L left, R right, boolean isRight) {
        this.left = left;
        this.right = right;
        this.isRight = isRight;
    }

    public static <L, R> Either<L, R> left(L value) {
        return new Either<>(value, null, false);
    }

    public static <L, R> Either<L, R> right(R value) {
        return new Either<>(null, value, true);
    }

    public boolean isRight() {
        return isRight;
    }

    public boolean isLeft() {
        return !isRight;
    }

    public L getLeft() {
        return left;
    }

    public R getRight() {
        return right;
    }
}
