# examples-j2cl
This project contains a webapp where the client and server part are written almost entirely in java making use of bazel and j2cl.

Following key features are demonstrated:
+ bazel
+ j2cl
+ webcomponents (in java)
+ elemental2
+ jsinterop
+ REST
+ jersey2

## Usage
For compilation of the server part and creating a webapp directory switch to the root directory of the project and do

```bazel build //webapp:webapp```

For compilation of the client part and running the client switch to the root directory of the project and do

```bazel run //src/main/java/vruegner/example/j2cl/client:client-app_dev_server```

For running the server, e.g. with tomcat, copy the contents of

```bazel-bin/webapp```

into an empty directory. In

```$TOMCAT_HOME/conf/Catalina/localhost```

create a file

```examples-j2cl.xml```

with the following contents

```
<Context displayName="examples-j2cl"
  docBase="<the directory where you copied bazel-bin/webapp>"
  reloadable="true"
/>
```

and restart tomcat.
