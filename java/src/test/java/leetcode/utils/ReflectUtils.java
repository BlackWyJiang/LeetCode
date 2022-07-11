package utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射工具类
 */
public class ReflectUtils {

    /**
     * 执行 obj 的 methodName 方法,传入 parameters 参数
     *
     * @param obj
     * @param methodName
     * @param parameters
     * @param <T>
     * @return
     * @throws NoSuchMethodException
     */
    public static <T> T invokeMethod(Object obj, String methodName, Object... parameters) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Class<?>[] parameterTypes = null;
        if (parameters != null && parameters.length != 0) {
            parameterTypes = new Class<?>[parameters.length];
            for (int i = 0; i < parameters.length; i++) {
                parameterTypes[i] = parameters[i].getClass();
            }
        }
        Method method = obj.getClass().getDeclaredMethod(methodName, parameterTypes);
        method.setAccessible(true);

        Object invoke = method.invoke(obj, parameters);
        return (T) invoke;

    }

}