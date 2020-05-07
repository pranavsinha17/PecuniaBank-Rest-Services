package com.capgemini.main.Dao;

import java.util.List;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capgemini.main.entity.AccountDetails;
import com.capgemini.main.entity.LoanLedger;
import com.capgemini.main.entity.LoanRequest;

/********************************************************************************
 * @author       Amardeep Singh
 * Description   This Dao is for adding loan request,checking whether the
                 the account exists or not,for adding data in loanLedger, for getting loan ledger Details by 
                 the account number,for getting all ledger details.
                
 *Created On     22-04-2020
 
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
	 * Created on       22-04-2020
	*********************************************************************************/

	public void insertAccountDetails(AccountDetails account)
	{
		entityManager.persist(account);
	}
	
	/********************************************************************************
	 * Method           insertLoanRequest
	 * Description      for adding data to loan request
	 * returns          returns null
	 * Created By       Amardeep Singh
	 * Created on       22-04-2020
	*********************************************************************************/

	
	public void insertLoanRequest(LoanRequest request)
	{
		entityManager.persist(request);
	}
	

	/********************************************************************************
	 * Method           addRequest
	 * Description      for adding data to loan request
	 * returns boolean   returns true when data is added
	 * Created By       Amardeep Singh
	 * Created on       22-04-2020
	*********************************************************************************/
	
	@Override
	public boolean addRequest(LoanRequest request) {
		entityManager.persist(request);
		return true;
	}
	
	/********************************************************************************
	 * Method           existAccount
	 * Description      for checking whether the account exists or not
	 * returns list  returns account details if account exists 
	 * 					
	 * Created By        Amardeep Singh
	 * Created on        22-04-2020
	**********************************************************************************/

	@Override
	public AccountDetails existAccount(String accountNumber)  {
		AccountDetails account=entityManager.find(AccountDetails.class, accountNumber);
		return account;
	}


	/********************************************************************************
	 * Method           addledger
	 * Description      for adding the ledger data
	 * returns string  returns null when the data is added
	 * 					
	 * Created By       Amardeep Singh
	 * Created on       22-04-2020
	**********************************************************************************/
	
	@Override
	public void addledger(LoanLedger ledger) {
		entityManager.persist(ledger);
	}

	/********************************************************************************
	 * Method           findAccount
	 * Description      for checking whether the account exists or not
	 * returns boolean  returns accountDetails that contains that account number
	 * 					
	 * Created By       Amardeep Singh
	 * Created on       22-04-2020
	**********************************************************************************/
	@Override
	public boolean findAccount(String accountNumber) {
		return entityManager.contains(entityManager.find(AccountDetails.class, accountNumber));
		
	}

	/********************************************************************************
	 * Method           viewLedger
	 * Description      to view the ledger data by account number
	 * returns list  returns list of ledger data search by account number
	 * 					
	 * Created By       Amardeep Singh
	 * Created on       22-04-2020
	**********************************************************************************/
	
	@Override
	public List<LoanLedger> viewLedger(String accountNumber) {
		
       Query query=entityManager.createQuery("SELECT ledger FROM Ledger ledger WHERE ledger.accountDetails.accountNumber= :account");
       query.setParameter("account", accountNumber);
        @SuppressWarnings("unchecked")
		List<LoanLedger> ledgerList=query.getResultList();
		return ledgerList;
    }

	/********************************************************************************
	 * Method           viewAllLedger
	 * Description      to view the all ledger data
	 * returns list  returns lists of all ledger data
	 * 					
	 * Created By       Amardeep Singh
	 * Created on       22-04-2020
	**********************************************************************************/
	
	@Override
	public List<LoanLedger> viewAllLedger() {
		String Qstr="SELECT ledger FROM Ledger ledger";
		TypedQuery<LoanLedger> query=entityManager.createQuery(Qstr,LoanLedger.class);
		List<LoanLedger> ledgerList=query.getResultList();
		return ledgerList;
	}
	
	

}
