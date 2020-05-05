package com.cg.pecuniabank.passbook.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.cg.pecuniabank.passbook.dao.AccountDAO;
import com.cg.pecuniabank.passbook.dao.PassbookDAO;
import com.cg.pecuniabank.passbook.dao.TransactionDAO;
import com.cg.pecuniabank.passbook.entity.AccountDetails;
import com.cg.pecuniabank.passbook.entity.PassbookUpdate;
import com.cg.pecuniabank.passbook.entity.Transaction;
import com.cg.pecuniabank.passbook.exception.AccountDoesntExistException;
import com.cg.pecuniabank.passbook.exception.TransactionFailedException;
import com.cg.pecuniabank.passbook.service.PassbookServiceImpl;

public class PassbookServiceImplTest {

	@Mock
	AccountDAO accountDao;
	
	@Mock
	TransactionDAO transactionDao;
	
	@Mock
	PassbookDAO passbookDao;

	@InjectMocks
	PassbookServiceImpl passbookServiveImpl;

	@Before
	public void setup() {
		initMocks(this);
	}

	@Test(expected = AccountDoesntExistException.class)
	public void getAccountDetailsByAccountIdTest_will_throw_AccountDoesntExistException() throws AccountDoesntExistException {
		// given
		long accountNumber = 123456789012L;
		// when
		when(accountDao.getAccountDetailsByAccountId(Mockito.anyLong())).thenReturn(null);
		//then 
		passbookServiveImpl.getAccountDetailsByAccountId(accountNumber);
	}
	
	@Test
	public void getAccountDetailsByAccountIdTest_will_throw_AccountDoesntExistException_and_check_errorMessage() {
		// given
		long accountNumber = 123456789012L;
		String expectedMessage="Account Doesn't Exist.Please Enter the Valid Account Number.";
		String actualMessage =" ";
		
		
		//accountDetails
		when(accountDao.getAccountDetailsByAccountId(Mockito.anyLong())).thenReturn(null);
		// when
		try {
			passbookServiveImpl.getAccountDetailsByAccountId(accountNumber);
		} catch (AccountDoesntExistException e) {
			actualMessage = e.getMessage();
		}
		assertEquals(expectedMessage, actualMessage);
	}
	


    @Test(expected = TransactionFailedException.class)
	public void getAccountTransactionDetailsTest_will_throw_exception_when_no_transaction() throws AccountDoesntExistException, TransactionFailedException
	{
		//given
		long accountNumber =123456781201L;
		//when 
		AccountDetails accountDetails=new AccountDetails();
		
		when(accountDao.getAccountDetailsByAccountId(Mockito.anyLong())).thenReturn(accountDetails);
		
    	List<Transaction> transactionList =new ArrayList<Transaction>();
    	//when
    	when(transactionDao.getAccountTransactionDetails(Mockito.anyLong())).thenReturn(transactionList);
    	
    	passbookServiveImpl.getAccountTransactionDetails(accountNumber);
	}
    
    @Test
    public void getAccountTransactionDetailsTest_will_return_transaction_list() throws AccountDoesntExistException, TransactionFailedException 
    {
    	//given 
    	long accountNumber=123456781201L;
    	AccountDetails accountDetails=new AccountDetails();
    	//when
    	when(accountDao.getAccountDetailsByAccountId(Mockito.anyLong())).thenReturn(accountDetails);
    	passbookServiveImpl.getAccountDetailsByAccountId(accountNumber);
    	
    	List<Transaction> transactionList=new ArrayList<Transaction>();
    	transactionList.add(createTransaction(accountNumber, 123456));
    	
    	//when
    	when(transactionDao.getAccountTransactionDetails(Mockito.anyLong())).thenReturn(transactionList);
    	
    	List<Transaction> transactions = passbookServiveImpl.getAccountTransactionDetails(accountNumber);
    	
    	assertTrue(1 <= transactions.size());
    	
    }

    @Test(expected = TransactionFailedException.class)
    public void getAccountTransactionByDateRangeTest_throw_exception_when_noTransaction() throws TransactionFailedException, AccountDoesntExistException  
    {
        //given
    	long accountNumber=123456781201L;
    	LocalDateTime fromDate=LocalDateTime.of(2019, 05, 01, 02, 55, 29);
    	LocalDateTime toDate=LocalDateTime.of(2019, 06, 06, 10, 25, 29);
    	AccountDetails accountDetails=new AccountDetails();
    	//when
    	when(accountDao.getAccountDetailsByAccountId(Mockito.anyLong())).thenReturn(accountDetails);
    
    	List<Transaction> transactionList=new ArrayList<Transaction>();
    	
    	when(transactionDao.getAccountTransactionByDateRange
    			(Mockito.anyLong(),Mockito.any(LocalDateTime.class), Mockito.any(LocalDateTime.class))).thenReturn(transactionList);
    	
    	passbookServiveImpl.getAccountTransactionByDateRange(accountNumber, fromDate, toDate);
    }
    
    
    @Test(expected =TransactionFailedException.class )
    public void  getAccountTransactionByDateRangeTest_will_throw_exception_when_fromDate_isGt_toDate() throws TransactionFailedException, AccountDoesntExistException 
    {
        //given
    	long accountNumber=123456781201L;
    	LocalDateTime fromDate=LocalDateTime.of(2019, 05, 01, 02, 55, 29);
    	LocalDateTime toDate=LocalDateTime.of(2019, 03, 06, 10, 25, 29);
    	AccountDetails accountDetails=new AccountDetails();
    	//when
    	when(accountDao.getAccountDetailsByAccountId(Mockito.anyLong())).thenReturn(accountDetails);
    	
    	//when 
    	passbookServiveImpl.getAccountTransactionByDateRange(accountNumber, fromDate, toDate);    	
    }    
    
    @Test
    public void  getAccountTransactionByDateRangeTest_will_return_transaction_list() throws TransactionFailedException, AccountDoesntExistException 
    {
        //given
    	long accountNumber=123456781201L;
    	LocalDateTime fromDate=LocalDateTime.of(2019, 05, 01, 02, 55, 29);
    	LocalDateTime toDate=LocalDateTime.of(2019, 06, 06, 10, 25, 29);
    	AccountDetails accountDetails=new AccountDetails();
    	
    	List<Transaction> transactionList=new ArrayList<Transaction>();
    	transactionList.add(createTransaction(accountNumber, 125436));
    	
    	//when
    	when(accountDao.getAccountDetailsByAccountId(Mockito.anyLong())).thenReturn(accountDetails);
    	
    	//when
    	when(transactionDao.getAccountTransactionByDateRange(Mockito.anyLong(), Mockito.any(LocalDateTime.class), Mockito.any(LocalDateTime.class))).thenReturn(transactionList);
    	
    	List<Transaction> transactionList1=passbookServiveImpl.getAccountTransactionByDateRange(accountNumber, fromDate, toDate);
    	assertTrue(1<=transactionList1.size());
    	
    } 
    @Test
    public void passbookUpdateDetailsByAccountNumberTest_will_return_passbook_update_details() throws AccountDoesntExistException 
    {

        //given
    	long accountNumber=123456781201L;
    	AccountDetails accountDetails=new AccountDetails();
    	accountDetails.setOpeningDate(LocalDateTime.of(2019, 03, 11, 06 , 50, 30));
    	//when
    	when(accountDao.getAccountDetailsByAccountId(Mockito.anyLong())).thenReturn(accountDetails);
    	
    	when(passbookDao.passbookUpdateDetailsByAccountNumber(accountNumber)).thenReturn(null);
    	PassbookUpdate passbookUpdateDetails=passbookServiveImpl.passbookUpdateDetailsByAccountNumber(accountNumber);
    	assertNotNull(passbookUpdateDetails);
    	    	
    }
    
    
    @Test
    public void getTransactionDetailsAfterLastUpdateDateTest_will_return_transactionList() throws TransactionFailedException
    {
    	long accountNumber=123456781201L;
    	LocalDateTime lastUpdatedDate=LocalDateTime.of(2019, 03, 11, 06 , 50, 30);
    	
    	List<Transaction> transactionList=new ArrayList<Transaction>();
    	transactionList.add(createTransaction(accountNumber,112106));
    	
    	when(transactionDao.getTransactionDetailsAfterLastUpdateDate(Mockito.anyLong(),Mockito.any(LocalDateTime.class))).thenReturn(transactionList);
    	
    	List<Transaction> transactionList1=passbookServiveImpl.getTransactionDetailsAfterLastUpdateDate(accountNumber, lastUpdatedDate);
    	assertTrue(1<=transactionList1.size());
    }
    
    
    @Test(expected = TransactionFailedException.class) 
    public void getTransactionDetailsAfterLastUpdateDateTest_will_throw_TransactionFailedException() throws TransactionFailedException
    {
    	long accountNumber=123456781201L;
    	LocalDateTime lastUpdatedDate=LocalDateTime.of(2019, 03, 11, 06 , 50, 30);
    	List<Transaction> transactionList=new ArrayList<Transaction>();
    	
    	when(transactionDao.getTransactionDetailsAfterLastUpdateDate(Mockito.anyLong(),Mockito.any(LocalDateTime.class))).thenReturn(transactionList);
    	
    	passbookServiveImpl.getTransactionDetailsAfterLastUpdateDate(accountNumber, lastUpdatedDate);
    }
    
    private Transaction createTransaction(long accountNumber, int transactionId) {
		Transaction transaction1=new Transaction();
    	transaction1.setAccountNumber(accountNumber);
    	transaction1.setBankName("PECUNIA  LPU");
    	transaction1.setBenificaryAccoountNumber("123456789901L");
    	transaction1.setTransactionAmount("2000");
    	transaction1.setTransactionId(transactionId);
    	transaction1.setTransactionDate(LocalDateTime.of(LocalDate.of(2019, 03, 01), LocalTime.of(11, 25, 30)));
		return transaction1;
	}    
}
