package com.blokura.data;

import com.sun.javafx.beans.annotations.NonNull;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    public FileReader() {
        //Empty used for injection
    }

    public List<String> getStringFromFile(@NonNull String path) throws IOException {

        final InputStream stream = new FileInputStream(path);
        return getStringFromStream(stream);
    }

    private List<String> getStringFromStream(final InputStream input) throws IOException {
        final InputStreamReader isr = new InputStreamReader(input);
        final BufferedReader bufferedReader = new BufferedReader(isr);
        List<String> result = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            result.add(line);
        }
        bufferedReader.close();
        isr.close();
        return result;
    }
}
