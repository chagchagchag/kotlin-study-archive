cd ..

#./gradlew :docker-discovery-service:clean
./gradlew :docker-discovery-service:jib

#./gradlew :docker-config-service:clean
#./gradlew :docker-config-service:jar
#./gradlew :docker-config-service:jibDockerBuild
./gradlew :docker-config-service:jib

#./gradlew :docker-discovery-client:clean
./gradlew :docker-discovery-client:jib

#./gradlew :docker-api-gateway-service:clean
./gradlew :docker-api-gateway-service:jib