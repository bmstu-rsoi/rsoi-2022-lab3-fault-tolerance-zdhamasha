mvn -f gateway/pom.xml --batch-mode --update-snapshots clean package -DskipTests
mvn -f flight/pom.xml --batch-mode --update-snapshots clean package -DskipTests
mvn -f ticket/pom.xml --batch-mode --update-snapshots clean package -DskipTests
mvn -f bonus/pom.xml --batch-mode --update-snapshots clean package -DskipTests

docker-compose build

docker-compose up