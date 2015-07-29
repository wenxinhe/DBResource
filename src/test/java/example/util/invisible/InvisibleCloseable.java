package example.util.invisible;

import example.util.DBResourceTest;

import java.sql.SQLException;

class InvisibleCloseable implements DBResourceTest.MyCloseable {
    public boolean isClosed;

    public synchronized void close() throws SQLException {
        isClosed = true;
    }

    @Override
    public boolean isClosed() {
        return isClosed;
    }
}
