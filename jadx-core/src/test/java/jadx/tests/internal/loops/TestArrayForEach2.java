package jadx.tests.internal.loops;

import jadx.api.InternalJadxTest;
import jadx.core.dex.nodes.ClassNode;

import org.junit.Test;

import static jadx.tests.utils.JadxMatchers.containsLines;
import static org.junit.Assert.assertThat;

public class TestArrayForEach2 extends InternalJadxTest {

	public static class TestCls {
		private void test(String str) {
			for (String s : str.split("\n")) {
				String t = s.trim();
				if (t.length() > 0) {
					System.out.println(t);
				}
			}
		}
	}

	@Test
	public void test() {
		ClassNode cls = getClassNode(TestCls.class);
		String code = cls.getCode().toString();
		System.out.println(code);

		assertThat(code, containsLines(2,
				"for (String s : str.split(\"\\n\")) {",
				indent(1) + "String t = s.trim();",
				indent(1) + "if (t.length() > 0) {",
				indent(2) + "System.out.println(t);",
				indent(1) + "}",
				"}"
		));
	}
}