# acc-camel-example

- Prepare for Kafka:
    - Download **_bin_** files: https://kafka.apache.org/downloads
    - Configure properties:
      - *zookeeper.properties*, with link to data folder.
      - *server.properties*, with link to data folder.

- Run Kafka:
  - Run zookeeper:
  ```
  .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
  ```
  - Run Kafka server:
  ```
  .\bin\windows\kafka-server-start.bat .\config\server.properties 
  ```


- Run projects:
    - Make a request:
    > http://localhost:8080/swagger-ui/index.html
    - Review Logs: 

    `[OrderService] Order 6a3e000b-1fb0-475e-ab0a-b5a2279de494 published`

    `[LoyaltyService] Order event received in Loyalty service => 6a3e000b-1fb0-475e-ab0a-b5a2279de494`
    
    `[StockService] Order event received in Stock service => 6a3e000b-1fb0-475e-ab0a-b5a2279de494`