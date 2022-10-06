FROM openjdk:17.0.2-jdk
WORKDIR /app
ADD ./ProjetoGuiado/Clinica/target/clinica-0.0.2-Anderson.jar /app
ENTRYPOINT ["java", "-jar", "clinica-0.0.2-Anderson.jar"]

#docker image build -t nidio/nomedaimagem .

#docker container run -d -p 9000:9000 clinica

#docker tag clinica nidio/clinica

#docker push nidio/clinica
