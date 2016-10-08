package by.it.sukora.jd01_11.HomeWork.inout;

public class Parser {
	public static final String patternFloat = "^[-]?[0-9]*[.]?[0-9]*$";
	public static final String splitterVector = ",";
	public static final String splitterMatrix = "[\\]}]{1}[,]{1}[{\\[]{1}";
	public static final String[] supportedOperations = {"\\+", "\\*", "/", "\\-"};

	public static String[] parseCommand(String s) {
		String[] result = new String[3];
		for (int i=0; i<supportedOperations.length; i++) {
			String[] parts = s.split(supportedOperations[i]);
			if (parts.length == 2) {
				result[0] = parts[0];
				result[1] = parts[1];
				result[2] = supportedOperations[i];
				break;
			} else if (parts.length > 2) {
				result[0] = "-" + parts[1]; // here parts[0] is ""
				result[1] = parts[2];
				result[2] = supportedOperations[i];
				break;
			}
		}
		return result;
	}
}
