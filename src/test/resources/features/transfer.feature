Feature: Test

	@transfer
	@ListTransfer
	Scenario Outline: List Transfer
		Given I send a get request to "transfer" using before date "<after_date>" and after date "<before_date>"
		Then validate the status code 200 and the response contains "amount"
	
	Examples:
		| after_date	| before_date	|
		| 2020-04-01	| 2020-04-30	|

	
	@transfer
	@CreateTransfer
	Scenario: Create Transfer
		Given I send a post request to "transfer" with the following data
			| name					| amount	| taxid				| bankCode	| branchCode	| accountNumber	|
			| Daenerys Targaryen	| 1000000	| 123.456.789-10	| 20018183	| 2201			| 10000-0		|
		Then validate the status code 201 and the response contains "amount"