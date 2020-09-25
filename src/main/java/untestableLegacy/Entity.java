package untestableLegacy;

/*
 * This code has been extracted from OpenbravoERP:
 * https://code.openbravo.com/erp/stable/2.50-bp/file/cec9b1da72ed/src/org/openbravo/base/model/Entity.java
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Entity {
    private static final Set<Character> ILLEGAL_ENTITY_NAME_CHARS = new HashSet<>(Arrays.asList('*', '?'));
    private String name;
    public Log log = new Log();

    public void setName(String name) {
        // repair the name if it contains any illegal character
        this.name = removeIllegalChars(name);
    }

    public String removeIllegalChars(String name) {
        final char[] chars = name.toCharArray();
        final StringBuilder newName = new StringBuilder();
        for (char c : chars) {
            if (!hasIllegalChar(c)) {
                newName.append(c);
            }
        }
        if (!name.equals(newName.toString())) {
            log.warn("The entity name " + name
                    + " contains illegal characters, it has been repaired to " + newName);
        } else {
            // check for other less normal characters
            for (char c : name.trim().toCharArray()) {
                final boolean normalChar = ('A' <= c && c <= 'Z') || ('0' <= c && c <= '9')
                        || ('a' <= c && c <= 'z') || c == '_';
                if (!normalChar) {
                    log.warn("The entity name " + name + " contains a character (" + c
                            + ") which could result in issues in HQL or "
                            + "webservices. Use characters from a to z, A to Z or 0 to 9 or the _");
                }
            }
        }
        return newName.toString();
    }

    private boolean hasIllegalChar(char c) {
        return ILLEGAL_ENTITY_NAME_CHARS.contains(c);
    }


}
