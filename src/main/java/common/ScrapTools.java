package common;

public class ScrapTools {

	public static String getPropertyValue(String data, String propertyName, String separator) {
		int index = data.indexOf(propertyName);
		int indexSeparator = data.indexOf(separator, (index+propertyName.length()));
		return data.substring(index + propertyName.length(), indexSeparator);
	}
	
	public static String getPropertyValue(String data, String propertyName, String separator, boolean addQuotationMarks, boolean addColon) {
		if (addQuotationMarks)
			propertyName = "\"" + propertyName + "\"";
		if (addColon)
			propertyName += ":";
		return getPropertyValue(data, propertyName, separator);
	}
}
