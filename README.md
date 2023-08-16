# Spring Boot Kafka Demo

## Steps to Setup
**1. Download and Install Kafka**

Visit the Apache [Kafka download page](https://kafka.apache.org/downloads) to download the latest version of Kafka and extract it

**2. Start the ZooKeeper server**

Open a terminal and navigate to the Kafka directory.
```bash
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
```

**3. Start the Kafka server**

In a new terminal window, start the Kafka server:
```bash
.\bin\windows\kafka-server-start.bat .\config\server.properties
```

**4. Clone the Application**

```bash
git clone https://github.com/attrayadas/springboot-kafka-demo.git
```

**5. Run the app using Maven**

```bash
mvn spring-boot:run
```

**6. Sending and Receiving Messages**

After running the Spring Boot application, you can use the following REST APIs to interact with Kafka:
+ To publish a message via GET request:
```bash
GET http://localhost:8080/api/v1/kafka/publish?message=<message>
```
+ To publish a message via POST request (provide JSON in the request body):
```bash
POST http://localhost:8080/api/v1/kafka/publish
Content-Type: application/json

{
    "id": 4,
    "firstName": "Attraya",
    "lastName": "Das"
}
```

**7. Read the events from the Kafka Topic**

To read events from the Kafka Topic, open a terminal and navigate to the Kafka directory. Then run:
```bash
.\bin\windows\kafka-console-consumer.bat --topic <topic name> --from-beginning --bootstrap-server localhost:9092
```

