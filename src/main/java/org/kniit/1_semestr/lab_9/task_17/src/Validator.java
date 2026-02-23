import java.lang.reflect.Field;

public class Validator {
    public static void validate(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {

            field.setAccessible(true);
            Object value = field.get(obj);

            if (field.isAnnotationPresent(NotNull.class) && value == null) {
                System.out.println("Поле " + field.getName() + " не должно быть null.");
            }

            
            if (field.isAnnotationPresent(MaxLength.class)) {
                int max = field.getAnnotation(MaxLength.class).value();
                if (value != null && value instanceof String) {
                    String str = (String) value;
                    if (str.length() > max) {
                        System.out.println("Поле " + field.getName() +
                                " превышает максимальную длину " + max + ".");
                    }
                }
            }

            if (field.isAnnotationPresent(Min.class)) {
                int min = field.getAnnotation(Min.class).value();

                if (value instanceof Integer) {
                    int number = (Integer) value;
                    if (number < min) {
                        System.out.println("Поле " + field.getName() +
                                " должно быть не меньше " + min + ".");
                    }
                }
            }
        }
    }
}
