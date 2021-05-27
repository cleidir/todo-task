# todo-task

This project ofers some RestAPIs to be comsumed by an app than work with tasks.
It's possible create/delete a task and find it too.

### Dependencies

##### Update packages before

Before install this project, you need to install the maven and java 1.14, follow the steps below this.

```
sudo apt update
```
```
sudo apt upgrade
```
Now you can install Java using the command below.

```
sudo apt install openjdk-14-jdk
```
Wait to finish, you can confirm the version installed.
```
java -version
```
Installing maven
```
sudo apt install maven
```
Wait to finish, you can confirm the version installed.
```
mvn -version
```

### Installing

Clone the repository ***git@github.com:cleidir/todo-task.git***

Access the project directory and execute te commands below to install the application.

```
cd todo-task/
```

```
mvn clean install
```
Wait for the end of process, and than run this to execute the app using command below.

```
java -jar -Dapple.awt.UIElement="true" target/todo-task-0.0.1-SNAPSHOT.jar -h
```

After that, the API's are available on adress like the below 

```
http://localhost:8080/api/todoTasks
```