package com.sb.algorithms.algoexpert;

import org.junit.jupiter.api.Test;

import static com.sb.algorithms.algoexpert.CaesarCypherEncryptor.caesarCypherEncryptor;
import static org.junit.jupiter.api.Assertions.*;

class CaesarCypherEncryptorTest {
    @Test
    public void TestCase1() {
        assertTrue(caesarCypherEncryptor("abc", 0).equals("abc"));
    }

    @Test
    public void TestCase2() {
        assertTrue(caesarCypherEncryptor("abc", 3).equals("def"));
    }

    @Test
    public void TestCase3() {
        assertTrue(caesarCypherEncryptor("xyz", 2).equals("zab"));
    }

    @Test
    public void TestCase4() {
        assertTrue(caesarCypherEncryptor("xyz", 5).equals("cde"));
    }

    @Test
    public void TestCase5() {
        assertTrue(caesarCypherEncryptor("abc", 26).equals("abc"));
    }

    @Test
    public void TestCase6() {
        assertTrue(caesarCypherEncryptor("abc", 52).equals("abc"));
    }

    @Test
    public void TestCase7() {
        assertTrue(caesarCypherEncryptor("abc", 57).equals("fgh"));
    }

}