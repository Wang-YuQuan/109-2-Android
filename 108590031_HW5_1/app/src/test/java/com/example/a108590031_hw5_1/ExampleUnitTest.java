package com.example.a108590031_hw5_1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(JUnit4.class)
public class ExampleUnitTest {
    private Calculator c;

    @Before
    public void setUp() {
        c = new Calculator();
    }

    @Test
    public void add_isCorrect() {
        double resultAdd = c.Add(1d, 1d);
        assertThat(resultAdd, is(equalTo(2d)));
    }

    @Test
    public void sub_isCorrect() {
        double resultSub = c.Sub(1d, 1d);
        assertThat(resultSub, is(equalTo(0d)));
    }

    @Test
    public void mul_isCorrect() {
        double resultMul = c.Mul(3d, 2d);
        assertThat(resultMul, is(equalTo(6d)));
    }

    @Test
    public void div_isCorrect() {
        double resultDiv = c.Div(10d, 5d);
        assertThat(resultDiv, is(equalTo(2d)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void divByZeroThrows() {
        c.Div(32d,0d);
    }

    @Test
    public void pow_isCorrect() {
        double resultPow = c.Pow(2d, 6d);
        assertThat(resultPow, is(equalTo(64d)));
    }

    @Test
    public void pow_isCorrect_negative() {
        double resultPow = c.Pow(-2d, 3d);
        assertThat(resultPow, is(equalTo(-8d)));
    }
}