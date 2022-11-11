package com.reactive;

import org.reactivestreams.Subscription;
import reactor.core.Disposable;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        Disposable subscribe = ReactiveSources.intNumbersFlux().subscribe(
                number -> System.out.println(number),
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Complete"));


        // Subscribe to a flux using an implementation of BaseSubscriber
      // Another Way
      //  ReactiveSources.intNumbersFlux().subscribe(new MySubscribe<>());

        System.out.println("Press a key to end");
        System.in.read();
    }

   static class MySubscribe<T> extends BaseSubscriber<T> {
        public void hookOnSubscribe(Subscription subscription) {
            request(1);
            System.out.println("Subscribe is happened");
        }

        public void hookOnNext(T value) {
            System.out.println(value.toString() + ": Received");
            request(3);
        }
    }

}