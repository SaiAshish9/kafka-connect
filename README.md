https://kafka.apache.org/documentation/#connect

```
Let's say we've multiple data sources (in) to ingest data into kafka cluster (multiple target data store(out)) from where we need
to write data to kafka cluster.

Producer have lot of sources and consumers have different targets.
```

<img width="857" alt="Screenshot 2023-03-02 at 10 51 56 PM" src="https://user-images.githubusercontent.com/43849911/222504277-1c987640-9775-4cef-a4c8-1d79746e378c.png">

```
For a developer it will be made to write the code for n number of custom ports and n number of destination systems (postgres, snowflake and elaticsearch).

And lets say we need to consume textfile via postgres, some other developers might have already done that job.

If a engineer worked on that kind of source and destination. We can reuse their code via certain config changes.

That's where kafka connect comes into picture. 

kafka connect is robust, scalable, low and no port configuration driven approach using which we can pool data from 
various source systems and publish to kafka cluster.

Similarly, we can consume data in different target systems.

If some developer is already worked on that source and destination topic, we can make use of their reusable code and modify 
certain configuration. This is known as configuration driven approach.

Kafak connects solves one of our major problem. If we've different sources and targets then consuming the data from kafka cluster
and publishing to kafka cluster to different target systems, we can use reusable a configuration driven helper called kafka connect.

So its basically a jar file which different developers can edit.

Configurations needs to be handled carefully via jar file
```

<img width="982" alt="Screenshot 2023-03-02 at 11 33 00 PM" src="https://user-images.githubusercontent.com/43849911/222513342-54da1aff-504a-4cf5-88dd-1862947d15d8.png">

```
In order to efficiently work with kafka connect, it is helpful to establish a few major concepts.


1. Connector: It is a job that manages and coordinates the tasks. It decides how to split the data copying work between
the tasks.

2. Task is a piece of work that provides service to accomplish the actual job.

3. Worker is the node that is running the connector and its tasks.

Connector is splitting the data copy activity into multiple small chunks.

Connectors divide the actual job into smaller pieces in order to have parallelism and scalable data copying with
very little configuration.

Sometimes we need to push the data from kafka cluster to non kafka cluster.

How the different tasks are synchronised and coordination is established , that is done by the connector.

Worker can be standalone or distributed. For development, we can use standalone where all our tasks will be running. 

For production we can use distributed env.
```

```
Kafka connect cluster at distributed environment:

All are working parallely but in diff. nodes that why its called distributed node.

Conn 1 is running and is coordinating among different tasks.
```

<img width="560" alt="Screenshot 2023-03-02 at 11 59 48 PM" src="https://user-images.githubusercontent.com/43849911/222519511-88881506-55ff-4063-8870-7d242d1af805.png">

```
If one worker node fails then rebalancing them . Big data systems concepts via Spark can be applied here as well.
```

<img width="518" alt="Screenshot 2023-03-03 at 12 06 12 AM" src="https://user-images.githubusercontent.com/43849911/222520787-47e1c0a2-5b97-4f7f-a068-920afde548f4.png">

<img width="627" alt="Screenshot 2023-03-03 at 12 10 44 AM" src="https://user-images.githubusercontent.com/43849911/222521805-65e39a13-fac7-4454-a152-3e94d9620c34.png">

```
For standalone within one worker only all the tasks will run.
```

<img width="962" alt="Screenshot 2023-03-03 at 12 28 30 AM" src="https://user-images.githubusercontent.com/43849911/222525525-08829f85-5a6e-4caf-94c5-ac2a8bf1b39c.png">

```
Why Kafka Connect And Streams:

Source => Kafka Producer API (topic to kafka)
Kafka => Kafka Consumer, Producer APi (topic in kafka to create another topic in kafka)
Kafka => Sink Consumer API (topic in kafka to kafka)
Sink => App Consumer API
```

```
Kafka Connect source API to easily have a source and puts all the data into kafka

Kafka Streams is used to do transformations on kafka topics.

Kafka Sink is used to get topics out of kafka wherever we want

Kafka Connect help simplify and improve getting data in and out of kafka.

Programmers always want to import data from same sources: Databases, JDBC, Couchbase and Twitter, etc.

Programmers always want to store data into same sinka: S3, ElasticSearch etc.

It is tough to achieve fault tolerance, exactly once, distribution and ordering. Some developers may have already done that job.

Kafka data can be used to don't rewrite code that someone else has written instead use someone else connector and bring own configuration.
```

```
Simplify and improve getting data in and out of kafka.

It provides connectors to easily get data in and out of kafka.

Source => Kafka Producer API (Kafka Connect Source)
Kafka => Sink Consumer API (Kafka Connect Sink)
```

```
saiashish@MBP-C02F5ASXMD6M connect % docker-compose up kafka-cluster
[+] Running 0/1
 ⠴ kafka-cluster Pulling                                                   4.6s
   ⠋ b56ae66c2937 Pulling fs layer                                         0.0s
   ⠋ 1aa8af445446 Pulling fs layer                                         0.0s
   ⠋ 4c2cdd913f21 Pulling fs layer                                         0.0s
   ⠋ 990edf28e90a Waiting                                                  0.0s
   ⠋ 19496c140f70 Waiting                                                  0.0s
   ⠋ 70477240e7e2 Waiting                                                  0.0s
   ⠋ ce8f224d79a7 Waiting                                                  0.0s
   ⠋ e0ab8373972d Waiting                                                  0.0s
   ⠋ 5f61e765a6e6 Waiting                                                  0.0s
   ⠋ d59ba5b8d22e Waiting                                                  0.0s
   ⠋ 8aae69f6b136 Waiting                                                  0.0s
[+] Running 0/352 Waiting                                                  0.0s
 ⠦ kafka-cluster Pulling                                                   4.7s
   ⠙ b56ae66c2937 Pulling fs layer                                         0.1s
   ⠙ 1aa8af445446 Pulling fs layer                                         0.1s
   ⠙ 4c2cdd913f21 Pulling fs layer                                         0.1s
   ⠙ 990edf28e90a Waiting                                                  0.1s
   ⠙ 19496c140f70 Waiting                                                  0.1s
   ⠙ 70477240e7e2 Waiting                                                  0.1s
   ⠙ ce8f224d79a7 Waiting                                                  0.1s
   ⠙ e0ab8373972d Waiting                                                  0.1s
```


