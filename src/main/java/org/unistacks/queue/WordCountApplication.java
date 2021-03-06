//package org.unistacks.queue;
//
//import org.apache.kafka.common.serialization.Serdes;
//import org.apache.kafka.streams.KafkaStreams;
//import org.apache.kafka.streams.StreamsConfig;
//import org.apache.kafka.streams.kstream.KStream;
//import org.apache.kafka.streams.kstream.KStreamBuilder;
//import org.apache.kafka.streams.kstream.KTable;
//
//import java.util.Arrays;
//import java.util.Properties;
//
///**
// * Created by Gyges on 2017/10/18
// */
//public class WordCountApplication {
//
//
//    public static void main(String[] args) {
//        Properties config = new Properties();
//        config.put(StreamsConfig.APPLICATION_ID_CONFIG, "wordcount-application");
//        config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.1.202:9092");
//        config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
//        config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
//
//
//        KStreamBuilder builder = new KStreamBuilder();
//        KStream<String, String> textLines = builder.stream("igeek");
//        KTable<String, Long> wordCounts = textLines
//                .flatMapValues(textLine -> Arrays.asList(textLine.toLowerCase().split("\\W+")))
//                .groupBy((key, word) -> word)
//                .count("Counts");
//
//        wordCounts.to(Serdes.String(), Serdes.Long(), "WordsWithCountsTopic");
//        KafkaStreams streams = new KafkaStreams(builder, config);
//        streams.start();
//    }
//}
