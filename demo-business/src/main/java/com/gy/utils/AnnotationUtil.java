package com.gy.utils;

import com.gy.annotation.TestAnnotation;
import com.gy.vo.UserVO;

import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *
 */
public class AnnotationUtil {

    public static void main(String[] args) {
        UserVO vo = new UserVO();
        Class<?> class1 = vo.getClass();
        Field[] fields = class1.getDeclaredFields();
        for(Field field : fields){
            try{
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(),class1);
                Method getMethod = propertyDescriptor.getReadMethod();
                Method setMethod = propertyDescriptor.getWriteMethod();
                Object setObj = setMethod.invoke(vo,"guyu");
                Object getObj = getMethod.invoke(vo);
                System.out.println(setObj);
                System.out.println(getObj);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        try{
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fields[2].getName(),class1);
            Method method1 = propertyDescriptor.getReadMethod();
            System.out.println(method1);
        }catch (Exception e){
            e.printStackTrace();
        }
        annotationTest(vo);
    }

    private static void annotationTest(Object obj){
        Class<?> clazz = obj.getClass();
        if(clazz.isAnnotationPresent(TestAnnotation.class)){
            Annotation[] annotations = clazz.getAnnotations();
            TestAnnotation annotation = clazz.getAnnotation(TestAnnotation.class);
            String name = annotation.name();
            System.out.println(name);
        }
    }
}
