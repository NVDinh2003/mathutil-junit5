package com.chappie.mathutil.core;

import static com.chappie.mathutil.core.MathUtil.getFactorial;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class MathUtilTest {

	@Test
	public void testGetFactorialGivenRightArgReturnWell1() {
		assertEquals(120, getFactorial(5));
	}

	@Test
	public void testGetFactorialGinvenWrongArgThrowException() {
//		xàib biểu thức lamdba, hàm nhận tham số thứ 2 là 1 object có impliment cái functional interface tên là Executable
//		- có 1 hàm duy nhất khôgn có code tên là excute() 

//		Executable excObject = new Executable() {
//			@Override
//			public void execute() throws Throwable {
//				getFactorial(-5);
//			}
//		};

//		Executable excObject = () -> {
//			getFactorial(-5);
//		};

		assertThrows(IllegalArgumentException.class, () -> getFactorial(-5));
	}

//	=====================================================================================================

//							DÙNG DDT - Data Driven Testing

//	-Chơi DDT, tách data ra khỏi lệnh kiểm thử, tham số hóa data này vào trong câu lệnh kiểm thử

//	Tạo mảng 2 chiều gồm cặp Exceptive | Input
	public static Object[][] initData() {
		return new Integer[][] { { 0, 1 }, { 1, 1 }, { 2, 2 }, { 3, 6 }, { 4, 24 }, { 5, 120 } };
	}

	@ParameterizedTest // biến hàm này thành hàm chạy tham số hóa
	@MethodSource(value = "initData") // chính là tên hàm innitData trên - cung cấp data , ngầm định luôn thứ tự của các phần tử mảng và map vào tham số hàm
	public void testGetFactorialGivenRightArgReturnWell(int input, long excepted) {
		assertEquals(excepted, getFactorial(input));
	}

}
