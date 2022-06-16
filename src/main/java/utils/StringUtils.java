package utils;

import org.apache.commons.lang3.RandomStringUtils;

public class StringUtils {

    public static String getRandomEmail(int count) {
        return String.format("%s@gmail.com", RandomStringUtils.randomAlphanumeric(count));
    }

    public static String getRandomNumeric(int count) {
        return RandomStringUtils.randomNumeric(count);
    }

    public static String getRandomAlphanumeric(int count) {
        return RandomStringUtils.randomAlphanumeric(count);
    }
}
