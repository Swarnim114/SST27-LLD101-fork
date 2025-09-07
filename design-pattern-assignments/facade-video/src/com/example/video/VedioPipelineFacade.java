package com.example.video;

import java.nio.file.Path;
import java.util.Objects;

public class VedioPipelineFacade {
    private final Decoder decoder;
    private final FilterEngine filterEngine;
    private final Encoder encoder;
    private final SharpenAdapter sharpenAdapter;

    public VedioPipelineFacade() {
        this.decoder = new Decoder();
        this.filterEngine = new FilterEngine();
        this.encoder = new Encoder();
        this.sharpenAdapter = new SharpenAdapter(new LegacySharpen());
    }

    public Path process(Path src, Path out, boolean gray, Double scale, Integer sharpenStrength) {
        Objects.requireNonNull(src, "src");
        Objects.requireNonNull(out, "out");

        // Decode
        Frame[] frames = decoder.decode(src);

        // Optional grayscale
        if (gray) {
            frames = filterEngine.grayscale(frames);
        }

        // Optional scale
        if (scale != null) {
            frames = filterEngine.scale(frames, scale);
        }

        // Optional sharpen
        if (sharpenStrength != null) {
            frames = sharpenAdapter.sharpen(frames, sharpenStrength);
        }

        // Encode
        return encoder.encode(frames, out);
    }
}
