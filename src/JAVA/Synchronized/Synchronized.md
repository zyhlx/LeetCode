# Synchronized

## synchronized锁
synchronized的底层是使用操作系统的mutex lock实现的。

synchronized用的锁是存在Java对象头里的。

JVM基于进入和退出Monitor对象来实现方法同步和代码块同步。代码块同步是使用monitorenter和monitorexit指令实现的，monitorenter指令是在编译后插入到同步代码块的开始位置，而monitorexit是插入到方法结束处和异常处。任何对象都有一个monitor与之关联，当且一个monitor被持有后，它将处于锁定状态。

根据虚拟机规范的要求，在执行monitorenter指令时，首先要去尝试获取对象的锁，如果这个对象没被锁定，或者当前线程已经拥有了那个对象的锁，把锁的计数器加1；相应地，在执行monitorexit指令时会将锁计数器减1，当计数器被减到0时，锁就释放了。如果获取对象锁失败了，那当前线程就要阻塞等待，直到对象锁被另一个线程释放为止。

注意两点：

* 1、synchronized同步快对同一条线程来说是可重入的，不会出现自己把自己锁死的问题；

* 2、同步块在已进入的线程执行完之前，会阻塞后面其他线程的进入。

## Mutex Lock
监视器锁（Monitor）本质是依赖于底层的操作系统的Mutex Lock（互斥锁）来实现的。每个对象都对应于一个可称为" 互斥锁" 的标记，这个标记用来保证在任一时刻，只能有一个线程访问该对象。

互斥锁：用于保护临界区，确保同一时间只有一个线程访问数据。对共享资源的访问，先对互斥量进行加锁，如果互斥量已经上锁，调用线程会阻塞，直到互斥量被解锁。在完成了对共享资源的访问后，要对互斥量进行解锁。

**mutex的工作方式**：

 ![image.png](https://pic4.zhimg.com/80/v2-ba0c5a802bc7c45d3add8214ad6f1eaf_720w.jpg)
 
 * 1) 申请mutex
 * 2) 如果成功，则持有该mutex
 * 3) 如果失败，则进行spin自旋. spin的过程就是在线等待mutex, 不断发起mutex gets, 直到获得mutex或者达到spin_count限制为止
 4) 依据工作模式的不同选择yiled还是sleep
 5) 若达到sleep限制或者被主动唤醒或者完成yield, 则重复1)~4)步，直到获得为止