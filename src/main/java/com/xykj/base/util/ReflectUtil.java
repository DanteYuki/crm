package com.xykj.base.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

public class ReflectUtil {
    public ReflectUtil() {
    }

    public static Object getFieldValue(Object obj, String fieldName) {
        Object result = null;
        Field field = getField(obj, fieldName);
        if(field != null) {
            field.setAccessible(true);

            try {
                result = field.get(obj);
            } catch (IllegalArgumentException var5) {
                var5.printStackTrace();
            } catch (IllegalAccessException var6) {
                var6.printStackTrace();
            }
        }

        return result;
    }

    private static Field getField(Object obj, String fieldName) {
        Field field = null;
        Class clazz = obj.getClass();

        while(clazz != Object.class) {
            try {
                field = clazz.getDeclaredField(fieldName);
                break;
            } catch (NoSuchFieldException var5) {
                clazz = clazz.getSuperclass();
            }
        }

        return field;
    }

    public static void setFieldValue(Object obj, String fieldName, String fieldValue) {
        Field field = getField(obj, fieldName);
        if(field != null) {
            try {
                field.setAccessible(true);
                field.set(obj, fieldValue);
            } catch (IllegalArgumentException var5) {
                var5.printStackTrace();
            } catch (IllegalAccessException var6) {
                var6.printStackTrace();
            }
        }

    }

    public static void copyPorperties(Object dest, Object source) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class srcCla = source.getClass();
        Field[] fsF = srcCla.getDeclaredFields();
        Field[] var4 = fsF;
        int var5 = fsF.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            Field s = var4[var6];
            String name = s.getName();
            Object srcObj = invokeGetterMethod(source, name);

            try {
                BeanUtils.setProperty(dest, name, srcObj);
            } catch (Exception var11) {
                var11.printStackTrace();
            }
        }

    }

    public static Object invokeGetterMethod(Object target, String propertyName) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String getterMethodName = "get" + StringUtils.capitalize(propertyName);
        return invokeMethod(target, getterMethodName, new Class[0], new Object[0]);
    }

    public static Object invokeMethod(Object object, String methodName, Class<?>[] parameterTypes, Object[] parameters) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = getDeclaredMethod(object, methodName, parameterTypes);
        if(method == null) {
            throw new IllegalArgumentException("Could not find method [" + methodName + "] parameterType " + parameterTypes + " on target [" + object + "]");
        } else {
            method.setAccessible(true);
            return method.invoke(object, parameters);
        }
    }

    protected static Method getDeclaredMethod(Object object, String methodName, Class<?>[] parameterTypes) {
        Assert.notNull(object, "object不能为空");
        Class superClass = object.getClass();

        while(superClass != Object.class) {
            try {
                return superClass.getDeclaredMethod(methodName, parameterTypes);
            } catch (NoSuchMethodException var5) {
                superClass = superClass.getSuperclass();
            }
        }

        return null;
    }
}
