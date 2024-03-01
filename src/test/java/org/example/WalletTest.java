package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WalletTest {

    private ArrayList<Wallet> listWallet;

    @BeforeAll
    void setUpClass() {
        listWallet = new ArrayList<Wallet>();
    }

    @AfterAll
    void cleanUpClass() {
        listWallet.clear();
    }

    @BeforeEach
    void setUpMethod() {
        Wallet wallet = new Wallet("Verlino");
        listWallet.add(wallet);
    }

    @AfterEach
    void cleanUpMethod() {
        listWallet.clear();
    }

    @Test
    void testSetOwner() {
        Wallet wallet = listWallet.get(0);
        wallet.setOwner("fajri");

        Assertions.assertEquals("fajri", wallet.owner);
    }

    @Test
    void testTambahKartu() {
        Wallet wallet = listWallet.get(0);

        wallet.tambahKartu("BNI");
        wallet.tambahKartu("BCA");

        String[] expected = {"BNI", "BCA"};

        Assertions.assertArrayEquals(expected, wallet.listKartu.toArray());
    }

    @Test
    void testAmbilKartu() {
        Wallet wallet = listWallet.get(0);

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
        Wallet wallet = listWallet.get(0);
        wallet.tambahKartu("BNI");
        wallet.tambahKartu("BCA");

        Assertions.assertAll(
                () ->  assertNull(wallet.ambilKartu("BRI"))
        );
    }

    @Test
    void testTambahUangRupiah() {
        Wallet wallet = listWallet.get(0);

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
        Wallet wallet = listWallet.get(0);

        //Cek input kalo mines
        Assertions.assertThrows(Error.class, () -> wallet.tambahUangRupiah(-500));
    }

    @Test
    void testAmbilUang() {
        Wallet wallet = listWallet.get(0);

        wallet.tambahUangRupiah(500);
        wallet.tambahUangRupiah(300);
        wallet.tambahUangRupiah(1500);
        wallet.tambahUangRupiah(2500);

        //Check standard output
        Assertions.assertEquals(500, wallet.ambilUang(500));
        Integer[] expectedKoin = {300};
        Assertions.assertArrayEquals(expectedKoin, wallet.listUangKoin.toArray());

        //Check properti Wallet
        Integer[] expectedLembaran = {1500, 2500};
        Assertions.assertArrayEquals(expectedLembaran, wallet.listUangLembaran.toArray());
    }

    @Test
    void testAmbilUangKosong() {
        Wallet wallet = listWallet.get(0);

        Assertions.assertEquals(0, wallet.ambilUang(500));
    }

    @Test
    void testTampilkanUang() {
        Wallet wallet = listWallet.get(0);

        wallet.tambahUangRupiah(500);
        wallet.tambahUangRupiah(1500);
        wallet.tambahUangRupiah(2500);

        Assertions.assertEquals(4500, wallet.tampilkanUang());
    }

    @Test
    void testTampilkanUangKosong() {
        Wallet wallet = listWallet.get(0);
        Assertions.assertEquals(0, wallet.tampilkanUang());
    }
}