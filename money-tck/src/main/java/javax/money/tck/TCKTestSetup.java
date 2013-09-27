package javax.money.tck;

import java.lang.reflect.AccessibleObject;
import java.util.Arrays;
import java.util.Collection;

import javax.money.IntegralMoney;
import javax.money.MonetaryAmount;
import javax.money.Money;
import javax.money.MoneyCurrency;

public final class TCKTestSetup {

	private static JSRTestSetup TEST_SETUP = new JSRTestSetup();

	private TCKTestSetup() {
	}

	public static JSR354TestConfiguration getTestConfiguration() {
		// TODO load dynamicylly
		return TEST_SETUP;
	}

	private static final class JSRTestSetup implements JSR354TestConfiguration {

		@Override
		public Collection<Class> getAmountClasses() {
			return Arrays
					.asList(new Class[] { Money.class, IntegralMoney.class });
		}

		@Override
		public Collection<Class> getCurrencyClasses() {
			return Arrays.asList(new Class[] { MoneyCurrency.class });
		}

		@Override
		public Collection<Class> getAdjusters() {
			return Arrays
					.asList(new Class[] {});
		}

		@Override
		public Collection<Class> getQueries() {
			return Arrays
					.asList(new Class[] {});
		}

		@Override
		public AccessibleObject getConstructionMethod(Class type,
				Class... paramTypes) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <T> T create(Class<T> type, Object... params) {
			if (MoneyCurrency.class.equals(type)) {
				return (T) MoneyCurrency.of((String) params[0]);
			}
			if (Money.class.equals(type)) {
				return (T) Money.of((String) params[0], (Number) params[1]);
			}
			if (IntegralMoney.class.equals(type)) {
				return (T) IntegralMoney.of((String) params[0], (Number) params[1]);
			}
			return null;
		}
	}

}