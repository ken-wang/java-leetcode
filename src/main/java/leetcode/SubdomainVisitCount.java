package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SubdomainVisitCount {

    public List<String> subdomainVisits(String[] cpdomains) {
        
    	final Map<String, Integer> map = new HashMap<>();
    	for(String cpdomain : cpdomains) {
    		String[] array = cpdomain.split(" ");
    		int time = Integer.parseInt(array[0]);
    		calculate(map, array[1], time);
    	}
    	
    	return map.entrySet().stream().map(entry -> {
    		return entry.getValue().toString() + " " + entry.getKey();
    	}).collect(Collectors.toList());
    	
    }
    
    private void calculate(final Map<String, Integer> map, String domain, int time) {
    	int value = time;
    	if (map.containsKey(domain)) {
    		value += map.get(domain);
    	} 
    	map.put(domain, value);
    	
    	if (domain.contains(".")) {
    		String nextDomain = domain.substring(domain.indexOf(".")+1);
    		calculate(map, nextDomain, time);
    	}
    }
	
}
