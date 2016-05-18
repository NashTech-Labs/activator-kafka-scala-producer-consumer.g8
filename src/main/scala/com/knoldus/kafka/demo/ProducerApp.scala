package com.knoldus.kafka.demo

import com.knoldus.kafka.producer.KafkaProducer


object ProducerApp extends App {

  val topic = "demo_topic1"

  val producer = new KafkaProducer("localhost:9092")

  // batch sending
  val batchSize = 50
  (1 to 10000000).toList.map(no => "Message " + no).grouped(batchSize).foreach { message =>
    producer.send(topic, message)
  }

}