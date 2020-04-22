package com.leisurelife.util;


public class ConvertToJSON {
	public String ConvertToJSON(String result){
		String[] a=result.split("\\[");
		String jsonResult=a[0].replace(", ", "\",\"").replace("=", "\":\"").replace("{", "{\"").concat("[").replace("\"[", "[").concat(a[1]);
		return jsonResult;
	}
}
