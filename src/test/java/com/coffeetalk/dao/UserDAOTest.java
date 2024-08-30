package com.coffeetalk.dao;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;

import com.coffeetalk.config.ConnectionManager;
import com.coffeetalk.model.User;
import com.coffeetalk.security.PasswordHasher;

public class UserDAOTest {

    @Mock
    private Connection connection;

    @Mock
    private PreparedStatement preparedStatement;


    private UserDAO userDAO;

    @Before
    public void setUp() throws SQLException {
        MockitoAnnotations.openMocks(this);

        MockedStatic<ConnectionManager> connectionManagerMock = mockStatic(ConnectionManager.class);
        ConnectionManager connectionManager = mock(ConnectionManager.class);
        connectionManagerMock.when(ConnectionManager::getInstance).thenReturn(connectionManager);
        when(connectionManager.getConnection()).thenReturn(connection);

        when(connection.prepareStatement(any(String.class))).thenReturn(preparedStatement);
        when(preparedStatement.executeUpdate()).thenReturn(1);

        MockedStatic<PasswordHasher> passwordHasherMock = mockStatic(PasswordHasher.class);
        passwordHasherMock.when(() -> PasswordHasher.hashPassword(anyString())).thenReturn("hashedPassword");


        this.userDAO = new UserDAO();
    }

    @Test
    public void testCreateUser() throws SQLException, NoSuchAlgorithmException {
        User user = new User("username", "email@gmail.com", "password");

        boolean result = userDAO.create(user);

        assertTrue(result);
        
        verify(preparedStatement).setString(1, user.getUsername());
        verify(preparedStatement).setString(2, user.getEmail());
        verify(preparedStatement).setString(3, "hashedPassword");
        verify(preparedStatement).executeUpdate();
    }
}
