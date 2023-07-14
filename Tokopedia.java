package smt2;

public class Tokopedia {
    private final String nama;
    private final String[] rincian;
    private final int[] harga;

    public Tokopedia(String nama, String[] rincian, int[] harga) {
        this.nama = nama;
        this.rincian = rincian;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public String[] getRincian() {
        return rincian;
    }

    public int[] getHarga() {
        return harga;
    }

    @Override
    public String toString() {
        return "Tokopedia{" +
                "nama='" + nama + '\'' +
                '}';
    }
}
