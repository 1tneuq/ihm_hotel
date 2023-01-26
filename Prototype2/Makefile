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
JAR_PROTOTYPE2 = prototype2.jar

# BUTS FACTICES #
.PHONY : run clean doc

# BUT PAR DEFAUT #
run : ${JAR_PROTOTYPE2}
	${EXEC_JAR} ${JAR_PROTOTYPE2}

# AUTRE BUTS
doc :
	javadoc -d doc src/fr/iutfbleau/projetIHM2021FI2/MODELE/*.java src/fr/iutfbleau/projetIHM2021FI2/VUE/*.java src/fr/iutfbleau/projetIHM2021FI2/CONTROLEUR/*.java

clean :
	rm -rf ${BUILD}/* *.jar

# REGLES DE DEPENDANCE #

## VUE ##
${BUILD}/VUE/Vue.class : ${SRC}/VUE/Vue.java \
	                              ${BUILD}/CONTROLEUR/Controleur.class \
																${BUILD}/VUE/GrapheTaux.class \
																${BUILD}/VUE/Recherche.class \
																${BUILD}/VUE/TauxOccupation.class \
																${BUILD}/VUE/Footer.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/VUE/Vue.java

${BUILD}/VUE/GraphPanneau.class : ${SRC}/VUE/GraphPanneau.java
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/VUE/GraphPanneau.java

${BUILD}/VUE/Recherche.class : ${SRC}/VUE/Recherche.java \
																${BUILD}/VUE/GraphPanneau.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/VUE/Recherche.java

${BUILD}/VUE/Footer.class : ${SRC}/VUE/Footer.java \
																${BUILD}/VUE/GraphPanneau.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/VUE/Footer.java

${BUILD}/VUE/GrapheTaux.class : ${SRC}/VUE/GrapheTaux.java \
																${BUILD}/VUE/GraphPanneau.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/VUE/GrapheTaux.java

${BUILD}/VUE/TauxOccupation.class : ${SRC}/VUE/TauxOccupation.java \
																${BUILD}/VUE/GraphPanneau.class
		${JAVAC} ${JAVAC_OPTIONS} ${SRC}/VUE/TauxOccupation.java




## CONTROLEUR ##
${BUILD}/CONTROLEUR/Controleur.class : ${SRC}/CONTROLEUR/Controleur.java \
																								${BUILD}/VUE/Vue.class \
																								${BUILD}/MODELE/ModeleTaux.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/CONTROLEUR/Controleur.java

## MODELE ##
${BUILD}/MODELE/ModeleTaux.class : ${SRC}/MODELE/ModeleTaux.java \
																${BUILD}/VUE/Vue.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/MODELE/ModeleTaux.java


## MAIN ##
 ${BUILD}/MAIN/Main.class : ${SRC}/MAIN/Main.java \
 														${BUILD}/VUE/Vue.class
	${JAVAC} -Xlint:deprecation ${JAVAC_OPTIONS} ${SRC}/MAIN/Main.java

# ## JARS ##
 ${JAR_PROTOTYPE2} : ${BUILD}/MAIN/Main.class
	${JAR} cvfe ${JAR_PROTOTYPE2} fr.iutfbleau.projetIHM2021FI2.MAIN.Main org/ -C build fr
