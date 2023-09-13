package com.omar.omar.Helpers;

import java.util.function.Consumer;

public class ClientUtil {

    public static <T> void updateFieldIfNotNull(T newValue, Consumer<T> updater) {
        if (newValue != null) {
            updater.accept(newValue);
        }
    }
}
