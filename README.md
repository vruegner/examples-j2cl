## examples-j2cl
This project contains a webapp where the client and server part are written almost entirely in java making use of bazel and j2cl.

Following key features are demonstrated:
+ bazel
+ j2cl
+ webcomponents (in java)
+ elemental2
+ jsinterop
+ REST
+ jersey2
+ war

## Usage
For compilation of the server part switch to the root directory of the project and do

```
bazel build //webapp:webapp
```
Then deploy the file

```
bazel-bin/webapp/examples-j2cl.war
```

to your servlet container.

For compilation of the client part and running the client switch to the root directory of the project and do

```
bazel run //src/main/java/vruegner/example/j2cl/client:client-app_dev_server
```

Point your webbrowser to the URL displayed from the last command.

You should see two boxes, one for data from the client and the other one for data loaded from the server via a REST call.
Both boxes are an instance of the webcomponent ```LocationWC```.
