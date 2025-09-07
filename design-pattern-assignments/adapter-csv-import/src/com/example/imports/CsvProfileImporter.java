package com.example.imports;

import java.nio.file.Path;

public class CsvProfileImporter implements ProfileImporter {
    private final NaiveCsvReader csvReader;
    private final ProfileService profileService;

    public CsvProfileImporter(NaiveCsvReader csvReader, ProfileService profileService) {
        this.csvReader = csvReader;
        this.profileService = profileService;
    }

    @Override
    public int importFrom(Path csvFile) {
        var rows = csvReader.read(csvFile);
        int count = 0;

        for (String[] row : rows) {
            if (row.length >= 2 && !row[0].trim().isEmpty() && !row[1].trim().isEmpty()) {
                try {
                    String id = row[0].trim();
                    String email = row[1].trim();
                    String displayName = row.length > 2 ? row[2].trim() : "";
                    profileService.createProfile(id, email, displayName);
                    count++;
                } catch (Exception e) {
                    System.out.println("Skipped invalid row: " + e.getMessage());
                }
            }
        }
        return count;
    }
}
