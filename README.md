https://community.intuit.com/articles/1192026-bacs-file-layouts-uk-only


To add a bacs transaction record: http://localhost:8080/rest/transaction/add

Headers:
Content-Type: application/json
Accept: application/json

{
    "amount": 11,
    "bankAccountNumber": "432543",
    "accountName": "TestWrite",
    "paymentMethod": 0,
    "outboundBankId": "3423712-53",
    "rtiHash": "hasher",
    "sortNumber": "1111"
}
