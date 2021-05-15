public class Factory{
    public Map<String,String> factory(int opcion){
        switch (opcion){
            case 1 -> { return new SplayTree<String,String>();
            }
            case 2 -> {return new HashMap<String,String>();
            }
        }
        return null;
    }
}
