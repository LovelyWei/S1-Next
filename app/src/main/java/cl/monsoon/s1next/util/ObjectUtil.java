package cl.monsoon.s1next.util;

public final class ObjectUtil {

    @SuppressWarnings("unchecked")
    public static <T> T uncheckedCast(Object obj) {
        return (T) obj;
    }
}