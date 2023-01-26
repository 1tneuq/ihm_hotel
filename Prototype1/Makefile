# COMMANDES #
JAVAC = javac
# note $$ to get a single shell $
JAVAC_OPTIONS = -d build -cp ${MARIA}:build:$$CLASSPATH -implicit:none -sourcepath src
JAVA = java
JAR = jar
EXEC_JAR = ${JAVA} -jar

# CHEMINS RELATIFS
SRC = src/fr/iutfbleau/projetIHM2021FI2
BUILD = build/fr/iutfbleau/projetIHM2021FI2
DOC = doc/fr/iutfbleau/projetIHM2021FI2
MARIA = build/org/mariadb/jdbc/

# CHOIX NOMS
JAR_PROTOTYPE1 = prototype1.jar

# BUTS FACTICES #
.PHONY : run clean doc

# BUT PAR DEFAUT #
run : ${JAR_PROTOTYPE1}
	${EXEC_JAR} ${JAR_PROTOTYPE1}

# AUTRE BUTS
doc :
	javadoc -d doc src/fr/iutfbleau/projetIHM2021FI2/API/*.java src/fr/iutfbleau/projetIHM2021FI2/VUE/*.java

clean :
	rm -rf ${BUILD}/* *.jar

# REGLES DE DEPENDANCE #

## VUE ##
${BUILD}/VUE/Vue.class : ${SRC}/VUE/Vue.java \
	                              ${BUILD}/CONTROLEUR/ControleurRecherche.class \
																${BUILD}/CONTROLEUR/ControleurPrereservation.class \
																${BUILD}/CONTROLEUR/ControleurValidation.class \
																${BUILD}/VUE/Recherche.class \
																${BUILD}/VUE/PrereservationPanneau.class \
																${BUILD}/VUE/Equivalent.class \
																${BUILD}/VUE/Validation.class \
																${BUILD}/VUE/GraphPanneau.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/VUE/Vue.java

${BUILD}/VUE/GraphPanneau.class : ${SRC}/VUE/GraphPanneau.java
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/VUE/GraphPanneau.java

${BUILD}/VUE/Recherche.class : ${SRC}/VUE/Recherche.java \
																${SRC}/VUE/GraphPanneau.java
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/VUE/Recherche.java

${BUILD}/VUE/PrereservationPanneau.class : ${SRC}/VUE/PrereservationPanneau.java \
																	${BUILD}/VUE/GraphPanneau.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/VUE/PrereservationPanneau.java

${BUILD}/VUE/Equivalent.class : ${SRC}/VUE/Equivalent.java \
																	${BUILD}/VUE/GraphPanneau.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/VUE/Equivalent.java

${BUILD}/VUE/Validation.class : ${SRC}/VUE/Validation.java \
																	${BUILD}/VUE/GraphPanneau.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/VUE/Validation.java


## CONTROLEUR ##
${BUILD}/CONTROLEUR/ControleurRecherche.class : ${SRC}/CONTROLEUR/ControleurRecherche.java \
																								${BUILD}/VUE/Vue.class \
																								${BUILD}/MODELE/Modele.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/CONTROLEUR/ControleurRecherche.java

${BUILD}/CONTROLEUR/ControleurPrereservation.class : ${SRC}/CONTROLEUR/ControleurPrereservation.java \
																									${BUILD}/VUE/Vue.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/CONTROLEUR/ControleurPrereservation.java

${BUILD}/CONTROLEUR/ControleurValidation.class : ${SRC}/CONTROLEUR/ControleurValidation.java \
																									${BUILD}/VUE/Vue.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/CONTROLEUR/ControleurValidation.java


## MODELE ##
${BUILD}/MODELE/Modele.class : ${SRC}/MODELE/Modele.java \
															 ${BUILD}/MODELE/ModelePrereservationFactory.class\
															 ${BUILD}/MODELE/ModelePrereservation.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/MODELE/Modele.java

${BUILD}/MODELE/ModelePrereservationFactory.class : ${SRC}/MODELE/ModelePrereservationFactory.java \
																										${BUILD}/MODELE/ModelePrereservation.class \
																										${BUILD}/API/PrereservationFactory.class \
																										${BUILD}/API/TypeChambre.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/MODELE/ModelePrereservationFactory.java

${BUILD}/MODELE/ModelePrereservation.class : ${SRC}/MODELE/ModelePrereservation.java \
																						 ${BUILD}/MODELE/ModeleClient.class\
																						 ${BUILD}/MODELE/PasDePrereservationException.class\
																						 ${BUILD}/API/TypeChambre.class \
																						 ${BUILD}/API/Prereservation.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/MODELE/ModelePrereservation.java

${BUILD}/MODELE/ModeleClient.class : ${SRC}/MODELE/ModeleClient.java \
																		 ${BUILD}/API/Client.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/MODELE/ModeleClient.java

${BUILD}/MODELE/PasDePrereservationException.class : ${SRC}/MODELE/PasDePrereservationException.java
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/MODELE/PasDePrereservationException.java

	## API ##
${BUILD}/API/PrereservationFactory.class : ${SRC}/API/PrereservationFactory.java \
																					 ${BUILD}/API/Prereservation.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/API/PrereservationFactory.java

${BUILD}/API/Prereservation.class : ${SRC}/API/Prereservation.java \
																	  ${BUILD}/API/Client.class\
																	  ${BUILD}/API/TypeChambre.class \
																	  ${BUILD}/API/MonPrint.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/API/Prereservation.java

${BUILD}/API/MonPrint.class : ${SRC}/API/MonPrint.java
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/API/MonPrint.java

${BUILD}/API/Client.class : ${SRC}/API/Client.java
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/API/Client.java

${BUILD}/API/TypeChambre.class : ${SRC}/API/TypeChambre.java
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/API/TypeChambre.java

## MAIN ##
 ${BUILD}/MAIN/Main.class : ${SRC}/MAIN/Main.java \
 														${BUILD}/VUE/Vue.class
	${JAVAC} -Xlint:deprecation ${JAVAC_OPTIONS} ${SRC}/MAIN/Main.java

# ## JARS ##
 ${JAR_PROTOTYPE1} : ${BUILD}/MAIN/Main.class
	${JAR} cvfe ${JAR_PROTOTYPE1} fr.iutfbleau.projetIHM2021FI2.MAIN.Main org/ -C build fr
