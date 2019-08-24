# webanwendung-buecherverwaltung
<em>Einfache Bücherverwaltung (Webanwendung) mit Spring Boot, Hibernate, Thymeleaf, Spring Data JPA, Spring Starter Web, H2/MySQL</em>


<strong>Starten der Anwendung:</strong>
1) Ordner als zip Datei herunterladen (und entpacken) oder Git repository klonen
2) IDE öffnen und Projekt als Mavenprojekt einbinden (File -> Import -> Existing Maven Project ->Navigate to the folder where you unzipped the zip)
3) Unter src/main/java/com.example Rechtsklick auf BücherverwaltungApplication (Startpunkt der SpringBoot Applikation) und starten als Spring Boot Applikation

Die Anwendung startet standardmäßig auf Port 8080 (und nutzt hierbei den eingebetteten Tomcat Server)  
Zum Aufruf der Startseite genügt es in die Adresszeile des Browsers folgende URL einzugeben:  
http://localhost:8080  
Zum Beenden der Applikation diese URL aufrufen:  
http://localhost:8080/exit  


Datenhaltung:
Mysql und H2 Dependencies sind beides eingebunden und einsetzbar

H2 InMemory Database ist standardmäßig aktiv kann jedoch einfach durch eine MySql Datenbank ausgetauscht werden siehe hierzu unten.
Beispielhafte Anfangsdaten werden per data.sql eingefügt

application.porperties mit H2:    
spring.h2.console.enabled=true  
spring.datasource.platform=h2  
spring.datasource.url=jdbc:h2:mem:buch  

Für MySql:  
Den Code für H2 (oben) austauschen an der Stelle  
application.porperties mit folgendem Code um eine MySQL Datenbank zu nutzen:  
spring.jpa.hibernate.ddl-auto=none  
spring.datasource.url=jdbc:mysql://HIER DIE ENTSPRECHENDE URL EINFÜGEN  
spring.datasource.username=HIER DER ENTSPRECHENDE USERNAME EINFÜGEN  
spring.datasource.password=HIER DAS ENTSPRECHENDE PASSWORT EINFÜGEN  
