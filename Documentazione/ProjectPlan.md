# UnibgParking
## Project Plan
### Progetto di ingegneria del software
Ledio Koci 1085165<br>
Giovanni Nocerino 1086979<br>
Francesco Pezzotta 1086783<br>


## INDICE
1. [Introduzione](#introduzione)
2. [Modello di processo](#Modello_di_processo)
3. [Organizzazione del progetto](#Organizzazione_del_progetto)
4. [Standard, linee guida, procedure](#Standard,linee_guida,procedure)
5. [Attività di gestione](#Attività_di_gestione)
6. [Rischi](#Rischi)
7. [Personale](#Personale)
8. [Metodi e tecniche](#Metodi_e_tecniche)
9. [Garanzia di qualità](#Garanzia_di_qualità)
10. [Pacchetti di lavoro (workpackages)](#Pacchetti_di_lavoro)
11. [Risorse](#Risorse)
12. [Budget e programma](#Budget_e_programma)
13. [Cambiamenti](#Cambiamenti)
14. [Consegna](#Consegna)

## 1. Introduzione

### Il progetto mira a sviluppare un sistema per ottimizzare la gestione dei parcheggi dell'università, ridurre i tempi di ricerca e migliorare l’esperienza utente.

Obiettivi principali:<br>
	- Ottimizzazione degli spazi disponibili.<br>
	- Pagamenti digitali per visitatori occasionali.<br>
	- Sensori e QRCode per il monitoraggio automatizzato.<br>

## 2. Modello di processo

1.	Planning Game: All’inizio della settimana, il team si riunisce per elencare le funzionalità più importanti e chiarire le aspettative e le necessità legate al progetto. In questa fase, si definisce l’ambito del progetto (che rimane sempre flessibile).<br>
2.	Small Releases or Deliveries (Rilasci o consegne frequenti): Alla fine di ogni settimana, si ricevono piccole versioni del progetto da testare e su cui fornire feedback o suggerimenti di miglioramento.<br>
3.	Simple Design (Progettazione semplice): Più il codice e la ricerca dei risultati attesi sono semplici, meglio è. La semplicità deve essere mirata ai risultati e non solo allo sviluppo. Un codice facile da scrivere non sempre rappresenta la soluzione più semplice.<br>
4.	User Testing (Test degli utenti): Fase in cui si testano le versioni rilasciate del prodotto per verificarne la correttezza e suggerire eventuali modifiche o miglioramenti.<br>
5.	Sustainable Pace (Ritmo sostenibile): L’Extreme Programming promuove il rispetto del fattore umano, garantendo motivazione e armonia tra i membri del team.<br>
6.	Collective Ownership (Proprietà collettiva): Il progetto sviluppato deve essere conosciuto e accessibile a tutto il team, senza la necessità di permessi speciali. Questo accelera il processo di sviluppo e ne aumenta la trasparenza, in linea con i principi della gestione visiva (visual management).<br>
7.	Pair Programming (Programmazione in coppia): Due membri lavorano su un singolo computer, garantendo una revisione continua del codice, favorendo l’apprendimento reciproco durante il processo, promuovendo la condivisione della conoscenza delle regole di business ed infine l’equilibrio delle competenze tecniche.<br>
8.	Coding Standard (Standard di codifica): Nel caso dello sviluppo software, il codice deve seguire uno standard comune, in modo che tutti i membri del team utilizzino le stesse regole. L’obiettivo è far sembrare che il codice sia stato scritto da una sola persona, garantendo coerenza e facilità di manutenzione.<br>
9.	Test-Oriented Development (Sviluppo orientato ai test): I test unitari sono essenziali per garantire la qualità del progetto. La pratica prevede di creare prima i test unitari e successivamente il codice necessario per farli funzionare.<br>
10.	Refactoring (Rifattorizzazione): Processo di miglioramento continuo del progetto, volto a rendere il codice più chiaro, con minori possibilità di errori e riducendo la duplicazione di processi o funzioni.<br>
11.	Continuous Integration (Integrazione continua): Le nuove funzionalità devono essere rapidamente integrate nella versione attuale del sistema. Questo consente di eseguire test prima possibile, identificando e risolvendo eventuali problemi in tempi rapidi.<br>

## 3. Organizzazione del progetto

Ciascun membro del gruppo detiene le medesime responsabilità durante tutte le fasi del progetto (quindi progettazione, sviluppo e test), adottando ruoli di tipo Agile, in particolare Extreme Programming (XP); verranno effetuate delle riunioni in modo tale da poter permettere a tutti e tre i membri di confrontarsi sullo sviluppo del progetto e pianificare i prossimi passi da seguire.

## 4. Standard, linee guida, procedure
Content for conclusion...

## 5. Attività di gestione



## 6. Rischi

Nello sviluppo del software si potrebbero verificare diversi rischi, di seguito elencati:

1. Ritardi nel rispetto delle scadenze intermedie: sarà necessario monitorare regolarmente l’avanzamento del progetto.
2. Difficoltà nell’utilizzo di tecnologie e framework non familiari: sarà fondamentale consultare la documentazione ufficiale e risorse online, così come anche farsi consigliare secondo le capacità che ogni membro del team possiede.
3. Assenza di un membro del team per svariate cause: sarà necessario pianificare il lavoro in modo flessibile cosicchè tale che tutti i membri del team possano contribuire allo sviluppo del software alla stessa maniera.
4. Bug non individuati durante il testing: Implementare più casi di test possibili in modo tale da avere una copertura sufficiente.

## 7. Personale

### Vedi capitolo 3.

Di seguito i membri:

- Ledio Koci
- Giovanni Nocerino
- Francesco Pezzotta

## 8. Metodi e tecniche

1.	Identificazione dei requisiti:
   	•	Raccolta delle richieste e analisi del problema, brainstorming.
	•	Scomposizione del problema generale in sotto-problemi più piccoli e affrontabili singolarmente.
3.	Documentazione:
	•	Ogni requisito sarà descritto in un documento di Specifica Requisiti, specificando:
	•	Obiettivo del requisito
	•	Priorità (critico, necessario, opzionale)
	•	Criteri di accettazione
	•	Tracciabilità (collegamento tra requisito e funzionalità corrispondente)
4.	Analisi di fattibilità:
	•	Controllo della fattibilità tecnica e delle risorse necessarie per la realizzazione di ciascun requisito.
	•	Definizione di eventuali compromessi o alternative in caso di difficoltà tecniche.
5.	Revisione e convalida:
	•	Sessioni di revisione con i membri del gruppo per garantire la chiarezza e la coerenza dei requisiti.
	•	Aggiornamento del documento di requisiti per includere eventuali modifiche o nuovi requisiti emersi.

## 9. Garanzia di qualità

La qualità del prodotto sarà garantita tramite controlli regolari e misurazioni oggettive. Verranno utilizzate metriche per valutare la qualità del codice e la soddisfazione dei requisiti.

Tecniche di controllo della qualità:

-	Code Review: ogni modifica sarà sottoposta a revisione tra i membri del team.<br>
-	Misurazione delle metriche di qualità:<br>
-	Copertura del codice (percentuale di righe coperte dai test).<br>
-	Numero di bug rilevati e tempo medio di risoluzione.<br>
-	Complessità ciclomatica per misurare la complessità dei metodi.<br>

Strumenti utilizzati:
-	Strumenti di gestione delle metriche di qualità (GitHub ecc.) per il monitoraggio continuo.<br>

## 10. Pacchetti di lavoro (workpackages)

## 11. Risorse

Risorse umane:
Vedi capitolo 3 e 7.

Software e tool:

- Eclipse: IDE utilizzato per poter lavorare allo sviluppo del progetto (versione 2024-09)
- Papyrus: utile per poter realizzare i diagrammi UML da cui poter generare il codice iniziale
- libreria db: SQLite, permette di poter implementare un database embedded

Per quanto riguarda i dispositivi, il software verrà sviluppato su due sistemi operativi, ovvero:

-MacOS 15.0 Sequoia<br>
-Windows 11<br>

## 12. Budget e programma

Non è previsto alcun budget per lo sviluppo di questo progetto.

L’implementazione sarà organizzata in cicli iterativi per garantire un rilascio graduale e un controllo costante sulla qualità. Ogni iterazione avrà una durata indefinita e porterà alla produzione di una versione funzionante del software.

Fasi principali dello sviluppo:

1.	Pianificazione del ciclo:
	-	Definizione delle funzionalità da sviluppare in ogni ciclo.
	-	Assegnazione delle attività ai membri del team tramite strumenti di gestione.
2.	Scrittura del codice:
	-	Implementazione del codice seguendo le best practice di programmazione.
	-	Revisione del codice (code review) tra i membri del team per ridurre il rischio di errori e migliorare la qualità.
3.	Testing iniziale:
	-	Esecuzione di test manuali e test automatici (unit test) per identificare errori durante la scrittura del codice.
	-	Uso di framework di testing (come JUnit) per i test automatici.
4.	Revisione e correzione:
	-	Correzione dei bug rilevati durante i test.
	-	Verifica finale della versione prima di rilasciarla.

## 13. Cambiamenti

La possibilità di incorrere in cambiamenti imprevisti è possibile, in quanto i rischi (come citato nel capitolo 6 "Rischi") sono pressochè inevitabili. Per questo motivo sarà fondamentale adottare la metodologia Extreme Programming al meglio (vedi capitolo 2 e 3).

## 14. Consegna

Il progetto con relativa documentazione verrà condiviso su GitHub rispettivamente con il Prof. Gargantini e Prof.ssa Bonfanti.
