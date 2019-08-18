package JavaBasic9;

public class ReferenceAndDS {
	// String does not have setCharAt() funtion. StringBuild does have.
	public static void main(String[] args) {
		String str = "Hi", str2 = "bcd";
		func(str, str2);
		System.out.print(str + ", " + str2);
	}

	static void func(String str, String str2) {
		str += " hello";
		str2.setCharAt(0, 'a');
	}

}
