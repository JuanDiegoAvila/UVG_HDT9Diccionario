import static org.junit.jupiter.api.Assertions.*;

class HashMapTest {

    @org.junit.jupiter.api.Test
    void get() {
        HashMap<String,String> hashMap = new HashMap();
        hashMap.put("Nuevo","Valor");

        assertEquals("Valor",hashMap.get("Nuevo"));
    }

    @org.junit.jupiter.api.Test
    void put() {
        HashMap<String,String> hashMap = new HashMap();
        hashMap.put("Nuevo","Valor");

        assertTrue(hashMap.containsKey("Nuevo"));
    }
}