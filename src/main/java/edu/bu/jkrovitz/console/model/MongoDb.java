package edu.bu.jkrovitz.console.model;

import ch.qos.logback.classic.Logger;

//import java.util.logging.Level;

import static java.util.logging.Level.OFF;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.*;
import org.apache.logging.log4j.LogManager;
import org.bson.Document;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

import com.mongodb.client.MongoClients;

import java.util.Iterator;
import java.util.function.Consumer;
import java.util.Set;

public class MongoDb {

    MongoClient mongoClient = new MongoClient("localhost", 27017);
    MongoDatabase database = mongoClient.getDatabase("lmsDb");


    public MongoClient createConnection() {

        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        Logger rootLogger = loggerContext.getLogger("org.mongodb.driver");
        Logger anotherLogger = loggerContext.getLogger("org.mongodb.driver.cluster");
        rootLogger.setLevel(Level.OFF);
        anotherLogger.setLevel(Level.OFF);


        // Creating Credentials
        MongoCredential credential;
        credential = MongoCredential.createCredential("sampleUser", "lmsDb",
                "password".toCharArray());
        return mongoClient;
    }

    public MongoDatabase getMongoDatabase() {
        //Accessing the database
        turnOffLogging();
        MongoClient mongoClient = createConnection();
        return mongoClient.getDatabase("lmsDb");

    }

    public void turnOffLogging(){
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        Logger rootLogger = loggerContext.getLogger("org.mongodb.driver");
        rootLogger.setLevel(Level.OFF);
    }

    public MongoCollection<Document> createCollection() {
        turnOffLogging();
        MongoDatabase database = getMongoDatabase();
        if (collectionExists("lmsDB", "books")) {
            database.createCollection("books");
        }
        MongoCollection<Document> collection = database.getCollection("books");
        createDocument();
        return collection;
    }


    public boolean collectionExists(final String db, final String collectionName) {
        turnOffLogging();
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        Logger rootLogger = loggerContext.getLogger("org.mongodb.driver");
        rootLogger.setLevel(Level.OFF);
        final MongoDatabase database = mongoClient.getDatabase(db);
        if (database == null) {
            return false;
        }

        final MongoIterable<String> iterable = database.listCollectionNames();
        try (final MongoCursor<String> it = iterable.iterator()) {
            while (it.hasNext()) {
                if (it.next().equalsIgnoreCase(collectionName)) {
                    return true;
                }
            }
        }

        return false;
    }

    public void createDocument() {
        turnOffLogging();
        Document document = new Document();
        document.append("book", "Red Kayak");
        document.append("author", "Prescilla Cummings");
        //Inserting the document into the collection
        database.getCollection("books").insertOne(document);
        System.out.println("Document inserted successfully");

    }

    public void getCollection() {
        turnOffLogging();
        MongoCollection<Document> collection = database.getCollection("books");
        //Retrieving the documents
        FindIterable<Document> iterDoc = collection.find();
        Iterator it = iterDoc.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}



