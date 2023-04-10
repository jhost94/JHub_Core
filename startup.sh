if [ -z "$1" ]; then
  mvn clean install && java -jar target/Core*.jar --spring.profiles.active=local
else
  mvn clean install && java -jar target/Core*.jar --spring.profiles.active="$1"
fi
