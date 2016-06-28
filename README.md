# micro-apns
A microservice server app for sending APNS(Apple Push Notification Service) push notifications to one or multiple apps.
Includes:
- An HTTP and JMX endpoint for viewing info's about the certificate files (e.g. start/expiry date, filepath etc.)
- An HTTP and JMX endpoint for pushing notifications
 
Additional info:
- based on java, spring-boot and notnoop's APNS lib(https://github.com/notnoop/java-apns).

How to:
- use application-template.yml as example for configuring your certificates
