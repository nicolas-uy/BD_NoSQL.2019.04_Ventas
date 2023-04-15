package controlador;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Conexion {

	// Patrón Singleton.
	private static Conexion obj = null;

	public static Conexion getInstance() {
		if (obj == null) {
			obj = new Conexion();
		}
		return obj;
	}

	MongoCollection<Document> collection;
	MongoDatabase mdb;
	MongoClient mc;

	// Constructor privado de la clase.
	private Conexion() {
		// Conexion a MongoDB
		mc = MongoClients.create("mongodb://localhost:27017/?authSource=admin");
		mdb = mc.getDatabase("Prueba-Presencial-2019-04");
		collection = mdb.getCollection("VentasJava");
	}

	public MongoCollection<Document> coleccionDB() {
		return collection;
	}
}