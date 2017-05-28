package com.knoldus.kafka.producer

import java.util.{Properties, UUID}

import kafka.message.DefaultCompressionCodec
import kafka.producer.{KeyedMessage, Producer, ProducerConfig}


class KafkaProducer(brokerList: String) {


  private val props = new Properties()

  props.put("compression.codec", DefaultCompressionCodec.codec.toString)
  props.put("producer.type", "sync")
  props.put("metadata.broker.list", brokerList)
  props.put("message.send.max.retries", "5")
  props.put("request.required.acks", "-1")
  props.put("serializer.class", "kafka.serializer.StringEncoder")
  props.put("client.id", UUID.randomUUID().toString())

  private val producer = new Producer[String, String](new ProducerConfig(props))

  def send(topic: String, message: String): Unit = send(topic, List(message))

  def send(topic: String, messages: Seq[String]): Unit =
    try {
      println("sending batch messages  to kafka queue.......")
      val queueMessages = messages.map { message => new KeyedMessage[String, String](topic, message) }
      producer.send(queueMessages: _*)
    } catch {
      case ex: Exception =>
        ex.printStackTrace()

    }


}
