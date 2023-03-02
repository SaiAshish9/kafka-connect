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
