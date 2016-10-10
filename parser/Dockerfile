FROM java:8
COPY build/libs/parser.jar /app/parser.jar
ENTRYPOINT ["java", "-jar", "/app/parser.jar"]
CMD ["--db=mongo"]
