FROM amazoncorretto:17
COPY target/fc-eda-balances-*.jar fc-eda-balances.jar

ENTRYPOINT ["java", "-Dspring.profiles.active=server", "-jar", "/fc-eda-balances.jar"]


