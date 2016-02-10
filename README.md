#Daemon Thread in Java
Daemon thread in java is a service provider thread that provides services to the user thread. Its life depend on the mercy of user threads i.e. when all the user threads dies, JVM terminates this thread automatically.
#Points to remember for Daemon Thread in Java
* It provides services to user threads for background supporting tasks. It has no role in life than to serve user threads.
* Its life depends on user threads.
* It is a low priority thread.
#Definition
Daemon thread in Java are those thread which runs in background and mostly created by JVM for performing background task like Garbage collection and other house keeping tasks. Difference between Daemon and Non Daemon(User Threads)  is also an interesting multi-threading interview question, which asked mostly on fresher level java interviews. In one line main difference between daemon thread and user thread is that as soon as all user thread finish execution java program or JVM terminates itself, JVM doesn't wait for daemon thread to finish there execution. As soon as last non daemon thread finished JVM terminates no matter how many Daemon thread exists or running inside JVM. In this java thread tutorial we will see example of Daemon thread in Java and some more differences between Daemon and non daemon threads

Read more: 
http://www.javatpoint.com/daemon-thread
http://javarevisited.blogspot.com/2012/03/what-is-daemon-thread-in-java-and.html
