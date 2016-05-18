# activator-kafka-pubsub

###Download link for kafka :

    http://kafka.apache.org/downloads.html

Once you download it, Set number of log partitions per topic to 8 in server.properties

    num.partitions=8

##Run zookeeper and kafka on your system : 

    kafka$ bin/zookeeper-server-start.sh config/zookeeper.properties
    kafka$ bin/kafka-server-start.sh config/server.properties 
    
##Steps to start producer service :

    ./activator "run-main com.knoldus.kafka.demo.ProducerApp"
  
  This producer sends 10 million messages in kafka queue using batch size of 50.

##Steps to start consumer service :

    ./activator "run-main com.knoldus.kafka.demo.ConsumerApp"
  
  You can start multiple consumers at a time which pull messages from kafka queue.
