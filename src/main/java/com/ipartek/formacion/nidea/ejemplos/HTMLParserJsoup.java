package com.ipartek.formacion.nidea.ejemplos;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HTMLParserJsoup {

	public static void main(String[] args) throws IOException {

		String url = "http://192.168.0.42:8080/nidea/login";
		// String url = "http://localhost:8080/nidea/login";
		String urlMaterial = "http://192.168.0.42:8080/nidea/backoffice/materiales?op=1";

		Connection.Response response = Jsoup.connect(url).method(Connection.Method.POST).data("usuario", "admin")
				.data("password", "admin").execute();

		Document docBackoffice = response.parse();
		System.out.println(docBackoffice.getElementsByTag("h1").get(0).text());
		String cookieSession = response.cookies().get("JSESSIONID");

		// Connection.Response response2 =
		// Jsoup.connect(url).method(Connection.Method.GET).execute();
		//
		// Document docMateriales = response2.parse();
		// Element botonCrear = docMateriales.getElementsByTag("button").get(0);

		Connection.Response responseCrearMaterial = Jsoup
				.connect("http://192.168.0.42:8080/nidea/backoffice/materiales?op=2").method(Connection.Method.POST)
				.data("nombre", "Aingeru + 2").data("precio", "11.0").cookie("JSESSIONID", cookieSession).execute();

		Document docBackczxczdsoffice = responseCrearMaterial.parse();

		Document docBackoffdsdicewrsewte = response.parse();

	}

}
