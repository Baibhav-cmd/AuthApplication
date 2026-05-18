package com.example.AuthApplicationBackend.exceptions;

public class ResourcesNotFoundException  extends RuntimeException{
    public ResourcesNotFoundException(String message){
        super(message);
    }

    public ResourcesNotFoundException() {
        super("resources not found");
    }
}
