package com.knoldus.kafka.demo

import com.knoldus.kafka.producer.{AsyncProducer, KafkaProducer}


object ProducerApp extends App {

  val topic = "demo-topic"

  val producer = new AsyncProducer("localhost:9092")
  //val producer = new KafkaProducer("localhost:9092")

  val batchSize = 100

  (1 to 1000000).toList.map(no => "Message " + no).grouped(batchSize).foreach { message =>
    println("Sending message batch size " + message.length)
    producer.send(topic, message)
  }

}