docker-compose down

cnt_docker_network=`docker network ls --filter name=docker-spring-cloud | wc -l`
cnt_docker_network=$(($cnt_docker_network -1))

if [ $cnt_docker_network -ne 0 ]
then
  echo "'docker-spring-cloud' 가 존재합니다. 'docker-spring-cloud' 를 삭제합니다."
    docker network rm docker-spring-cloud
fi