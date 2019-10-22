package com.dianyzethelli.mongodbspringboot.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {

	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	// Método para decodificar string vinda do JavaScript.
	// Caso não esteja nullo ou vazio ele codifica, caso não, volta string vazia.
}
