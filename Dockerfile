FROM adoptopenjdk/openjdk11:ubi
COPY target/OnlineMarketPlace-0.0.1-SNAPSHOT.jar online-market-place-1.0.0.jar
EXPOSE 8080 8080
ENTRYPOINT ["java","-jar","/online-market-place-1.0.0.jar"]