import static org.junit.jupiter.api.Assertions.*;

class SplayTreeTest {

    @org.junit.jupiter.api.Test
    void get() {
        SplayTree<String,String> hashMap = new SplayTree();
        hashMap.put("Nuevo","Valor");

        assertEquals("Valor",hashMap.get("Nuevo"));

    }

    @org.junit.jupiter.api.Test
    void put() {
        SplayTree<String,String> hashMap = new SplayTree();
        hashMap.put("Nuevo","Valor");

        assertTrue(hashMap.containsKey("Nuevo"));
    }
}