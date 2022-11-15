package com.example.rest;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Responser {

	private String result;
	private Object data;
	
}
