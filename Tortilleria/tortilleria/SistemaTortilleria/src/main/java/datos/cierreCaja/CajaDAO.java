/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos.cierreCaja;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dtos.cierreCaja.CorteCajaDTO;
import org.bson.Document;

/**
 *
 * @author MoriTejo
 */
public class CajaDAO implements ICajaDAO {
    private MongoDatabase database;

    public CajaDAO() {
        try {
            MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
            this.database = mongoClient.getDatabase("tortilleriaDB");
        } catch (Exception e) {}
    }

    @Override
    public float obtenerTotalVentasDelDia() {
        float total = 0;
        MongoCollection<Document> ventas = database.getCollection("ventas");
        for (Document doc : ventas.find()) {
            total += doc.getDouble("montoTotal").floatValue();
        }
        return total;
    }

    @Override
    public boolean guardarCorte(CorteCajaDTO corte) {
        MongoCollection<Document> cortes = database.getCollection("cortes_caja");
        Document docCorte = new Document("totalEsperado", corte.getTotalEsperado())
                .append("totalContado", corte.getTotalContado())
                .append("diferencia", corte.getDiferencia())
                .append("fecha", corte.getFechaHora().getTime());
        cortes.insertOne(docCorte);
        return true;
    }
}
