package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import controls.Environment;
import debug.Debugger;

public class EnvironementTest {

	public static void myTest() {
		assertEquals("\\", Environment.getFileSep());
	}

	@Test
	public void test() {
		String out = "This is: " + this.getClass();
		Debugger.out(out);
		for (int i = 0; i < out.length(); i++)
			Debugger.out();
		Debugger.out(Environment.getEndOfLine());
		Debugger.out("Working paths:");
		Debugger.out("- class  path:" + Environment.getClassPath());
		Debugger.out("- actual path:" + Environment.getActualPath());
		Debugger.out("- home   path:" + Environment.getHomePath());
		myTest();
	}

}
