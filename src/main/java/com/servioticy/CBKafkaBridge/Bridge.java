package com.servioticy.CBKafkaBridge;

import com.couchbase.kafka.CouchbaseKafkaConnector;
import com.couchbase.kafka.CouchbaseKafkaEnvironment;
import com.couchbase.kafka.DefaultCouchbaseKafkaEnvironment;

public class Bridge {
    public static void main(String[] args) {
        DefaultCouchbaseKafkaEnvironment.Builder builder =
                (DefaultCouchbaseKafkaEnvironment.Builder) DefaultCouchbaseKafkaEnvironment
                        .builder()
                        .kafkaFilterClass("com.servioticy.CBKafkaBridge.ServioticyFilter")
                        .kafkaValueSerializerClass("com.servioticy.CBKafkaBridge.ServioticyEncoder")
                        .kafkaTopic("updates-secure")
                        .kafkaZookeeperAddress("localhost:2181")
                        .couchbaseNodes("localhost")
                        .couchbaseBucket("zsecsoupdates")
                        .dcpEnabled(true);
        CouchbaseKafkaConnector connector = CouchbaseKafkaConnector.create(builder.build());
        connector.run();
    }
}
