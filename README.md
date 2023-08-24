# Stark Bank Challange
Use the Java as a programming language and Rest Assured framework for API testing

## Test cases created
Created 2 test cases:
* List Transfers
* Create Transfer

### List Transfers
    get ("/transfer")
    params:
    - after_date
    - before_date
    run one time per execution

### Create Transfer
    post ("/transfer")
    params: 
    - name
    - amount
    - taxid
    - bankCode
    - branchCode
    - accountNumber	
    run ten times per execution