package example.util;

import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static example.util.DBResource.DBResource;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.internal.matchers.StringContains.containsString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DBResourceTest {
    @Test
    public void should_close_Connection_OK() throws Exception {
        // given
        Connection connection = mock(Connection.class);

        // when
        DBResource(connection).close();

        // then
        verify(connection).close();
    }

    @Test
    public void should_close_null_Connection_OK() throws Exception {
        // given
        Connection connection = null;

        // when
        DBResource(connection).close();

        // then
        assertTrue("close OK", true);
    }

    @Test
    public void should_close_Statement_OK() throws Exception {
        // given
        Statement statement = mock(Statement.class);

        // when
        DBResource(statement).close();

        // then
        verify(statement).close();
    }

    @Test
    public void should_close_null_Statement_OK() throws Exception {
        // given
        Statement statement = null;

        // when
        DBResource(statement).close();

        // then
        assertTrue("close OK", true);
    }

    @Test
    public void should_close_ResultSet_OK() throws Exception {
        // given
        ResultSet resultSet = mock(ResultSet.class);

        // when
        DBResource(resultSet).close();

        // then
        verify(resultSet).close();
    }

    @Test
    public void should_close_null_ResultSet_OK() throws Exception {
        // given
        ResultSet resultSet = null;

        // when
        DBResource(resultSet).close();

        // then
        assertTrue("close OK", true);
    }

    @Test
    public void should_throw_exception_when_object_has_no_close_method() throws Exception {
        // given
        Object objectHasNoCloseMethod = new Object();

        try {
            // when
            new DBResource(objectHasNoCloseMethod).close();
            fail();
        } catch (IllegalStateException e) {
            // then
            assertThat(e.getMessage(), containsString("NoSuchMethodException"));
            assertThat(e.getMessage(), containsString("close()"));
        }
    }
}