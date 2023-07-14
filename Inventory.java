package smt2;


import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Inventory {
    private final Tokopedia[] data;

    public Inventory(Tokopedia[] data) {
        this.data = data;
    }

    public void tampilkanData() {
        System.out.println("Data Inventory:");
        for (Tokopedia barang : data) {
            System.out.println(barang.getNama());
        }
    }

    public void sortData() {
        int n = data.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (data[j].getNama().compareTo(data[j + 1].getNama()) > 0) {
                    Tokopedia temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    public String[] cariRincian(String keyword) {
        String[] hasilPencarian = new String[data.length];
        int count = 0;

        for (Tokopedia barang : data) {
            String[] rincian = barang.getRincian();
            int[] harga = barang.getHarga();
            for (int i = 0; i < rincian.length; i++) {
                if (rincian[i].toLowerCase().contains(keyword.toLowerCase())) {
                    DecimalFormat decimalFormat = new DecimalFormat("#,###");
                    String hargaFormatted = decimalFormat.format(harga[i]);
                    hasilPencarian[count] = rincian[i] + " harga Rp" + hargaFormatted + "/pcs";
                    count++;
                }
            }
        }

        return Arrays.copyOf(hasilPencarian, count);
    }

    public static void main(String[] args) {
        Tokopedia[] dataBarang = {
                new Tokopedia("Pensil", new String[]{"Pensil Greebel", "Pensil 2B", "Pensil Faber Castel", "Pensil Warna"},
                        new int[]{2000, 2500, 3500, 30000}),
                new Tokopedia("Pulpen", new String[]{"Pulpen Joyko", "Pulpen Kenko", "Pulpen 4 Warna"},
                        new int[]{4500, 3500, 6000}),
                new Tokopedia("Jaket", new String[]{"Jaket Denim", "Jaket Levis", "Jaket Bomber", "Jaket Motor"},
                        new int[]{125000, 250000, 456500, 118000}),
                new Tokopedia("Celana", new String[]{"Celana Chinos", "Celana Bogo", "Celana Bahan"},
                        new int[]{94500, 62000, 114000}),
                new Tokopedia("Kaos", new String[]{"Kaos Polos", "Kaos Bola", "Kaos Uniqlo"},
                        new int[]{30500, 56000, 150500})
        };

        Inventory inventory = new Inventory(dataBarang);
        inventory.sortData();
        inventory.tampilkanData();

        Scanner scanner = new Scanner(System.in);
        String choice;
        do {
            System.out.print("\nMasukkan kata kunci untuk mencari barang rinci: ");
            String keyword = scanner.nextLine();

            String[] hasilPencarian = inventory.cariRincian(keyword);
            if (hasilPencarian.length > 0) {
                System.out.println("\nHasil pencarian rincian barang berdasarkan kata kunci: " + keyword);
                for (String rincian : hasilPencarian) {
                    if (rincian != null) {
                        System.out.println(rincian);
                    }
                }
            } else {
                System.out.println("\nTidak ditemukan rincian barang yang sesuai dengan kata kunci: " + keyword);
            }

            System.out.print("\nCari barang lagi? (y/n): ");
            choice = scanner.nextLine();
        } while (choice.equalsIgnoreCase("y"));
    }
}
