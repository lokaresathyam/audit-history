case $1 in
  "build")

    echo "creating compiler container"

    docker build . -t audit-history-compiler

    docker run -v $(pwd):/home/compiler/ audit-history-compiler

    docker rmi audit-history-compiler --force

    echo "compiled!"

  ;;
  "run")
    docker-compose -p "microservices" up -d --force-recreate --build
;;
esac
