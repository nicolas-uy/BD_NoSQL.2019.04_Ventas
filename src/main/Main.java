package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.google.gson.GsonBuilder;

import controlador.Conexion;
import controlador.ObjectIdSerializer;

public class Main {

	public static void main(String[] args) {
		ejercicio9_CrearDocs();
	}

	public static void ejercicio9_CrearDocs() {
		try {
			// Creo los objetos para los documentos.
			Document doc1 = new Document();
			Document doc2 = new Document();
			Document doc3 = new Document();
			Document doc4 = new Document();
			Document doc5 = new Document();
			Document doc6 = new Document();
			Document doc7 = new Document();
			Document doc8 = new Document();
			Document doc9 = new Document();
			Document doc10 = new Document();

			// Seteo los datos de los documentos.
			doc1.append("Código Inventario", "123321")
					.append("Autor", "Alejandro Dumas")
					.append("Título", "Los tres mosqueteros")
					.append("Precio", 10)
					.append("FechaCompra", formatoFecha("01/02/2022"))
					.append("EdadComprador", 80)
					.append("Ciudad", "Lima")
					.append("Formación", Arrays.asList("Primaria Completo", "Secundaria Completo"));
			doc2.append("Código Inventario", "135426")
					.append("Autor", "Arthur Conan Doyle")
					.append("Título", "Las aventuras de Sherlock Holmes")
					.append("Precio", 11)
					.append("FechaCompra", formatoFecha("02/02/2019"))
					.append("EdadComprador", 45)
					.append("Género", "F")
					.append("Formación", Arrays.asList("Primaria Completo", "Secundaria Completo", "Universidad incompleto"));
			doc3.append("Código Inventario", "135426")
					.append("Autor", "Arthur Conan Doyle")
					.append("Título", "Las aventuras de Sherlock Holmes")
					.append("Precio", 11)
					.append("FechaCompra", formatoFecha("03/03/2019"))
					.append("Género", "Mujer")
					.append("Ciudad", "París");
			doc4.append("Código Inventario", "235678")
					.append("Autor", "Charles Dickens")
					.append("Título", "Cuento de Navidad")
					.append("Precio", 25)
					.append("EdadComprador", 34);
			doc5.append("Código Inventario", "987654")
					.append("Autor", "Charles Dickens")
					.append("Título", "Historia de dos ciudades")
					.append("Precio", 30)
					.append("EdadComprador", 57)
					.append("Género", "M")
					.append("Ciudad", "París");
			doc6.append("Código Inventario", "986532")
					.append("Autor", "Charles Dickens")
					.append("Título", "Oliver Twist")
					.append("Precio", 12)
					.append("FechaCompra", formatoFecha("02/04/2019"))
					.append("Género", "M")
					.append("Formación", Arrays.asList("Primaria Completo", "Secundaria Completo", "Universidad Completo"));
			doc7.append("Código Inventario", "876521")
					.append("Autor", "Edgar allan Poe")
					.append("Título", "El gato negro")
					.append("Precio", 40)
					.append("EdadComprador", 27);
			doc8.append("Código Inventario", "124567")
					.append("Autor", "edgar allan poe")
					.append("Título", "Los crimenes de la Rue Morg")
					.append("Precio", 45)
					.append("FechaCompra", formatoFecha("03/04/2019"))
					.append("Género", "Hombre")
					.append("Ciudad", "Buenos Aires")
					.append("Formación", Arrays.asList("Primaria Completo", "Secundaria Incompleto"));
			doc9.append("Código Inventario", "234590")
					.append("Autor", "Fedor Dostoiewski")
					.append("Título", "Crimen y castigo")
					.append("Precio", 40)
					.append("EdadComprador", 59)
					.append("Género", "Hombre")
					.append("Formación", Arrays.asList("Primaria Completo", "Secundaria Incompleto"));
			doc10.append("Código Inventario", "135426")
					.append("Autor", "Arthur Conan Doyle")
					.append("Título", "Las aventuras de Sherlock Holmes")
					.append("Precio", 29)
					.append("Género", "F")
					.append("Ciudad", "Montevideo");

			// Inserto la coleccion de documentos a la BD.
			Conexion.getInstance().coleccionDB().insertMany(Arrays.asList(doc1, doc2, doc3, doc4, doc5, doc6, doc7, doc8, doc9, doc10));
			// Lista todos los documentos de la BD.
			Conexion.getInstance().coleccionDB().find().forEach(doc -> System.out.println(jsonConsola(doc)));
		} catch (Exception e) {
			System.out.println("Error al crear Documentos. " + e.getMessage());
		}
	}

	public static void ejercicio10() {
		// Generar una sentencia que permita recuperar los documentos cuyo Autor sea Edgar Allan Poe
	}

	public static void ejercicio11() {
		// Generar una sentencia que permita recuperar los documentos que tengan Precio mayor a 35 y la EdadComprador mayor a 40.

	}

	public static void ejercicio12() {
		// Unificar los valores de Género, para que queden normalizados (que los valores finales sean Hombre y Mujer).
	}

	public static void ejercicio13() {
		// Agregar la clave Mes, donde se cargue el mes que se realizó la compra (filtrar para Febrero, Marzo y Abril).
	}

	public static void ejercicio14() {
		// Agregar la clave Clasico, donde se le cargue el valor SI cuando el Autor es Dumas o Dickens

	}

	public static void ejercicio15() {
		// Agregar la clave NivelEducativo, donde se le cargue el valor Alto si tiene formación Universitaria (completa o incompleta).

	}

	public static void ejercicio16() {
		// Eliminar los documentos que no tengan clave FechaCompra.

	}

	private static LocalDate formatoFecha(String fechaString) {
		// Formatea la fecha dd/MM/yyyy a yyyy-MM-dd.
		return LocalDate.parse(fechaString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	private static String jsonConsola(Document doc) {
		// Crea el objeto Gson para impresión en consola.
		return new GsonBuilder().setPrettyPrinting().registerTypeAdapter(ObjectId.class, new ObjectIdSerializer()).create().toJson(doc);
	}

}
