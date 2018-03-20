package com.springtutorial.exceptions;

/**
 * Created by agrewal on 3/1/18.
 */
public class S3Exception extends RuntimeException {

    public S3Exception(Throwable e) {
        super(e);
    }

    public S3Exception(String s) {
        super(s);
    }
}
