package com.pradeip.json;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParserExample {

	public static void main(String[] args) throws JsonParseException,
			JsonMappingException, IOException {
		String file01 = "d:\\temp\\" + "map1.json";
		String file02 = "d:\\temp\\" + "map2.json";
		String[] pathList = { file01, file02 };
		List<Map<String, Object>> list = ReadFile.readJSON(Arrays
				.asList(pathList));
		List<List<String>> nestedKeys = new ArrayList<List<String>>();
		ReadFile.printAllKeys(list,nestedKeys);
		
		System.out.println(nestedKeys.toString());
		//ReadFile.mergeMaps(list);

	}
}

class ReadFile {

	static List<Map<String, Object>> readJSON(List<String> pathList) {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map;
		List<Map<String, Object>> jsonFileList = new ArrayList<Map<String, Object>>();

		for (String path : pathList) {
			try {
				map = mapper.readValue(new File(path),
						new TypeReference<Map<String, Object>>() {
						});

				jsonFileList.add(map);
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return jsonFileList;
	}

	static void printAllKeys(List<Map<String, Object>> listOfJsonFiles,List<List<String>> list) {
		int i = 0;
		for (Map<String, Object> json : listOfJsonFiles) {
			System.out.println(i
					+ " Map :----------------------------------------->");
			printKeys(json,list);
		}
	}

	static Map mergeMaps(List<Map<String, Object>> listOfJsonFiles) {
		System.out.println("Inside merge maps");
		for (Map<String, Object> json : listOfJsonFiles) {
			Set<String> keys = json.keySet();
			for (String string : keys) {
				System.out.println("Printing Key :" + string);
				json.get(string);
				if (json.get(string) instanceof Map) {
				} else {
				}
			}
		}
		return null;
	}

	static void printKeys(Object value,List<List<String>> list) {

		List<String> innerList = new ArrayList<String>();
		if (value instanceof Map) {
			Set<String> keys = ((Map<String, Object>) value).keySet();

			for (String string : keys) {
				System.out.println("Printing Key :" + string);
				innerList.add(string);
				printKeys(((Map<String, Object>) value).get(string),list);
			}
			list.add(innerList);
		} else {
			
			//System.out.println("Printing Values :" + value);
		}
	}
}
