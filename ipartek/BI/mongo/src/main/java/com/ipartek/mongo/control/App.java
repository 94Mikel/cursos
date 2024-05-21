package com.ipartek.mongo.control;

import java.io.IOException;
import java.io.Reader;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.functors.ExceptionPredicate;
import org.bson.Document;

import com.ipartek.entidades.Ciudad;
import com.ipartek.entidades.Pais;
import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class App {

	private static final String COUNTRY_LIST_MASTER_CSV_FILE_PATH = "./data/country-list-master.csv";
	private static final String UNSD_CITYPOPULATION_YEAR_BOTH_CSV_FILE_PATH = "./data/unsd-citypopulation-year-both.csv";
	private static final String UNSD_CITYPOPULATION_YEAR_FM_CSV_FILE_PATH = "./data/unsd-citypopulation-year-fm.csv";
	private static final String WORLD_CITIES_CSV_FILE_PATH = "./data/world-cities.csv";

	public static void main(String[] args) throws IOException {

		//
		// Creates a new instance of MongoDBClient and connect to localhost
		// port 27017.
		//
		// mongoConexion();
		Ciudad ciudad;
		List<Ciudad> ciudades;
		ciudades = new ArrayList<>();
		try (Reader reader = Files.newBufferedReader(Paths.get(UNSD_CITYPOPULATION_YEAR_BOTH_CSV_FILE_PATH));
				// CSVReader csvReader = new CSVReader(reader);
				CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();) {
			// Reading Records One by One in a String array
			List<String[]> records = csvReader.readAll();
			for (String[] record : records) {
				if (record[4] != null || record[5] != null || record[10] != null || record[9]!="") {
					boolean entra=true;
					try {
						Integer.parseInt(record[9]);
					} catch (NumberFormatException e) {
						entra=false;
					}
					
					if(entra) {
						
						ciudad = new Ciudad();
						ciudad.setNombre(record[4]);
						ciudad.setTipoCiudad(record[5]);
						int poblacionTotal=Integer.parseInt(record[9]);
						ciudad.setPoblacionTotal(poblacionTotal);
						ciudad.setPoblacionHombre(obtenerPoblacionHombres(ciudad));
						ciudad.setPoblacionMujeres(obtenerPoblacionMujeres(ciudad));
						ciudades.add(ciudad);
					}
						
				}
			}
		}
		System.out.println("asdf");
		
		List<Pais> paises = new ArrayList<>();

		try (Reader readerPaises = Files.newBufferedReader(Paths.get(COUNTRY_LIST_MASTER_CSV_FILE_PATH));
				CSVReader csvReaderPaises = new CSVReaderBuilder(readerPaises).withSkipLines(1).build();

		) { // Reading Records One by One in a String array String[]
			List<String[]> records = csvReaderPaises.readAll();
			for (String[] record : records) {
				Pais pais = new Pais();
				pais.setNombre(record[0]);
				pais.setCodigo(record[1]);
				adjuntarCiudad(pais, ciudades);
				paises.add(pais);
			}
			
		}
		
		for (Pais pa : paises) {
			System.out.println("---------------");
			System.out.println("nombre: " + pa.getNombre());
			System.out.println("Codigo: " + pa.getCodigo());
			System.out.println("Ciudad: " + pa.getCiudad().getNombre());
			System.out.println("Tipo de ciudad: " + pa.getCiudad().getTipoCiudad());
			System.out.println("poblacion total de la ciudad: " + pa.getCiudad().getPoblacionTotal());
			System.out.println("poblacion hombre de la ciudad: " + pa.getCiudad().getPoblacionHombre());
			System.out.println("poblacion mujeres de la ciudad: " + pa.getCiudad().getPoblacionMujeres());
		}

	}

	/*
	 * List<Pais> paises = new ArrayList<>();
	 * 
	 * try ( Reader readerPaises =
	 * Files.newBufferedReader(Paths.get(COUNTRY_LIST_MASTER_CSV_FILE_PATH));
	 * CSVReader csvReaderPaises = new CSVReader(readerPaises);
	 * 
	 * ) { // Reading Records One by One in a String array String[]
	 * nextRecordPaises; while ((nextRecordPaises = csvReaderPaises.readNext()) !=
	 * null) { Pais pais = new Pais(); pais.setNombre(nextRecordPaises[0]);
	 * pais.setCodigo(nextRecordPaises[1]); adjuntarCiudad(pais,ciudades);
	 * paises.add(pais); } }
	 * 
	 * for(Pais pa:paises) { System.out.println("nombre: "+pa.getNombre());
	 * System.out.println("Codigo: "+pa.getCodigo());
	 * System.out.println("Ciudad: "+pa.getCiudad().getNombre());
	 * System.out.println("Tipo de ciudad: "+pa.getCiudad().getTipoCiudad());
	 * System.out.println("poblacion total de la ciudad: "+pa.getCiudad().
	 * getPoblacionTotal());
	 * System.out.println("poblacion hombre de la ciudad: "+pa.getCiudad().
	 * getPoblacionHombre());
	 * System.out.println("poblacion mujeres de la ciudad: "+pa.getCiudad().
	 * getPoblacionMujeres()); }
	 */

	private static void adjuntarCiudad(Pais pais, List<Ciudad> ciudades) throws IOException {
		try (Reader readerCiudades = Files.newBufferedReader(Paths.get(WORLD_CITIES_CSV_FILE_PATH));
				CSVReader csvReaderCiudades = new CSVReader(readerCiudades);

		) {
			String[] nextRecordRelacionCiudad;
			while ((nextRecordRelacionCiudad = csvReaderCiudades.readNext()) != null) {
				if (pais.getNombre().equals(nextRecordRelacionCiudad[0])) {
					Ciudad ciudad = obtenerCiudadPorNombre(nextRecordRelacionCiudad[0], ciudades);
					if (ciudad != null) {
						pais.setCiudad(ciudad);
					}
				}
			}

		}
	}

	private static Ciudad obtenerCiudadPorNombre(String nombreCiudad, List<Ciudad> ciudades) {

		for (Ciudad ciudad : ciudades) {
			if (ciudad.getNombre().equals(nombreCiudad)) {
				return ciudad;
			}
		}
		return null;

	}

	private static int obtenerPoblacionMujeres(Ciudad ciudad) throws IOException {

		try (Reader readerPoblacionMujeres = Files
				.newBufferedReader(Paths.get(UNSD_CITYPOPULATION_YEAR_FM_CSV_FILE_PATH));
				CSVReader csvReaderPoblacionMujeres = new CSVReader(readerPoblacionMujeres);

		) {
			// Reading Records One by One in a String array
			String[] nextRecordPoblacionMujeres;
			while ((nextRecordPoblacionMujeres = csvReaderPoblacionMujeres.readNext()) != null) {
				if ("Female".equals(nextRecordPoblacionMujeres[3])
						&& ciudad.getNombre().equals(nextRecordPoblacionMujeres[4])) {
					boolean entra = true;
					try {
						Integer.parseInt(nextRecordPoblacionMujeres[9]);
					} catch (NumberFormatException e) {
						entra=false;
					}
					if(!entra) {
						return 0;
					}else {
					return Integer.parseInt(nextRecordPoblacionMujeres[9]);
					}
				}
			}
		}
		return 0;

	}

	private static int obtenerPoblacionHombres(Ciudad ciudad) throws IOException {

		try (Reader readerPoblacionHombre = Files
				.newBufferedReader(Paths.get(UNSD_CITYPOPULATION_YEAR_FM_CSV_FILE_PATH));
				CSVReader csvReaderPoblacionHombre = new CSVReader(readerPoblacionHombre);

		) {
			// Reading Records One by One in a String array
			String[] nextRecordPoblacionHombre;
			while ((nextRecordPoblacionHombre = csvReaderPoblacionHombre.readNext()) != null) {
				if ("Male".equals(nextRecordPoblacionHombre[3])
						&& ciudad.getNombre().equals(nextRecordPoblacionHombre[4])) {
					boolean entra = true;
					try {
						Integer.parseInt(nextRecordPoblacionHombre[9]);
					} catch (NumberFormatException e) {
						entra=false;
					}
					if(!entra) {
						return 0;
					}else {
						return Integer.parseInt(nextRecordPoblacionHombre[9]);
					}
					
				}
			}
		}
		return 0;
	}

	private static void mongoConexion() {
		MongoClient client = new MongoClient(new ServerAddress("localhost", 27017));

		MongoDatabase mydatabase = client.getDatabase("taller");

		/**** Get collection / table from 'testdb' ****/
		// if collection doesn't exists, MongoDB will create it for you

		//
		// obtener usuarios de la base de datos mongo
		//
		// MongoCursor<Document> collection = database.getCollection("usuarios");
		FindIterable<Document> tabla = mydatabase.getCollection("usuario").find();
		MongoCursor<Document> cursor = tabla.iterator();

		while (cursor.hasNext()) {
			Document usuario = cursor.next();
			System.out.println(usuario.toString());
			// do something with document
		}

		cerrarConexion(client);
	}

	private static void cerrarConexion(MongoClient client) {
		if (client != null) {
			client.close();
		}

	}

}
