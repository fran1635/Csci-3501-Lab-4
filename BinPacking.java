import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class BinPacking {
    private static Scanner scanner = new Scanner(System.in); // Create a single Scanner instance for user input

    public static void main(String[] args) {

        PackItems(8, 20); // Example usage with 8 items and a bin capacity of 20

    }

    // Method to pack items into bins
    public static void PackItems(int n, int binCapacity) {
        // Prompt user for item sizes input should be in the format of space-separated integers ex. (10 15 5 7 8 12 3 6)
        System.out.println("Enter " + n + " integers in the format of space-separated values:");
        int[] items = new int[n];
        for (int k = 0; k < n; k++) {
            items[k] = scanner.nextInt();
        }

        // Create 3 bins to pack the items into
        ArrayList<Integer> Bin1 = new ArrayList<>();
        ArrayList<Integer> Bin2 = new ArrayList<>();
        ArrayList<Integer> Bin3 = new ArrayList<>();
        // Pack items into bins using a nested for loop that goes through each item and checks if it can fit into any of the bins. If it can, it adds the item to the bin and marks the item as packed by setting its value to 0. 
        // If it cannot fit into any bin, it prints a message indicating that the item does not fit in any bin.
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (items[i] <= binCapacity - (j == 0 ? GetBinSize(Bin1) : (j == 1 ? GetBinSize(Bin2) : GetBinSize(Bin3)))) {
                    System.out.println("Placing item of size " + items[i] + " into bin " + (j + 1));
                    switch (j) {
                        case 0:
                            Bin1.add(items[i]);
                            break;
                        case 1:
                            Bin2.add(items[i]);
                            break;
                        case 2:
                            Bin3.add(items[i]);
                            break;
                    }
                    items[i] = 0; // Mark item as packed
                    break;
                } else {
                    System.out.println("Item of size " + items[i] + " does not fit in bin " + (j + 1));
                }
            }
        }
        System.out.println("Items in Bin 1:" + Bin1);
        System.out.println("Items in Bin 2:" + Bin2);
        System.out.println("Items in Bin 3:" + Bin3);
        System.out.println("Non-Zero numbers are the unpacked items:" + Arrays.toString(items));
        System.out.println("total unused space in all bins: " + (binCapacity - GetBinSize(Bin1) + binCapacity - GetBinSize(Bin2) + binCapacity - GetBinSize(Bin3)));
    }

    private static int GetBinSize(ArrayList<Integer> bin) {
        int size = 0;
        for (int item : bin) {
            size += item;
        }
        return size;
    }
}
