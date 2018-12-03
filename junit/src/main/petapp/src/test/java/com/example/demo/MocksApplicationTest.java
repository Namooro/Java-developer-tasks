package com.example.demo;

import com.example.demo.model.Account;
import com.example.demo.model.User;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AccountService;
import com.example.demo.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MocksApplicationTest {

    private Account account;

    private User user;

    @Mock
    private UserRepository userRepository;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private AccountService accountService;

    @Mock
    UserService userService;
    String mail = "mail";
    String userName = "username";

    @Before
    public void setUp() throws Exception {
        assertNotNull(userService);

        when(userService.checkUserExists(userName, mail)).thenReturn(true);

      /*  when(c.prepareStatement(any(String.class))).thenReturn(stmt);
        when(ds.getConnection()).thenReturn(c);

        when(rs.first()).thenReturn(true);
        when(rs.getInt(1)).thenReturn(1);
        when(rs.getString(2)).thenReturn(p.getFirstName());
        when(rs.getString(3)).thenReturn(p.getLastName());
        when(stmt.executeQuery()).thenReturn(rs);*/
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
