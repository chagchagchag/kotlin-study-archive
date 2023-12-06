cnt_docker_network=`docker network ls --filter name=docker-spring-cloud | wc -l`
cnt_docker_network=$(($cnt_docker_network -1))

if [ $cnt_docker_network -eq 0 ]
then
  echo "'docker-spring-cloud' 가 존재하지 않습니다. 'docker-spring-cloud'를 새로 생성합니다."
  docker network create docker-spring-cloud
fi

docker-compose up -d