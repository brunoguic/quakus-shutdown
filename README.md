# hello-shutdown

This app logs events releated to Quakrus shutdown

Readiness: `watch -n 1 curl -s http://localhost:8080/q/health/ready`

Liveness: `watch -n 1 curl -s http://localhost:8080/q/health/live`

Build and Run: `mvn clean package && java -jar target/quarkus-app/quarkus-run.jar` 
