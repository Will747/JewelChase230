package com.example.jewelchase230;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Scanner;

/**
 * For storing configs that need reading and saving from
 * a basic text file. Saves any non-static fields that are
 * part or the class and allows for fields to be added and
 * removed without causing errors when the config file is
 * read back in.
 * Only supports the following generic fields:
 * - int
 * - double
 * - boolean
 * - string
 *
 * @author Will Kaye
 */
public abstract class Config {
    /**
     * Constructs a new config.
     *
     * @param filePath The file path and name to the config file.
     */
    public Config(final String filePath) {
        read(filePath);
    }

    /**
     * Saves the current state of this class to the config file.
     *
     * @param filePath The file path and name to the config file.
     */
    protected void write(final String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath);
            Field[] fields = getClass().getDeclaredFields();

            for (Field field : fields) {
                int modifiers = field.getModifiers();

                if (!Modifier.isStatic(modifiers)) {
                    String fieldName = field.getName();
                    field.setAccessible(true);
                    String fieldValue = field.get(this).toString();

                    writer.write(fieldName + "=" + fieldValue + "\n");
                }
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Failed to save settings!");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Reads the settings from the config file and sets all fields.
     *
     * @param filePath The file path and name to the config file.
     */
    private void read(final String filePath) {
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            Field[] fields = getClass().getDeclaredFields();

            while (scanner.hasNextLine()) {
                String[] fieldData = scanner.nextLine().split("=");
                if (fieldData.length == 2) {
                    Field field = null;
                    // Find field
                    int i = 0;
                    while (i < fields.length && field == null) {
                        if (fieldData[0].equals(fields[i].getName())) {
                            field = fields[i];
                        }
                        i++;
                    }

                    // Set field
                    if (field != null) {
                        field.setAccessible(true);
                        Type type = field.getGenericType();
                        String typeName = type.getTypeName();
                        if (typeName.equals(int.class.getName())) {
                            field.set(this, Integer.parseInt(fieldData[1]));
                        } else if (typeName.equals(boolean.class.getName())) {
                            field.set(this, Boolean.valueOf(fieldData[1]));
                        } else if (typeName.equals(double.class.getName())) {
                            field.set(this, Double.valueOf(fieldData[1]));
                        } else {
                            field.set(this, fieldData[1]);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Failed to read settings!");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
