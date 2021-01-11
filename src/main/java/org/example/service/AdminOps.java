package org.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class AdminOps<T> implements Administration<T> {

    private static final Logger logger = LogManager.getLogger(AdminOps.class);

    @Override
    public T list() {
        return null;
    }

    @Override
    public void create(T entity) throws IOException {
        String strFilename = getFileName(entity.getClass().getName());

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(entity);

        try(BufferedWriter out = new BufferedWriter(new FileWriter(strFilename))) {
            out.append(json);
            out.flush();
        } catch (IOException e) {
            logger.error(e);
            throw e;
        }
    }

    private String getFileName(String entityName) {
        String fileName = null;
        Date today = new Date();
        if (entityName.equals("org.example.repository.Contact")) {
            fileName = "contact_" + today.getTime() + ".json";
        } else if (entityName.equals("org.example.repository.Location")) {
            fileName = "location_" + today.getTime() + ".json";
        } else if (entityName.equals("org.example.repository.MenuItem")) {
            fileName = "menuItem_" + today.getTime() + ".json";
        } else if (entityName.equals("org.example.repository.Reservation")) {
            fileName = "reservation_" + today.getTime() + ".json";
        }
        return fileName;
    }

    @Override
    public void update(T entity) {

    }

    @Override
    public void delete(T entity) {

    }
}
