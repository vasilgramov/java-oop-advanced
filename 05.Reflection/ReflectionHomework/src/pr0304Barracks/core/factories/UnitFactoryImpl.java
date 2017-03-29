package pr0304Barracks.core.factories;

import pr0304Barracks.contracts.Unit;
import pr0304Barracks.contracts.UnitFactory;
import pr0304Barracks.models.units.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"pr0304Barracks.models.units.";

	@Override
	public Unit createUnit(String unitType) {
		Unit unit = null;

		if (unitType.equals("Swordsman")) {
			unit = new Swordsman();
		} else if (unitType.equals("Archer")) {
			unit = new Archer();
		} else if (unitType.equals("Pikeman")) {
			unit = new Pikeman();
		} else if (unitType.equals("Gunner")) {
			unit = new Gunner();
		} else if (unitType.equals("Horseman")) {
			unit = new Horseman();
		}

		return unit;
	}
}
