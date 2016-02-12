#Thread Join

Java Thread join method can be used to pause the current thread execution until unless the specified thread is dead. There are three overloaded join functions.

public final void join(): This method puts the current thread on wait until the thread on which it’s called is dead. If the thread is interrupted, it throws InterruptedException.

public final synchronized void join(long millis): This method is used to wait for the thread on which it’s called to be dead or wait for specified milliseconds. Since thread execution depends on OS implementation, it doesn’t guarantee that the current thread will wait only for given time.

public final synchronized void join(long millis, int nanos): This method is used to wait for thread to die for given milliseconds plus nanoseconds.

read more : 
http://www.journaldev.com/1024/java-thread-join-example-with-explanation