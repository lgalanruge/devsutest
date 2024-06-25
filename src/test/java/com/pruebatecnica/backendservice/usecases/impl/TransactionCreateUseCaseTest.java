package com.pruebatecnica.backendservice.usecases.impl;

import com.pruebatecnica.backendservice.dtos.Account;
import com.pruebatecnica.backendservice.dtos.Transaction;
import com.pruebatecnica.backendservice.services.ITransactionService;
import com.pruebatecnica.backendservice.usecases.IAccountReadUseCase;
import com.pruebatecnica.backendservice.usecases.IAccountUpdateUseCase;
import com.pruebatecnica.backendservice.utils.Status;
import com.pruebatecnica.backendservice.utils.TransactionType;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
class TransactionCreateUseCaseTest {

    @InjectMocks
    TransactionCreateUseCase service ;

    @Mock
    ITransactionService transactionService  ;

    @Mock
    IAccountUpdateUseCase accountUpdateUseCase ;

    @Mock
    IAccountReadUseCase accountReadUseCase ;

    List<Transaction> transactions = new ArrayList<>();

    Transaction transaction = new Transaction();

    Account account = new Account();

    @BeforeAll
    public static void beforeAll() {

        MockitoAnnotations.openMocks(TransactionCreateUseCaseTest.class);
    }

    @BeforeEach
    void setUp() {

        transaction = new Transaction();

        transaction.setType(TransactionType.DEBIT);
        transaction.setDate(LocalDate.now());
        transaction.setAmount(BigDecimal.ZERO);
        transaction.setAccountId("abcdef");
        transaction.setValue(new BigDecimal("1250"));

        transactions.add(transaction);

        transaction = new Transaction();

        transaction.setType(TransactionType.DEBIT);
        transaction.setDate(LocalDate.now());
        transaction.setAmount(BigDecimal.ZERO);
        transaction.setAccountId("abcdef");
        transaction.setValue(new BigDecimal("2510"));
         transactions.add(transaction);

        transaction = new Transaction();

        transaction.setType(TransactionType.CREDIT);
        transaction.setDate(LocalDate.now());
        transaction.setAmount(BigDecimal.ZERO);
        transaction.setAccountId("abcdef");
        transaction.setValue(new BigDecimal("800"));
        transactions.add(transaction);

        account = new Account();
        account.setId("abcdef");
        account.setTransactions(transactions);
        account.setAmount(new BigDecimal(1000));
        account.setAccountNumber(123456L);
        account.setStatus(Status.ACTIVE);

    }

    @AfterEach
    void tearDown() {
    }

    @DisplayName("validar retorno fallo cuando no existe cuentas asociadas al crear ")
    @Test
    void checkFailedWhenThereIsNotAccounts() {
        // given - dado a condicion


        Mockito
                .when(accountReadUseCase.getById(Mockito.any()))
                .thenReturn(null);


        // when - cuando

        Assertions.assertThrows(IllegalArgumentException.class, () -> service.create(transactions)) ;


        // then - entonces

    }

    @DisplayName("validar retorno fallo cuando no hay saldo para retirar ")
    @Test
    void checkFailedWhenThereIsNotAmountOnAccount() {
        // given - dado a condicion

        account.setAmount(new BigDecimal(-1500));

        Mockito
                .when(accountReadUseCase.getById(Mockito.any()))
                .thenReturn(account);


        // when - cuando

        Assertions.assertThrows(IllegalArgumentException.class, () -> service.create(transactions)) ;


        // then - entonces

    }

    @DisplayName("validar que las transacciones se guarden correctamente ")
    @Test
    void checkUpdateAmountOnAccount() {
        // given - dado a condicion

        Mockito
                .when(accountReadUseCase.getById(Mockito.any()))
                .thenReturn(account);

        Mockito
                .when(accountUpdateUseCase.update(Mockito.any()))
                .thenReturn(List.of(account)) ;

        Mockito.
                when(transactionService.save(Mockito.any()))
                .thenReturn(transactions);


        // when - cuando

        List<Transaction> transactions1 = service.create(transactions) ;

        assertEquals(3, transactions1.size());


        // then - entonces

        // Mockito.verify(accountReadUseCase).getById(Mockito.any());
        // Mockito.verify(accountUpdateUseCase).update(Mockito.any());

    }



}