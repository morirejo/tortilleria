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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
                .append("fecha", venta.getFecha());
        collection.insertOne(docVenta);
        return true;
    }

    @Override
    public List<VentaDTO> ventasPorFecha(LocalDate inicio, LocalDate fin) {
        Date fechaInicio =  Date.from(inicio.atStartOfDay(ZoneId.systemDefault()).toInstant());

        Date fechaFin = Date.from(fin.plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant());

        var filtro = new Document("fecha",
            new Document("$gte", fechaInicio)
            .append("$lte", fechaFin)
        );

        var resultados = collection.find(filtro);

        List<VentaDTO> lista = new ArrayList<>();

        for (var doc : resultados) {

            Date fechaMongo = doc.getDate("fecha");

            LocalDate fecha = fechaMongo.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

            Number cantidadNum = (Number) doc.get("cantidad");
            Number totalNum = (Number) doc.get("total");

            double cantidad = cantidadNum != null ? cantidadNum.doubleValue() : 0;
            double total = totalNum != null ? totalNum.doubleValue() : 0;

            lista.add(new VentaDTO(
                doc.getInteger("idVenta", 0),
                cantidad,
                total,
                fecha
            ));
        }
        return lista;
    }
}
