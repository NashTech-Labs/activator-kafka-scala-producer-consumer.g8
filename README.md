# activator-kafka-scala-producer-consumer

#### Steps to Install and Run zookeeper and kafka on your system : 

Step 1: Download kafka from [here](http://mirror.fibergrid.in/apache/kafka/0.10.0.0/kafka_2.11-0.10.0.0.tgz)

Once you download it, Set number of log partitions per topic to 8 in server.properties

    num.partitions=8

Step2: Extract it

    $ tar -xzf kafka_2.11-0.10.0.0.tgz
    $ cd  kafka_2.11-0.10.0.0

Step3: Start the server

Start  zookeeper:

     $ bin/zookeeper-server-start.sh config/zookeeper.properties

Start  Kafka server:

    $ bin/kafka-server-start.sh config/server.properties
    
#### Clone Project:
   
    
    $ git clone git@github.com:knoldus/activator-kafka-scala-producer-consumer.git
    
    $ cd activator-kafka-scala-producer-consumer
    
    $ ./activator clean compile
    
    
#### Steps to start producer service :

    $ ./activator "run-main com.knoldus.kafka.demo.ProducerApp"
  
  This producer sends 10 million messages in kafka queue using batch size of 50.

#### Steps to start consumer service :

    $ ./activator "run-main com.knoldus.kafka.demo.ConsumerApp"
  
  You can start multiple consumers at a time which pull messages from kafka queue.
