package avi.app;

import avi.utils.AppUtil;

import java.io.IOException;
import java.util.stream.Stream;

public class MainApplication {
    public static void main(String[] args) {
        try {
            Stream<String> lines = AppUtil.getInputLines("./src/main/resources/prospects.txt");

            lines.skip(1)
                    .filter(line ->!line.isBlank())
                    .forEach(line -> AppUtil.showDetails(line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)")));

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

}
