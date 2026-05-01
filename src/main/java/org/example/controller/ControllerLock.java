package org.example.controller;

import org.example.service.LockSample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/lock")
public class ControllerLock {

    private final LockSample lockSample;
    private final ExecutorService pool = new ThreadPoolExecutor(3, 4, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(20));

    @Autowired
    public ControllerLock(LockSample lockSample) { this.lockSample = lockSample; }

    @PostMapping("/hello")
    public String hello() { return lockSample.hello(); }

    @GetMapping("/deadlock")
    public void deadlock(){
        Object lockA = new Object();
        Object lockB = new Object();

        lockSample.DeadLockSample(lockA, lockB);
    }

    @GetMapping("/reentrantlock")
    public void ReentrantLock(){
        Runnable task = lockSample::reentrantLock;

//      new Thread(task).start();
//      new Thread(task).start();
        pool.submit(task);
        pool.submit(task);
    }

    @PostMapping("/transactionaltestsucess")
    public ResponseEntity<String> TransactionalTestSucess(@RequestBody DoublePersonRequest doublePersonRequest){
        lockSample.transactionalTestSucess(doublePersonRequest.getPerson1(),doublePersonRequest.getPerson2());
        return ResponseEntity.ok("Commited both sucessful");
    }

    @PostMapping("/transactionaltestrollback")
    public ResponseEntity<String> TransactionalTestRollback(@RequestBody DoublePersonRequest doublePersonRequest){
        try{
            lockSample.transactionalTestRollback(doublePersonRequest.getPerson1(), doublePersonRequest.getPerson2());
            return ResponseEntity.ok("should not reach");
        } catch (Exception e){
            return ResponseEntity.ok("Rolled back succesful");
        }
    }

}

//10.208.68.223
