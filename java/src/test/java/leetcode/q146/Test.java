package q146;


import static org.junit.Assert.assertArrayEquals;

/**
 */
public class Test {
    @org.junit.Test
    public void test() {
        String[] cmd = new String[]{"LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"};
        Integer[][] data = {{2}, {1, 1}, {2, 2}, {1}, {3, 3}, {2}, {4, 4}, {1}, {3}, {4}};
        Integer[] right = new Integer[]{null, null, null, 1, null, -1, null, -1, 3, 4};


        Integer[] ret = new Integer[cmd.length];
        LRUCache cache = null;
        for (int i = 0; i < cmd.length; i++) {
            String s = cmd[i];
            if (s.equals("LRUCache")){
                cache = new LRUCache(data[i][0]);
                ret[i] = null;
                continue;
            }
            if (s.equals("put")){
                cache.put(data[i][0],data[i][1]);
                ret[i] = null;
                continue;
            }
            if (s.equals("get")){
                int i1 = cache.get(data[i][0]);
                ret[i] = i1;
                continue;
            }
        }



        assertArrayEquals(ret, right);

    }
}
