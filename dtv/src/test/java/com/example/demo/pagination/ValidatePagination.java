package com.example.demo.pagination;

import static java.lang.Math.min;
import static java.util.stream.Collectors.toMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

public class ValidatePagination {

	@Test
	public void test() {
		List<String> estados =  new ArrayList<>();
		estados.add("RS");
		estados.add("SP");
		estados.add("SC");
		estados.add("PR");
		estados.add("RJ");
		
		
		Map<Integer, List<String>> pages = partition(estados, 3);
		pages.entrySet().stream()
		.forEach(p -> {
			System.out.println(p.getValue());
		});
		
		
		List<String> page = pages.entrySet().stream().flatMap(p -> p.getValue().stream()).collect(Collectors.toList());
		System.out.println(page.size());
               
		
		
	}

	static Map<Integer, List<String>> partition(List<String> list, int pageSize) {
	    return IntStream.iterate(0, i -> i + pageSize)
	          .limit((list.size() + pageSize - 1) / pageSize)
	          .boxed()
	          .collect(toMap(i -> i / pageSize,
	                         i -> list.subList(i, min(i + pageSize, list.size()))));
	}
}
