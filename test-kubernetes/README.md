# Jumpstart Projekt für Java Spring Boot Applikationen

## Wozu braucht man das
Dieses Template - Projekt wird dir von PENG zur Verfügung gestellt, damit Du innerhalb weniger Minuten einen neuen Spring Boot µ Service in die für Dich provisionierte Umgebung deployen kannst.

## Welche Spielregeln gibt es 
__„You build it you run it!“__ bedeutet für uns von PENG, dass wir Dir eine vernünftige Grundkonfiguration zur Verfügung stellen. Du hast aber alle Fäden in der Hand. Du kannst jede Konfiguration ändern. Du kannst natürlich auch das Template nach Belieben für dich anpassen.
Wenn Du persönlichen Support von uns benötigst, kannst Du den über unseren Servicekatalog buchen. Dann kommt von PENG jemand bei Euch vorbei um Euch mit Rat und Tat zur Seite zu stehen.  

## Was sind die nötigen Vorbereitungen
Damit Du dieses Jumpstart Template verwenden kannst, musst du vorab folgende Services bei uns anstoßen:
* __GitLab__  für Dein Produkt provisionieren
* __Kubernetes Cluster__ für Dein Produkt provisionieren
* __MariaDB__ für Dein Produkt provisionieren
* __EFK Logging__  für Dein Produkt provisionieren
* __Grafana Monitoring__ für Dein Produkt provisionieren
* __URL – Pfad__ für Dein Produkt provisionieren

## Wie erzeugst Du Deinen µ Service
### Aus GitLab das Java Template kopieren
* `git clone https://git.mt-ag.com/artikelsuche/jump-starts/java-jumpstart`
* benenne das Verzeichnis `java-jumpstart` passend zu Deinem µ Service um
* lösche das `.git` Verzeichnis in Deinem Projektverzeichnis um die Verbindung zum Jumpstart Template zu kappen.

### Maven `pom.xml` anpassen
Folgende vier Werte solltest Du Deinem µ Service entsprechend anpassen:

```
	<groupId>com.mtag.artikelsuche</groupId>
	<artifactId>{your µ service id}</artifactId>
	<name>{your µ service name}</name>
	<description>{describe it a bit}</description>
```

### GitLab `.gitlab-ci.yml` anpassen
Folgende drei Werte müssen vergeben werden:

```
    # So heißt der µ Service nachher in k8s
    # Erlaubt sind nur Buchstaben, beginnt mit Kleinbuchstaben, keine Sonderzeichen
    PROJECT_NAME:
    
    # Name des Images in der Docker Registry ohne Tags
    # Erlaubt sind nur Kleinbuchstaben und Bindestriche
    DOCKER_IMAGE_NAME: 
    
    # Name des µ Services in der URL
    # Die finale URL setzt sich so zusammen: https://k8s.mt-ag.com/artikelsuche/{APPLICATION_PATH}
    APPLICATION_PATH:
```

### In Dein neues git Repository pushen
Nachdem Du Dein µ - Service Projekt in Deinem __GitLab angelegt__ hast, musst Du nur noch das Template pushen:

```
git init
git remote add origin https://git.mt-ag.com/artikelsuche/{service name}
git add *
git commit -m "Initial commit"
git push --set-upstream origin master
```

## Erfolg begutachten
Wenn alles glatt gelaufen ist, solltest du nun folgende Schritte nachvollziehen können
* In Deinem GitLab unter __CI / CD__ sollte die Projektpipeline erscheinen und alle Schritte sollten mit grünen Haken versehen sein.
* Du solltest den Hallo Welt Service in Browser öffnen können, der den Insert in die DB macht ` https://k8s.mt-ag.com/artikelsuche/{APPLICATION_PATH}/greet/CurryWurst`
* Du solltest alle bereits gegrüßten Personen lesen können: ` https://k8s.mt-ag.com/artikelsuche/{APPLICATION_PATH}`
* Du solltest eine bereits gegrüßte Person über ihre ID lesen können ` https://k8s.mt-ag.com/artikelsuche/{APPLICATION_PATH}/{id}`
* Du solltest auf Deinem Grafana Dashboard den Heartbeat des Hallo Welt Services sehen können [https://k8s.mt-ag.com/monitor/grafana/](https://k8s.mt-ag.com/monitor/grafana/d/bqzyoTkZz/presentation-dashboard)
* Du solltest in Deiner Kibana Logging Console [https://k8s.mt-ag.com/monitor/kibana/](https://k8s.mt-ag.com/monitor/kibana/app/kibana#/discover?_g=()&_a=(columns:!(_source),index:'4a7ed900-4bbd-11e9-af6f-8338aa83359b',interval:auto,query:(language:lucene,query:'log:%20%22Service%20greet%20was%20requested%20for%22'),sort:!('@timestamp',desc))) das fachliche Logging des Hallo Welt Services sehen können. Du kannst diese Query verwenden `log: "Service greet was requested for"` 



# Starte das Entwickeln
Nun ist Dein neuer µ Service fest in seiner neuen CD Pipeline eingespannt und Du kannst anfangen zu entwickeln.
Hier noch ein paar Tips, die Dir das lokale Testen etwas leichter machen

## MariaDB in einem Docker Conteinaer lokal starten
Du kannst Dir Deine eigene MariaDB auf Deinem Rechner starten. Die nötigen Verbindungsparameter, die Spring braucht, um sich mit der DB zu verbinden, kannst Du in der `application.yml` eintragen. Die Werte werden beim Deployment in der CI dynamisch ersetzt, so dass sich Deine Applikation mit dem jeweils richtigen Environment verbindet.

### Erster Start den Docker Container mit der MariaDB
`docker run --rm --name mariadb -p 3306:3306 -e MYSQL_ROOT_PASSWORD=mypass -d mariadb/server:10.3`

### Mit der MariaDB verbinden
Du kannst Dich mit der MariaDB direkt verbinden, um den SQL client zu verwenden. Hier ein kleines Beispiel:
1. `docker exec -ti mariadb mysql -u root -p`
1. enter password `mypass`
1. `show databases;`
1. `use jumpstart;`
1. `show tables;`
1. `select * from hello_world_entity;`
1. `exit`

### Datenbank stoppen und starten
* `docker stop mariadb`
* `docker start mariadb`


__Viel Spaß wünscht Dein PENG Team!__



