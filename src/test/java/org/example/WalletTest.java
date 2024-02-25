package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {

    @Test
    void testSetOwner() {
        Wallet wallet = new Wallet("Verlino");
        wallet.setOwner("fajri");

        Assertions.assertEquals("fajri", wallet.owner);
    }

    @Test
    void testTambahKartu() {
        Wallet wallet = new Wallet("Verlino");
        wallet.tambahKartu("BNI");
        wallet.tambahKartu("BCA");

        String[] expected = {"BNI", "BCA"};

        Assertions.assertArrayEquals(expected, wallet.listKartu.toArray());
    }

    @Test
    void testAmbilKartu() {
        Wallet wallet = new Wallet("Verlino");
        wallet.tambahKartu("BNI");
        wallet.tambahKartu("BCA");

        String[] expected = {"BCA"};
        Assertions.assertAll(
                () -> assertEquals("BNI", wallet.ambilKartu("BNI")),
                () -> assertArrayEquals(expected, wallet.listKartu.toArray())
        );
    }

    @Test
    void testAmbilKartuNoData() {
        Wallet wallet = new Wallet("Verlino");
        wallet.tambahKartu("BNI");
        wallet.tambahKartu("BCA");

        Assertions.assertAll(
                () ->  assertNull(wallet.ambilKartu("BRI"))
        );
    }

    @Test
    void testTambahUangRupiah() {
        Wallet wallet = new Wallet("Verlino");
        //Uang Kertas
        wallet.tambahUangRupiah(1500);
        wallet.tambahUangRupiah(2500);
        //Uang Koin
        wallet.tambahUangRupiah(500);
        wallet.tambahUangRupiah(300);

        Integer[] expectedKertas = {1500, 2500};
        Integer[] expectedKoin = {500, 300};

        Assertions.assertArrayEquals(expectedKertas, wallet.listUangLembaran.toArray());
        Assertions.assertArrayEquals(expectedKoin, wallet.listUangKoin.toArray());
    }

    @Test
    void testTambahUangMines() {
        Wallet wallet = new Wallet("Verlino");
        //Cek input kalo mines
        Assertions.assertThrows(Error.class, () -> wallet.tambahUangRupiah(-500));
    }

    @Test
    void testAmbilUang() {
        Wallet wallet1 = new Wallet("Verlino Fajri");
        wallet1.tambahUangRupiah(500);
        wallet1.tambahUangRupiah(300);
        wallet1.tambahUangRupiah(1500);
        wallet1.tambahUangRupiah(2500);

        //Check standard output
        Assertions.assertEquals(500, wallet1.ambilUang(500));
        Integer[] expectedKoin = {300};
        Assertions.assertArrayEquals(expectedKoin, wallet1.listUangKoin.toArray());

        //Check properti Wallet
        Integer[] expectedLembaran = {1500, 2500};
        Assertions.assertArrayEquals(expectedLembaran, wallet1.listUangLembaran.toArray());
    }

    @Test
    void testAmbilUangKosong() {
        Wallet wallet1 = new Wallet("Verlino Fajri");

        Assertions.assertEquals(0, wallet1.ambilUang(500));
    }

    @Test
    void testTampilkanUang() {
        Wallet wallet1 = new Wallet("Verlino Fajri");
        wallet1.tambahUangRupiah(500);
        wallet1.tambahUangRupiah(1500);
        wallet1.tambahUangRupiah(2500);

        Assertions.assertEquals(4500, wallet1.tampilkanUang());
    }

    @Test
    void testTampilkanUangKosong() {
        Wallet wallet2 = new Wallet("Fajri");
        Assertions.assertEquals(0, wallet2.tampilkanUang());
    }
}