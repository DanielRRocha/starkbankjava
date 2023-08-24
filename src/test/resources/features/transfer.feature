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
	Scenario Outline: Create Transfer
		Given I send a post request to "transfer" with the following data
			| name		| amount	| taxid		| bankCode		| branchCode	| accountNumber		|
			| <name>	| <amount>	| <taxid>	| <bankCode>	| <branchCode>	| <accountNumber>	|
		Then validate the status code 201 and the response contains "amount"
		
	Examples:
		| name					| amount	| taxid				| bankCode	| branchCode	| accountNumber	|
		| Aegon Targaryen		| 710		| 123.456.789-10	| 20722264	| 2201			| 10000-0		|
		| Maegor Targaryen		| 495		| 987.654.321-01	| 20579845	| 2201			| 17770-6		|
		| Daenerys Targaryen	| 671		| 474.637.800-23	| 20606103	| 2201			| 10649-1		|
		| Aerys Targaryen		| 123		| 365.003.150-73	| 20213029	| 2201			| 10741-9		|
		| Baelon Targaryen		| 873		| 589.744.430-74	| 20663306	| 2201			| 12838-2		|
		| Rhaegar Targaryen		| 980		| 995.953.780-38	| 20848310	| 2201			| 15271-7		|
		| Jaehaerys Targaryen	| 671		| 873.130.560-10	| 20927240	| 2201			| 19000-0		|
		| Valerion Targaryen	| 65		| 987.337.190-71	| 20977780	| 2201			| 16529-3		|
		| Shaera Targaryen		| 618		| 496.860.770-90	| 20192881	| 2201			| 11091-9		|
		| Daemon Targaryen		| 199		| 137.789.360-00	| 20226110	| 2201			| 13395-5		|