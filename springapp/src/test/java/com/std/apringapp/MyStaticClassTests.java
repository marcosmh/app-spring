package com.std.apringapp;

import com.std.springapp.librerias.mockitoinline.MyStaticClass;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyStaticClassTests {
	@Test
	public void contextLoads() {
		assertEquals("Welcome Alan", MyStaticClass.helloWorld("Alan"));
		try (MockedStatic<MyStaticClass> theMock = Mockito.mockStatic(MyStaticClass.class)) {
			theMock.when(() -> MyStaticClass.helloWorld("Alan"))
					.thenReturn("Welcome Alan");

			assertEquals("Welcome Alan", MyStaticClass.helloWorld("Alan"));
		}

		assertEquals("Welcome John", MyStaticClass.helloWorld("John"));
	}

	@Test
	public void otherFunctionTests() {
		assertEquals(20, MyStaticClass.otherFunction());
		try (MockedStatic<MyStaticClass> theMock = Mockito.mockStatic(MyStaticClass.class)) {
			theMock.when(MyStaticClass::otherFunction)
					.thenReturn(20);

			assertEquals(20, MyStaticClass.otherFunction());
		}

		assertEquals(20, MyStaticClass.otherFunction());
	}

}
