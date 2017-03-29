package pr01HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		Class<RichSoilLand> richSoilLandClass = RichSoilLand.class;

		String[] modifiers = new String[] { "", "public", "private", "", "protected" };

		String line = in.nextLine();
		while (!"HARVEST".equals(line)) {
			Field[] declaredFields = richSoilLandClass.getDeclaredFields();
			for (Field declaredField : declaredFields) {
				if (line.equals("public") && Modifier.isPublic(declaredField.getModifiers())) {
					System.out.println(String.format("%s %s %s", line, declaredField.getType().getSimpleName(), declaredField.getName()));
				} else if (line.equals("protected") && Modifier.isProtected(declaredField.getModifiers())) {
					System.out.println(String.format("%s %s %s", line, declaredField.getType().getSimpleName(), declaredField.getName()));
				} else if (line.equals("private") && Modifier.isPrivate(declaredField.getModifiers())) {
					System.out.println(String.format("%s %s %s", line, declaredField.getType().getSimpleName(), declaredField.getName()));
				} else if (line.equals("all")) {
					System.out.println(String.format("%s %s %s", modifiers[declaredField.getModifiers()], declaredField.getType().getSimpleName(), declaredField.getName()));
				}
			}


			line = in.nextLine();
		}

	}
}
