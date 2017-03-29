package pr02PrivateClassFiddling;

import pr02PrivateClassFiddling.com.peshoslav.BlackBoxInt;

import java.lang.reflect.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchFieldException {
		Scanner in = new Scanner(System.in);

		Class<BlackBoxInt> blackBoxIntClass = BlackBoxInt.class;
		Constructor<?>[] declaredConstructors = blackBoxIntClass.getDeclaredConstructors();

		BlackBoxInt blackBoxInt = null;
		for (Constructor<?> declaredConstructor : declaredConstructors) {
			declaredConstructor.setAccessible(true);
			Parameter[] parameters = declaredConstructor.getParameters();
			Object[] parametersAsObjects = new Object[parameters.length];
			for (int i = 0; i < parameters.length; i++) {
				if (parameters[i].getType().getSimpleName().equals("String")) {
					parametersAsObjects[i] = "";
				} else if (parameters[i].getType().getSimpleName().equals("int")) {
					parametersAsObjects[i] = 0;
				} else if (parameters[i].getType().getSimpleName().equals("double")) {
					parametersAsObjects[i] = 0.0;
				}
			}

			blackBoxInt = (BlackBoxInt) declaredConstructor.newInstance(parametersAsObjects);
		}

		Method[] declaredMethods = blackBoxIntClass.getDeclaredMethods();

		String command = in.nextLine();
		while (!"END".equals(command)) {
			String[] commandArgs = command.split("_");
			String commandType = commandArgs[0];
			int value = Integer.parseInt(commandArgs[1]);

			for (Method declaredMethod : declaredMethods) {
				if (declaredMethod.getName().equals(commandType)) {
					declaredMethod.setAccessible(true);
					declaredMethod.invoke(blackBoxInt, value);
					break;
				}
			}

			Field innerValue = blackBoxIntClass.getDeclaredField("innerValue");
			innerValue.setAccessible(true);

			Object innerValueValue = innerValue.get(blackBoxInt);
			System.out.println(innerValueValue);

			command = in.nextLine();
		}
	}
}
