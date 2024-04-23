mkdir target

javac -d target java/edu.school21.printer/*/*.java 

mkdir -p target/resources

cp resources/* target/resources/

cd target

jar -cvfm images-to-chars-printer.jar ./target/manifest.MF .

java -jar images-to-chars-printer.jar