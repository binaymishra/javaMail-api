
java -cp build/classes/java/main/ bm.api.javamail.App

./gradlew wrapper --gradle-version 5.6.4


https://stackoverflow.com/questions/20700053/how-to-add-local-jar-file-dependency-to-build-gradle-file

 // This dependency is from libs/ folder 
 compile fileTree(dir: 'libs', include: ['*.jar'])

 https://stackoverflow.com/questions/4871656/using-gradle-to-build-a-jar-with-dependencies