package org.example.service;

import org.example.entity.Person;
import org.example.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class LockSample extends LockSampleAbstract {

    @Override
    public void DeadLockSample(Object lockA, Object lockB) {
        Thread t1 = new Thread(() -> {
            synchronized (lockA) {
                //try to acquire lock A associated with object lockA; and HOLD it until you leave the block
                //if another thread already owns it, wait free
                System.out.println("Thread 1: acquired lock A");
                try{Thread.sleep(100);} catch (InterruptedException e){}
                //to wait at least this amount of time before continuing
                //explain: since thread 2 takes lock b when thread 1 sleep, thus lockB is locked, thus cannot continue
                // ** if thread.sleep is removed, it is MORE LIKELY (NOT for sure) that thread 1 takes lock b before thread 2
                synchronized (lockB) {
                    System.out.println("Thread 1: acquired lock B");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lockB) {
                System.out.println("Thread 2: acquired lock B");
                try{Thread.sleep(100);} catch (InterruptedException e) {}
                synchronized (lockA) {
                    System.out.println("Thread 2: acquired lock A");
                }
            }
        });

        t1.start();
        t2.start();
    }

    private final ReentrantLock reentrantLock = new ReentrantLock();

    public void reentrantLock() {
        // gives more control
        try {
            if(reentrantLock.tryLock(10, TimeUnit.MILLISECONDS)) {
                try {
                    System.out.println(Thread.currentThread().getName() + "got the lock");
                    Thread.sleep(10000);
                } finally {
                    reentrantLock.unlock();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + "COULD NOT get lock");
            }
        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public LockSample(PersonRepository personRepository) {
        super(personRepository);
    }

    @Transactional
    public void transactionalTestSucess(Person person1, Person person2) {
        super.transactionalTestSucess(person1, person2);
    }

    @Transactional
    public void transactionalTestRollback(Person person1, Person person2) {
        super.transactionalTestRollback(person1, person2);
    }

}
