package com.ogokilearning.libraryquickbuild;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample description for user interfaces created by
 * Android template wizards.
 * <p>
 */
public class CreditInformation {

    private static String[] creditTitle = new String[] {

    };

    private static String[] creditDescription = new String[] {



    };

    /**
     * An array of sample (dummy) items.
     * These will generate on their own with the following code
     */
    public static final List<CreditItem> ITEMS = new ArrayList<CreditItem>();

    /**
     * A map of credit items, by ID.
     */
    private static final Map<String, CreditItem> ITEM_MAP = new HashMap<String, CreditItem>();

    static {
        // Add some sample items.
        for (int i = 0; i < creditTitle.length; i++) {
            addItem(createCredit(i));
        }
    }

    private static void addItem(CreditItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static CreditItem createCredit(int position) {
        return new CreditItem(String.valueOf(position),  creditTitle[position], creditDescription[position]);
    }



    /**
     * A dummy item representing a piece of description.
     */
    public static class CreditItem {
        public final String id;
        public final String title;
        public final String description;

        public CreditItem(String id, String title,  String description ) {
            this.id = id;
            this.title = title;

            this.description = description;
        }

        @Override
        public String toString() {
            return description;
        }

    }
}
