/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dtos.VentaDTO;
import org.bson.Document;

/**
 *
 * @author MoriTejo
 */
public class VentaDAO implements  IVentaDAO{
    private MongoCollection<Document> collection;

    public VentaDAO() {
        try {
            MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
            MongoDatabase database = mongoClient.getDatabase("tortilleriaDB");
            this.collection = database.getCollection("ventas");
        } catch (Exception e) {}
    }

    @Override
    public boolean guardarVenta(VentaDTO venta) {
        Document docVenta = new Document("idVenta", venta.getIdVenta())
                .append("cantidadKG", venta.getCantidadKG())
                .append("montoTotal", venta.getMontoTotal())
                .append("fecha", venta.getFecha().getTime());
        collection.insertOne(docVenta);
        return true;
    }
}
