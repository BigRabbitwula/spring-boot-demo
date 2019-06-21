package com.gy.utils;

import com.gy.annotation.TestAnnotation;
import com.gy.vo.UserVO;

import java.lang.annotation.Annotation;

public class AnnotationUtil {

    public static void main(String[] args) {
        UserVO vo = new UserVO();
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
