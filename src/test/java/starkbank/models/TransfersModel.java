package starkbank.models;

public class TransfersModel {

	private String name;
	private int amount;
	private String taxid;
	private String bankCode;
	private String branchCode; 
	private String accountNumber;
	
	public TransfersModel(String name, int amount, String taxid, String bankCode, String branchCode,
			String accountNumber) {
		super();
		this.name = name;
		this.amount = amount;
		this.taxid = taxid;
		this.bankCode = bankCode;
		this.branchCode = branchCode;
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public int getAmount() {
		return amount;
	}

	public String getTaxid() {
		return taxid;
	}

	public String getBankCode() {
		return bankCode;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public String getAccountNumber() {
		return accountNumber;
	}
	
	
	
}
