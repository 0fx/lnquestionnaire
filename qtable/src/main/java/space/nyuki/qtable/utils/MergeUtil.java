package space.nyuki.qtable.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

/**
 * @author ning
 * @createTime 2019/9/4 下午5:13
 * @description
 */
public class MergeUtil {
    /**
     * @param t1  origin
     * @param t2  add
     * @param <T>
     * @return merged object
     */
    public static <T> T merge(T t1, T t2) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> t = t1.getClass();
        Field[] fields = t.getFields();
        for (Field field : fields) {
            String name = field.getName();
            String get = getFormat(name);
            String set = setFormat(name);
            Object element = t.getDeclaredMethod(get).invoke(t2);
            if (!Objects.isNull(element)) {
                Class<?> type = field.getType();
                t.getDeclaredMethod(set, type).invoke(t1, element);
            }
        }
        return t1;
    }

    private static String getFormat(String string) {
        String big = string.substring(0, 1).toUpperCase();
        return "get" + big + string.substring(1);
    }

    private static String setFormat(String string) {
        String big = string.substring(0, 1).toUpperCase();
        return "set" + big + string.substring(1);
    }
}