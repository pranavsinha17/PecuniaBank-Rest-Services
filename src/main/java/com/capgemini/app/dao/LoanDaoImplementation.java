package com.capgemini.app.dao;

import java.util.List;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capgemini.app.entity.Account;
import com.capgemini.app.entity.Ledger;
import com.capgemini.app.entity.Request;

/********************************************************************************
 * @author       Amardeep Singh
 * Description   This Dao is for adding loan request,checking whether the
                 the account exists or not,for adding data in loanLedger, for getting loan ledger Details by 
                 the account number,for getting all ledger details.
                
 *Created On
 
 ********************************************************************************/

@Repository
@Transactional
public class LoanDaoImplementation implements LoanDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	/********************************************************************************
	 * Method           insertAccountDetails
	 * Description      for adding data to account
	 * returns           returns null
	 * Created By       Amardeep Singh
	 * Created on
	*********************************************************************************/

	public void insertAccountDetails(Account account)
	{
		entityManager.persist(account);
	}
	
	/********************************************************************************
	 * Method           insertLoanRequest
	 * Description      for adding data to loan request
	 * returns          returns null
	 * Created By       Amardeep Singh
	 * Created on
	*********************************************************************************/

	
	public void insertLoanRequest(Request request)
	{
		entityManager.persist(request);
	}
	

	/********************************************************************************
	 * Method           addRequest
	 * Description      for adding data to loan request
	 * returns boolean   returns true when data is added
	 * Created By       Amardeep Singh
	 * Created on
	*********************************************************************************/
	
	@Override
	public boolean addRequest(Request request) {
		entityManager.persist(request);
		return true;
	}
	
	/********************************************************************************
	 * Method           existAccount
	 * Description      for checking whether the account exists or not
	 * returns list  returns account details if account exists 
	 * 					
	 * Created By        Amardeep Singh
	 * Created on
	**********************************************************************************/

	@Override
	public Account existAccount(String accountNumber)  {
		// TODO Auto-generated method stub
		Account account=entityManager.find(Account.class, accountNumber);
		return account;
	}


	/********************************************************************************
	 * Method           addledger
	 * Description      for adding the ledger data
	 * returns string  returns null when the data is added
	 * 					
	 * Created By       Amardeep Singh
	 * Created on
	**********************************************************************************/
	
	@Override
	public void addledger(Ledger ledger) {
		// TODO Auto-generated method stub
		entityManager.persist(ledger);
	}

	/********************************************************************************
	 * Method           findAccount
	 * Description      for checking whether the account exists or not
	 * returns boolean  returns accountDetails that contains that account number
	 * 					
	 * Created By       Amardeep Singh
	 * Created on
	**********************************************************************************/
	@Override
	public boolean findAccount(String accountNumber) {
		// TODO Auto-generated method stub
		return entityManager.contains(entityManager.find(Account.class, accountNumber));
		
	}

	/********************************************************************************
	 * Method           viewLedger
	 * Description      to view the ledger data by account number
	 * returns list  returns list of ledger data search by account number
	 * 					
	 * Created By       Amardeep Singh
	 * Created on
	**********************************************************************************/
	
	@Override
	public List<Ledger> viewLedger(String accountNumber) {
		
       Query query=entityManager.createQuery("SELECT ledger FROM Ledger ledger WHERE ledger.accountDetails.accountNumber= :account");
       query.setParameter("account", accountNumber);
        @SuppressWarnings("unchecked")
		List<Ledger> ledgerList=query.getResultList();
		return ledgerList;
    }

	//to view all data of ledger
	/********************************************************************************
	 * Method           viewAllLedger
	 * Description      to view the all ledger data
	 * returns list  returns lists of all ledger data
	 * 					
	 * Created By       Amardeep Singh
	 * Created on
	**********************************************************************************/
	
	@Override
	public List<Ledger> viewAllLedger() {
		// TODO Auto-generated method stub
		String Qstr="SELECT ledger FROM Ledger ledger";
		TypedQuery<Ledger> query=entityManager.createQuery(Qstr,Ledger.class);
		List<Ledger> ledgerList=query.getResultList();
		return ledgerList;
	}
	
	

}
