package example.util.invisible;

import example.util.DBResourceTest;

public class InvisibleCloseableFactory {

    public DBResourceTest.MyCloseable getInvisibleCloseable(){
        return new InvisibleCloseable();
    }

}
