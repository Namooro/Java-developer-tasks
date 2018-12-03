package com.example.demo;

import com.example.demo.model.Account;
import com.example.demo.model.User;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * This test class shows usage of Mockito framework
 * */
@RunWith(MockitoJUnitRunner.class)
public class MocksApplicationTest {

    private Account account;

    private User user;

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    UserService userService;
    String mail = "mail";
    String userName = "username";

    @Before
    public void setUp() {
        assertNotNull(userService);
        when(userService.checkUserExists(userName, mail)).thenReturn(true);
    }

    @Test(timeout = 1000)
    public void checkUserCreation() {
        assertTrue(userService.checkUserExists(userName, mail));
    }

    @Test(expected = NullPointerException.class)
    public void accountNotCreated() {
        assertNotNull(user.getAccount());
    }

    @Test
    public void transactionSizeCheck() {
        assertEquals(0, transactionRepository.findByAccountAccountNumber(0).size());
    }
}
