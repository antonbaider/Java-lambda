package jom.com.softserve.s3.task2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import jom.com.softserve.s5.task2.App;

class Task2Test {

	final private static String APP = "jom.com.softserve.s5.task2.App";

	@DisplayName("Check that App class is present")
	@Test
	void isTypeClass() {
		try {
			Class<?> clazz = Class.forName(APP);
			assertTrue(clazz.getSimpleName().equals("App"));
		} catch (ClassNotFoundException e) {
			fail("There is no App class");
		}
	}

	@DisplayName("Check that App class has 'cons' field")
	@Test
	void isConsFieldTest() {
		try {
			Class<?> clazz = Class.forName(APP);
			Field field = clazz.getDeclaredField("cons");
			assertNotNull(field);
		} catch (ClassNotFoundException e) {
			fail("There is no App class");
		} catch (NoSuchFieldException e) {
			fail("There is no cons field");
		}
	}

	@DisplayName("Check that 'cons' field belongs Consumer type")
	@Test
	void isConsFieldConsumerTypeTest() {
		try {
			Class<?> clazz = Class.forName(APP);
			Field field = clazz.getDeclaredField("cons");
			assertTrue(field.getType().equals(Consumer.class));
		} catch (ClassNotFoundException e) {
			fail("There is no App class");
		} catch (NoSuchFieldException e) {
			fail("There is no 'cons' field");
		}
	}

	@DisplayName("Check parameters of 'getChanged' method")
	@Test
	void hasTypeDeclaredMethod() {
		boolean isGetChangedMethod = false;
		try {
			Class<?> clazz = Class.forName(APP);
			Method[] methods = clazz.getDeclaredMethods();
			for (Method method : methods) {
				if (method.getName().equals("getChanged")) {
					isGetChangedMethod = true;
					Class<?>[] types = method.getParameterTypes();
					assertTrue(Arrays.equals(types, new Class[] { double[].class, Consumer.class }));
				}
			}
		} catch (ClassNotFoundException e) {
			fail("There is no App class");
		}
		assertTrue(isGetChangedMethod, "There is no such method");
	}

	@DisplayName("Check that 'getChanged' method returns double[]")
	@Test
	void hasMethodReturnType() {
		boolean isGetChangedMethod = false;
		try {
			Class<?> clazz = Class.forName(APP);
			Method[] methods = clazz.getDeclaredMethods();
			for (Method method : methods) {
				if (method.getName().equals("getChanged")) {
					isGetChangedMethod = true;
					assertEquals(method.getReturnType(), double[].class);
				}
			}
		} catch (ClassNotFoundException e) {
			fail("There is no App class");
		}
		assertTrue(isGetChangedMethod, "There is no such method");
	}

	@DisplayName("Check that 'getChanged' metod returns an approprite value")
	@ParameterizedTest
	@MethodSource("provideDataForGetChangedMethod")
	void isResultCorrect(double[] expected, double[] actual) {
		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], actual[i], 0.00001);
		}
	}

	private static Stream<Arguments> provideDataForGetChangedMethod() {
		return Stream.of(
				Arguments.of(new double[] { 0.9, 1.8, 2.4, -0.9, -4.5, 0 },
						App.getChanged(new double[] { 1, 2, 3, -1, -5, 0 }, App.cons)),
				Arguments.of(new double[] { 0.9, 1.616, 2.4, -0.9, -4.5, 0, 5.6, 6.4, 20.704 },
						App.getChanged(new double[] { 1, 2.02, 3, -1, -5, 0, 7, 8, 25.88 }, App.cons)));
	}

	@DisplayName("Check that an initial array was changed")
	@Test
	void isInitialArrayChanged() {
		double[] arr = new double[] { 1, 2, 3, 5.01, 8.3, 9.06 };
		assertFalse(arr.equals(App.getChanged(arr, App.cons)));
	}

	@DisplayName("Check that Consumer was used")
	@Test
	void isConsumerUsed() {
		double[] arr = new double[] { 1, 2, 3, 5.01, 8.3, 9.06 };
		assertFalse(arr.equals(App.getChanged(arr, App.cons)));
	}

}
