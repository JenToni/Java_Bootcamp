#Содаем папки 
mkdir target && mkdir lib

#Скачиваем библиотеки, которые нужны для работы
curl https://repo1.maven.org/maven2/com/beust/jcommander/1.82/jcommander-1.82.jar -o lib/jcommander-1.82.jar
curl https://repo1.maven.org/maven2/com/diogonunes/JColor/5.5.1/JColor-5.5.1.jar -o lib/JColor-5.5.1.jar

#Извлечение содержимого jar 
cd ./target
jar xf ../lib/jcommander-1.82.jar
jar xf ../lib/JColor-5.5.1.jar
cd ..

#Компилируем библиотеки и наши файлы

javac -d target -sourcepath java -cp lib/\* java/edu.school21.printer/app/Program.java java/edu.school21.printer/logic/*.java

#Копируем resources
cp -R resources target/

#Создаём jar файл
c - создать новый архив
f - имя jar файла
m - указываем муть к файлу manifest
-С - переход в директорию target и включение всех файлов и поддиректорий
jar cfm  ./target/images-to-chars-printer.jar manifest.txt -C target .

#Запускаем
java -jar target/images-to-chars-printer.jar --white=RED --black=GREEN