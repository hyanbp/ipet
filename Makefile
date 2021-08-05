docker-build: gradle-build
        docker build . -t ipet:latest
docker-run: docker-build
        docker run -p 8080:8080 ipet:latest
gradle-build:
	gradle clean build

