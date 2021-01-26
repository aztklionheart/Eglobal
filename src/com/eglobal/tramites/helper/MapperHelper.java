package com.eglobal.tramites.helper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

public class MapperHelper {
	
	static ModelMapper modelMapper = new ModelMapper();
	
	public static <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
	    return source
	      .stream()
	      .map(element -> modelMapper.map(element, targetClass))
	      .collect(Collectors.toList());
	}

}

