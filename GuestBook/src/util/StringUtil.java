package util;

public class StringUtil {

	/**
	 * �ж�������ַ��������Ƿ�Ϊ�ա�
	 * @param args ������ִ�
	 * @return true/false
	 */
	public static boolean validateNull(String args) {
		if (args == null || args.length() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * �ж�������ַ��������Ƿ�Ϊ�ջ�����"null"�ַ�,�����,�ͷ���target����,�������,�ͷ���source������
	 */
	public static String chanageNull(String source, String target) {
		if (source == null || source.length() == 0 || source.equalsIgnoreCase("null")) {
			return target;
		} else {
			return source;
		}
	}

	/**
	 * ����<, >,\n �ַ��ķ�����
	 * @param input ��Ҫ���˵��ַ�
	 * @return ��ɹ����Ժ���ַ���
	 */
	public static String filterHtml(String input) {
		if (input == null) {
			return null;
		}
		if (input.length() == 0) {
			return input;
		}
		input = input.replaceAll("&", "&amp;");
		input = input.replaceAll("<", "&lt;");
		input = input.replaceAll(">", "&gt;");
		input = input.replaceAll(" ", "&nbsp;");
		input = input.replaceAll("'", "&#39;");
		input = input.replaceAll("\"", "&quot;");
		return input.replaceAll("\n", "<br>");
	}
}
