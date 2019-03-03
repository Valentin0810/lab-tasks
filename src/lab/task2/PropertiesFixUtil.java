package lab.task2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PropertiesFixUtil {

    private static Set<Path> pathsProperties = new HashSet<>();
    private static Set<Path> pathsJavaFiles = new HashSet<>();
    private static Set<String> oldKeys = new HashSet<>();

    public static void startFixUtil(String pathToPropertyFolder, String pathToProjectFolder) {
        searchPropertyFile(pathToPropertyFolder);
        if (pathsProperties.isEmpty()) {
            System.out.println("There are no files with properties");
        } else {
            for (Path path : pathsProperties) {
                for (String line : readPropertyToList(path.toString())) {
                    oldKeys.add(getWrongKey(line));
                    changeFile(path.toString());
                }
            }
        }
        findJavaFiles(pathToProjectFolder);
        if (pathsJavaFiles.isEmpty()) {
            System.out.println("There are no java files");
        } else {
            for (Path path : pathsJavaFiles
                    ) {
                changeFile(path.toString());
            }
        }
    }

    private static void findJavaFiles(String pathToJavaFiles) {
        Path startingDir = Paths.get(pathToJavaFiles);
        try {
            Files.walkFileTree(startingDir, new FindJavaVisitor());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String keyFix(String key) {
        return key.toLowerCase().replace("_", ".");
    }

    private static String getWrongKey(String lineContentProperties) {
        String key = "";
        Pattern regex = Pattern.compile("(^[A-Z_]+)");
        Matcher matcher = regex.matcher(lineContentProperties);
        while (matcher.find()) {
            key = matcher.group();
        }
        return key;
    }

    private static String changeKeyInContent(Set<String> oldKeys, String lineContent) {
        for (String key : oldKeys) {
            if (lineContent.contains(key)) {
                lineContent = lineContent.replaceAll(key, keyFix(key));
            }
        }
        return lineContent;
    }

    private static void changeFile(String path) {
        Path path2 = Paths.get(path);
        try {
            String content = new String(Files.readAllBytes(path2));
            content = changeKeyInContent(oldKeys, content);
            Files.write(path2, content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Collection<String> readPropertyToList(String path) {
        List<String> contentProperties = null;
        try {
            contentProperties = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
            for (String line : contentProperties) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentProperties;
    }

    private static void searchPropertyFile(String pathToPropertiesFolder) {
        Path dir = Paths.get(pathToPropertiesFolder);
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.properties")) {
            for (Path entry : stream) {
                pathsProperties.add(entry);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static class FindJavaVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (file.toString().endsWith(".java")) {
                pathsJavaFiles.add(file);
            }
            return FileVisitResult.CONTINUE;
        }
    }
}