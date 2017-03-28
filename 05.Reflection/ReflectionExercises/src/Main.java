import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class reflectionClass = Reflection.class;

        Field[] fields = reflectionClass.getDeclaredFields();
        Arrays.sort(fields, Comparator.comparing(Field::getName));
        for (Field field : fields) {
            if (!Modifier.isPrivate(field.getModifiers())) {
                System.out.println(field.getName() + " must be private!");
            }
        }

        Method[] declaredMethods = reflectionClass.getDeclaredMethods();
        List<Method> collect = Arrays.stream(declaredMethods).sorted(Comparator.comparing(Method::getName)).collect(Collectors.toList());

        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.getName().startsWith("get")) {
                if (!Modifier.isPublic(declaredMethod.getModifiers())) {
                    System.out.println(declaredMethod.getName() + " have to be public!");
                }
            } else if (declaredMethod.getName().startsWith("set")) {
                if (!Modifier.isPrivate(declaredMethod.getModifiers())) {
                    System.out.println(declaredMethod.getName() + " have to be private!");
                }
            }
        }


    }
}