package com.pradeip.json;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



/**
 * Merge Two Maps
 * @author pradeep_patel
 *
 */
public class JsonParser2 {

	static final String PATH = "path";
	static String PATH_VALUE = "path";
	static final String STATEMENTMAP = "statementMap";
	static final String S = "s";
	static final String FNMAP = "fnMap";
	static final String F = "f";
	static final String BRANCH_MAP = "branchMap";
	static final String B = "b";
	static String R1, R2, R3;
	static Set<String> rootKeys;

	static Map<String, Object> smpMap = new HashMap<String, Object>();
	static Map<String, Object> sMap = new HashMap<String, Object>();
	static Map<String, Object> fnmMap = new HashMap<String, Object>();
	static Map<String, Object> fMap = new HashMap<String, Object>();
	static Map<String, Object> brnMap = new HashMap<String, Object>();
	static Map<String, Object> bMap = new HashMap<String, Object>();
	static Map<String, String> pathMap = new HashMap<String, String>();

	static Map<String, Object> finalMap = new HashMap<String, Object>();
	static Map<String, Object> innerMap = new HashMap<String, Object>();

	public static void main(String[] args) throws JsonParseException,
			JsonMappingException, IOException {
		String file01 = "d:\\temp\\" + "map1.json";
		String file02 = "d:\\temp\\" + "map2.json";
		String file03 = "d:\\temp\\" + "final.json";
		String[] pathList = { file01, file02 };
		List<Map<String, Object>> list = ReadFile.readJSON(Arrays
				.asList(pathList));
		ReadFiless.mergeMultipleMaps(list);
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File(file03), finalMap);
		System.out.println(finalMap);

	}
}

/**
 * 
 * @author pradeep_patel
 * Read Files form File Location and convert it into Map Object
 */
class ReadFiless extends JsonParser {

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



	@SuppressWarnings("unchecked")
	static void mergeMultipleMaps(List<Map<String, Object>> list) {
		Map<String, Object> temp = null;
		Map<Integer, Set<String>> mapOfMaps = new HashMap<Integer, Set<String>>();

		rootKeys = new HashSet<String>();

		for (Map<String, Object> mapone : list) {
			for (String key : mapone.keySet()) {
				rootKeys.add(key);
			}
		}

		System.out.println("Keys :" + rootKeys);
		for (String key : rootKeys) {
			Map<String, Object> tempMap = new HashMap<String, Object>();
			for (Map<String, Object> mapone : list) {
				tempMap = (Map<String, Object>) mapone.get(key);

				smpMap.putAll((Map<? extends String, ? extends Object>) tempMap
						.get(S));
				sMap.putAll((Map<? extends String, ? extends Object>) tempMap
						.get(F));
				fnmMap.putAll((Map<? extends String, ? extends Object>) tempMap
						.get(FNMAP));
				fMap.putAll((Map<? extends String, ? extends Object>) tempMap
						.get(STATEMENTMAP));
				brnMap.putAll((Map<? extends String, ? extends Object>) tempMap
						.get(BRANCH_MAP));
				bMap.putAll((Map<? extends String, ? extends Object>) tempMap
						.get(B));
				PATH_VALUE = (String) tempMap.get(PATH);

				System.out.println(tempMap.get(PATH));
				System.out.println(pathMap);

			}
			innerMap.put(S, smpMap);
			innerMap.put(F, smpMap);
			innerMap.put(FNMAP, smpMap);
			innerMap.put(STATEMENTMAP, smpMap);
			innerMap.put(BRANCH_MAP, smpMap);
			innerMap.put(PATH, PATH_VALUE);
			innerMap.put(B, bMap);
			finalMap.put(key, innerMap);
		}

	}

}
