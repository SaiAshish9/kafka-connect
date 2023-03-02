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

<img width="677" alt="Screenshot 2023-03-03 at 1 25 59 AM" src="https://user-images.githubusercontent.com/43849911/222538204-76ce8406-cc67-408d-aaae-bac2c1af2d51.png">

<img width="1785" alt="Screenshot 2023-03-03 at 1 27 17 AM" src="https://user-images.githubusercontent.com/43849911/222538519-e3e50a49-f30d-4b38-a78a-c2f7d6b7196b.png">

```
docker run --rm -it --net=host landoop/fast-data-dev bash
Unable to find image 'landoop/fast-data-dev:latest' locally
latest: Pulling from landoop/fast-data-dev
01b5b2efb836: Pull complete 
9069d523e451: Pull complete 
d68846b11d1f: Pull complete 
c1e1aae3ab71: Pull complete 
791c0005650d: Pull complete 
2dcfd373dd63: Pull complete 
e926b621b261: Pull complete 
ac870067259c: Pull complete 
9d61deafb23e: Pull complete 
cbea4bd8ece3: Pull complete 
0b0e67c37d2a: Pull complete 
8726b89bf065: Pull complete 
c68ec3329e49: Pull complete 
Digest: sha256:e8de236d5b8e6e1ab0ded027d2db4b731474475dc17573787a0b29b1c9b15aba
Status: Downloaded newer image for landoop/fast-data-dev:latest

root@fast-data-dev > 
kafka-topics --create --topic demo-kafka-connect --partitions 3 --replication-factor 1 --zookeeper 127.0.0.1:2181
kafka-topics --create --topic demo-kafka-connect --partitions 3 --replication-factor 1 --bootstrap-server 127.0.0.1:9092

root@fast-data-dev / $ kafka-topics --create --topic demo-kafka-connect --partitions 3 --replication-factor 1 --bootstrap-server 127.0.0.1:9092
Created topic demo-kafka-connect.

```

<img width="559" alt="Screenshot 2023-03-03 at 1 58 08 AM" src="https://user-images.githubusercontent.com/43849911/222544438-5a1d8e0a-432d-4fbb-95fb-d3c877cafbf9.png">

<img width="1712" alt="Screenshot 2023-03-03 at 1 58 58 AM" src="https://user-images.githubusercontent.com/43849911/222544600-72b291eb-36f4-4a1c-9e1c-322753fbfa50.png">

<img width="1789" alt="Screenshot 2023-03-03 at 1 59 55 AM" src="https://user-images.githubusercontent.com/43849911/222544773-715474f3-621c-4617-909e-bc54a5a3a306.png">

<img width="1786" alt="Screenshot 2023-03-03 at 2 00 39 AM" src="https://user-images.githubusercontent.com/43849911/222544906-abef9826-da26-46ba-8c6c-adf25431abae.png">

<img width="1787" alt="Screenshot 2023-03-03 at 2 01 09 AM" src="https://user-images.githubusercontent.com/43849911/222544985-337207ed-42e6-4fb0-a2ec-f97fd370114c.png">

<img width="1789" alt="Screenshot 2023-03-03 at 2 01 38 AM" src="https://user-images.githubusercontent.com/43849911/222545069-c5c08b18-4f9c-4328-9038-b648e842ef6a.png">

<img width="1789" alt="Screenshot 2023-03-03 at 2 02 09 AM" src="https://user-images.githubusercontent.com/43849911/222545169-98f055ca-db4a-4839-845a-55b57ed0f2fd.png">

<img width="1788" alt="Screenshot 2023-03-03 at 2 11 49 AM" src="https://user-images.githubusercontent.com/43849911/222547020-9aaf561f-a09b-4e78-8bfd-799ff2c0111e.png">

<img width="1788" alt="Screenshot 2023-03-03 at 2 14 48 AM" src="https://user-images.githubusercontent.com/43849911/222547612-9f2df2f5-d12c-4be7-9df4-0c45a3eed9be.png">

<img width="817" alt="Screenshot 2023-03-03 at 2 16 18 AM" src="https://user-images.githubusercontent.com/43849911/222548029-cb93f568-8ad4-4e7f-8969-bdc95777af63.png">

```
docker ps
a84f2588f16c   landoop/fast-data-dev:cp3.3.0   "/usr/local/bin/dumb…"   50 minutes ago   Up 50 minutes   0.0.0.0:2181->2181/tcp, 0.0.0.0:3030->3030/tcp, 0.0.0.0:8081-8083->8081-8083/tcp, 0.0.0.0:9092->9092/tcp, 0.0.0.0:9581-9585->9581-9585/tcp, 3031/tcp   connect-kafka-cluster-1

docker exec -it a84f bash
touch demo-file.txt

echo "sai" >> demo-file.txt

<img width="1788" alt="Screenshot 2023-03-03 at 2 20 31 AM" src="https://user-images.githubusercontent.com/43849911/222549063-3645c350-b29d-4d23-95d1-70b529a2ebc8.png">

docker run --rm -it --net=host landoop/fast-data-dev bash

kafka-console-consumer --topic demo-kafka-connect --from-beginning --bootstrap-server 127.0.0.1:9092
{"schema":{"type":"string","optional":false},"payload":"sai"}
```

<img width="816" alt="Screenshot 2023-03-03 at 2 25 39 AM" src="https://user-images.githubusercontent.com/43849911/222550255-82bf90a5-bf2b-4c70-b2b6-ed7eec292665.png">
