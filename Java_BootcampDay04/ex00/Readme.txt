mkdir target

javac -d target java/edu.school21.printer/app/Program.java java/edu.school21.printer/logic/ImageConverter.java

java -cp target/ edu.school21.printer.app.Program C:/Users/anton/Desktop/Java/Java_Bootcamp.Day04-1/src/ex00/resources/it.bmp