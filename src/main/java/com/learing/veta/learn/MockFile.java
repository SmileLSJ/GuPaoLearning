package com.learing.veta.learn;

public class MockFile {
	private static String filecontent;

    public static String getFilecontent() {
        return filecontent;
    }
    public static void setFilecontent(String filecontent) {
        MockFile.filecontent = filecontent;
    }
}
