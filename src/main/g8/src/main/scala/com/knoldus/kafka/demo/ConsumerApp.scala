package com.knoldus.kafka.demo

import com.knoldus.kafka.consumer.KafkaConsumer


object ConsumerApp extends App {


  val topic = "demo-topic"
  val groupId = "demo-topic-consumer"

  val consumer = new KafkaConsumer(topic, groupId, "localhost:2181")

  while (true) {
    consumer.read() match {
      case Some(message) =>
        println("Getting message.......................  " + message)
        // wait for 100 milli second for another read
        Thread.sleep(100)
      case None =>
        println("Queue is empty.......................  ")
        // wait for 2 second
        Thread.sleep(2 * 1000)
    }

  }

}
