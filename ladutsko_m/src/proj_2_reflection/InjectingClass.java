package proj_2_reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

final class InjectingClass {
    private InjectingClass(){}
    public static AnotherClass init() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Field[] declaredFields = AnotherClass.class.getDeclaredFields();
        Constructor constructorA = AnotherClass.class.getDeclaredConstructor();
        constructorA.setAccessible(true);
        AnotherClass anotherClass = (AnotherClass) constructorA.newInstance();
        Constructor constructorS = SomeClass.class.getDeclaredConstructor(String.class);
        constructorS.setAccessible(true);
        String value = null;
        for (Field declaredField : declaredFields) {
            if (declaredField.getAnnotations() != null ) {
                for (Annotation annotation : declaredField.getAnnotations()) {
                    if (annotation instanceof Inj) {
                        value = ((Inj) annotation).value();

                        declaredField.setAccessible(true);

                        declaredField.set(anotherClass, constructorS.newInstance(value));

                        declaredField.setAccessible(false);
                    }
                }
            }
        }
        constructorA.setAccessible(false);
        constructorS.setAccessible(false);
        return anotherClass;
    }
}
