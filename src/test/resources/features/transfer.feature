Feature: Test

	@transfer
	@ListTransfer
	Scenario Outline: List Transfer
		Given I send a get request to "transfer" using before date "<after_date>" and after date "<before_date>"
		Then validate the status code 200 and the response contains "amount"
	
	Examples:
		| after_date	| before_date	|
		| 2020-04-01	| 2020-04-30	|
