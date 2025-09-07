package com.example.video;

import java.nio.file.Path;

public class App {
    public static void main(String[] args) {
        VedioPipelineFacade facade = new VedioPipelineFacade();
        Path out = facade.process(
                Path.of("in.mp4"), // source
                Path.of("out.mp4"), // output
                true, // grayscale
                0.5, // scale factor
                3 // sharpen strength
        );
        System.out.println("Wrote " + out);
    }
}
